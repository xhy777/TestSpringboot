package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entities.Employments;
import com.example.mapper.EmploymentMapper;
import com.example.models.EmploymentModel;
import com.example.utils.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Service
@RequiredArgsConstructor
public class EmploymentSevice extends ServiceImpl<EmploymentMapper, Employments> {
    public Page<Employments> getLists(EmploymentModel employmentModel){
        Integer current = employmentModel.getCurrent();
        Integer size = employmentModel.getSize();
        Employments emp = new Employments();
        QueryWrapper<Employments> employmentsQueryWrapper = new QueryWrapper<>();
        employmentsQueryWrapper.setEntity(emp);
        return baseMapper.selectPage(Page.of(current,size),employmentsQueryWrapper);
    }

    public Employments addEmployment(EmploymentModel addModel){
        Employments emp = new Employments();
        emp.setEid(addModel.getEid());
        emp.setEname(addModel.getEname());
        emp.setSex(addModel.getSex());
        emp.setEage(addModel.getEage());
        emp.setIdcard(addModel.getIdcard());
        emp.setEaddr(addModel.getEaddr());
        try {
            baseMapper.insert(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return emp;
    }

    public String updateEmployment(EmploymentModel updateModel){
        Integer eid = updateModel.getEid();
        if (eid == null){
            return "ID不能为空哦！！！";
        }
        else {
            Employments emp = new Employments();
            emp.setEid(eid);
            if (updateModel.getEname()!=null && updateModel.getEname().length()!=0){
                emp.setEname(updateModel.getEname());
            }
            if (updateModel.getEage()!=null){
                emp.setEage(updateModel.getEage());
            }
            if (updateModel.getIdcard()!=null && updateModel.getIdcard().length()!=0){
                emp.setIdcard(updateModel.getIdcard());
            }
            if (updateModel.getEaddr()!=null && updateModel.getEaddr().length()!=0){
                emp.setEaddr(updateModel.getEaddr());
            }
            baseMapper.updateById(emp);
            return null;
        }

    }


    private boolean delEmploymentById(Serializable id){
        return super.removeById(id);
    }
    @RequestMapping("/deleteById")
    public RestResponse delEmploymentById(Integer id){
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

