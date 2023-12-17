package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entities.Employments;
import com.example.entities.Owner;
import com.example.mapper.OwnerMapper;
import com.example.models.EmploymentModel;
import com.example.models.OwnerModel;
import com.example.utils.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Service
@RequiredArgsConstructor
public class OwnerSevice extends ServiceImpl<OwnerMapper, Owner> {
    public Page<Owner> getLists(OwnerModel owner){
        Integer current = owner.getCurrent();
        Integer size = owner.getSize();
        Owner owner1 = new Owner();
        QueryWrapper<Owner> OwnerQueryWrapper = new QueryWrapper<>();
        OwnerQueryWrapper.setEntity(owner1);
        return baseMapper.selectPage(Page.of(current,size),OwnerQueryWrapper);
    }

    public Owner addOwner(OwnerModel addModel){
        Owner emp = new Owner();
        emp.setPid(addModel.getPid());
        emp.setPname(addModel.getPname());
        emp.setPhone(addModel.getPhone());
        emp.setPnumber(addModel.getPnumber());
        emp.setPwhether(addModel.getPwhether());
        try {
            baseMapper.insert(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return emp;
    }

    public String updateOwner(OwnerModel updateModel){
        Integer pid = updateModel.getPid();
        if (pid == null){
            return "ID不能为空哦！！！";
        }
        else {
            Owner emp = new Owner();
            emp.setPid(pid);
            if (updateModel.getPname()!=null && updateModel.getPname().length()!=0){
                emp.setPname(updateModel.getPname());
            }
            if (updateModel.getPhone()!=null&& updateModel.getPhone().length()!=0){
                emp.setPhone(updateModel.getPhone());
            }
            if (updateModel.getPnumber()!=null){
                emp.setPnumber(updateModel.getPnumber());
            }
            if (updateModel.getPwhether()!=null && updateModel.getPwhether().length()!=0){
                emp.setPwhether(updateModel.getPwhether());
            }
            baseMapper.updateById(emp);
            return null;
        }

    }


    private boolean delOwnerById(Serializable id){
        return super.removeById(id);
    }
    @RequestMapping("/deleteById")
    public RestResponse delOwnerById(Integer id){
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
