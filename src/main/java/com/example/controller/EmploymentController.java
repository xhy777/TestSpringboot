package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entities.Employments;
import com.example.models.EmploymentModel;
import com.example.utils.RestResponse;
import com.example.service.EmploymentSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employment")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EmploymentController {
    public final EmploymentSevice employmentSevice;
    @RequestMapping("/getLists")
    public RestResponse<Page<Employments>> getAllEmployment(EmploymentModel param){
        Page<Employments> employmentsPage = employmentSevice.getLists(param);
        return RestResponse.ok(employmentsPage);
    }
    @RequestMapping("/getEmpById")
    public RestResponse<Employments> getEmpById(String eid){
        List<Employments> alist = new ArrayList<>();
        if (eid == null || eid.equals("")){
            return RestResponse.fail("ID不能为空值哦！！！");
        }
        else {
            Employments empOne = employmentSevice.getById(eid);
            alist.add(empOne);
            return RestResponse.ok(empOne);
        }
    }

    @RequestMapping("/add")
    public RestResponse addEmployment(EmploymentModel param){
        Employments addResult = employmentSevice.addEmployment(param);
        if (addResult != null){
            return RestResponse.ok(param);
        }
        return RestResponse.fail();
    }
    @RequestMapping("update")
    public RestResponse updateEmployment(EmploymentModel param){
        String upStr = employmentSevice.updateEmployment(param);
        if (upStr != null){
            return RestResponse.fail();
        }
        return RestResponse.ok(param);
    }
    @RequestMapping("delete")
    public RestResponse deleteEmployment(String eid){
        return employmentSevice.delEmploymentById(Integer.parseInt(eid));
    }
}
