package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entities.Employments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmploymentMapper extends BaseMapper<Employments> {

}
