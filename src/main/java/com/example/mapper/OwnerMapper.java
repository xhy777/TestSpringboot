package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entities.Owner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OwnerMapper extends BaseMapper<Owner> {
}
