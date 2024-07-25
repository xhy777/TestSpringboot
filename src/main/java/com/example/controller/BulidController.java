package com.example.controller;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entities.Build;
import com.example.entities.Employments;
import com.example.mapper.BuildMapper;
import com.example.models.BuildModel;
import com.example.models.EmploymentModel;
import com.example.service.BuildSevice;
import com.example.utils.RestResponse;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/build")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BulidController {
    public final BuildSevice buildSevice;
    public final BuildMapper buildMapper;

    @RequestMapping("/getLists")
    public RestResponse<Page<Build>> getAllBuild(BuildModel param) {
        Page<Build> bulidPage = buildSevice.getLists(param);
        return RestResponse.ok(bulidPage);
    }

    @RequestMapping("/getEmpById")
    public RestResponse<Build> getEmpById(String bid) {
        List<Build> alist = new ArrayList<>();
        if (bid == null || bid.equals("")) {
            return RestResponse.fail("ID不能为空值哦！！！");
        } else {
            Build empOne = buildSevice.getById(bid);
            alist.add(empOne);
            return RestResponse.ok(empOne);
        }
    }

    @RequestMapping("/add")
    public RestResponse addBulid(BuildModel param) {
        Build addResult = buildSevice.addBuild(param);
        if (addResult != null) {
            return RestResponse.ok(param);
        }
        return RestResponse.fail();
    }

    @RequestMapping("update")
    public RestResponse updateBuild(BuildModel param) {
        String upStr = buildSevice.updateBuild(param);
        if (upStr != null) {
            return RestResponse.fail();
        }
        return RestResponse.ok(param);
    }

    @RequestMapping("delete")
    public RestResponse deleteBuild(String bid) {
        return buildSevice.delBuildById(Integer.parseInt(bid));
    }

    /**
     * excel文件导出接口
     *
     * @param response
     * @throws Exception
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        //获取要导出的数据
        ArrayList<Build> builds = buildMapper.selectAllBuild();
        //用excel写入器,写到浏览器
        try (ExcelWriter writer = ExcelUtil.getWriter(true)) {
            //一次写到excel
            writer.write(builds, true);
            //设置浏览器响应格式
            response.setContentType("application/vnd.openxmlformats-officedocument." +
                    "spreadsheetml.sheet;charset=utf-8");
            String fileName = URLEncoder.encode("建筑信息", "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName +
                    ".xlsx");
            //返回到浏览器
            try (ServletOutputStream outputStream = response.getOutputStream()) {
                //刷新到数据流中
                writer.flush(outputStream, true);

                outputStream.close();

                writer.close();
            }
        }
    }
}
