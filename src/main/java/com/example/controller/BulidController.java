package com.example.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entities.Build;
import com.example.entities.Employments;
import com.example.models.BuildModel;
import com.example.models.EmploymentModel;
import com.example.service.BuildSevice;
import com.example.utils.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/build")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BulidController {
    public final BuildSevice buildSevice;
    @RequestMapping("/getLists")
    public RestResponse<Page<Build>> getAllBuild(BuildModel param){
        Page<Build> bulidPage = buildSevice.getLists(param);
        return RestResponse.ok(bulidPage);
    }
    @RequestMapping("/getEmpById")
    public RestResponse<Build> getEmpById(String bid){
        List<Build> alist = new ArrayList<>();
        if (bid == null || bid.equals("")){
            return RestResponse.fail("ID不能为空值哦！！！");
        }
        else {
            Build empOne = buildSevice.getById(bid);
            alist.add(empOne);
            return RestResponse.ok(empOne);
        }
    }

    @RequestMapping("/add")
    public RestResponse addBulid(BuildModel param){
        Build addResult = buildSevice.addBuild(param);
        if (addResult != null){
            return RestResponse.ok(param);
        }
        return RestResponse.fail();
    }
    @RequestMapping("update")
    public RestResponse updateBuild(BuildModel param){
        String upStr = buildSevice.updateBuild(param);
        if (upStr != null){
            return RestResponse.fail();
        }
        return RestResponse.ok(param);
    }
    @RequestMapping("delete")
    public RestResponse deleteBuild(String bid){
        return buildSevice.delBuildById(Integer.parseInt(bid));
    }
}
