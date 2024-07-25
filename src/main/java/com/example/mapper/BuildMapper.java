package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entities.Build;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface BuildMapper extends BaseMapper<Build> {
    ArrayList<Build> selectAllBuild();
}
