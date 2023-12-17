package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entities.Build;
import com.example.mapper.BuildMapper;
import com.example.models.BuildModel;
import com.example.utils.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Service
@RequiredArgsConstructor
public class BuildSevice extends ServiceImpl<BuildMapper, Build> {
    public Page<Build> getLists(BuildModel buildModel){
        Integer current = buildModel.getCurrent();
        Integer size = buildModel.getSize();
        Build emp = new Build();
        QueryWrapper<Build> buildQueryWrapper = new QueryWrapper<>();
        buildQueryWrapper.setEntity(emp);
        return baseMapper.selectPage(Page.of(current,size),buildQueryWrapper);
    }

    public Build addBuild(BuildModel addModel){
        Build emp = new Build();
        emp.setBid(addModel.getBid());
        emp.setBunit(addModel.getBunit());
        emp.setBfloor(addModel.getBfloor());
        emp.setBnumber(addModel.getBnumber());
        emp.setBarea(addModel.getBarea());
        try {
            baseMapper.insert(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return emp;
    }

    public String updateBuild(BuildModel updateModel){
        Integer bid = updateModel.getBid();
        if (bid == null){
            return "ID不能为空哦！！！";
        }
        else {
            Build emp = new Build();
            emp.setBid(bid);
            if (updateModel.getBunit()!=null){
                emp.setBunit(updateModel.getBunit());
            }
            if (updateModel.getBfloor()!=null){
                emp.setBfloor(updateModel.getBfloor());
            }
            if (updateModel.getBnumber()!=null ){
                emp.setBnumber(updateModel.getBnumber());
            }
            if (updateModel.getBarea()!=null ){
                emp.setBarea(updateModel.getBarea());
            }
            baseMapper.updateById(emp);
            return null;
        }

    }


    private boolean delBuildById(Serializable id){
        return super.removeById(id);
    }
    @RequestMapping("/deleteById")
    public RestResponse delBuildById(Integer id){
        if (id == null ){
            return RestResponse.fail("ID是无效的哦！！！");
        }
        boolean del = removeById(id);
        if (del){
            return RestResponse.ok(id);
        }else {
            return RestResponse.fail();
        }
    }
}
