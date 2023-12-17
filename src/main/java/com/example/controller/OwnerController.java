package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entities.Employments;
import com.example.entities.Owner;
import com.example.models.EmploymentModel;
import com.example.models.OwnerModel;
import com.example.service.EmploymentSevice;
import com.example.service.OwnerSevice;
import com.example.utils.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class OwnerController {
    public final OwnerSevice ownerSevice;
    @RequestMapping("/getLists")
    public RestResponse<Page<Owner>> getAllOwner(OwnerModel param){
        Page<Owner> ownerPage = ownerSevice.getLists(param);
        return RestResponse.ok(ownerPage);
    }
    @RequestMapping("/getEmpById")
    public RestResponse<Owner> getOwnById(String pid){
        List<Owner> alist = new ArrayList<>();
        if (pid == null || pid.equals("")){
            return RestResponse.fail("ID不能为空值哦！！！");
        }
        else {
            Owner empOne = ownerSevice.getById(pid);
            alist.add(empOne);
            return RestResponse.ok(empOne);
        }
    }

    @RequestMapping("/add")
    public RestResponse addOwner(OwnerModel param){
        Owner addResult = ownerSevice.addOwner(param);
        if (addResult != null){
            return RestResponse.ok(param);
        }
        return RestResponse.fail();
    }
    @RequestMapping("update")
    public RestResponse updateOwner(OwnerModel param){
        String upStr = ownerSevice.updateOwner(param);
        if (upStr != null){
            return RestResponse.fail();
        }
        return RestResponse.ok(param);
    }
    @RequestMapping("delete")
    public RestResponse deleteOwner(String pid){
        return ownerSevice.delOwnerById(Integer.parseInt(pid));
    }
}
