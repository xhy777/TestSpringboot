package com.example.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("build")
public class Build {
    @TableId(type = IdType.INPUT)
    private Integer bid;
    private Integer bunit;
    private Integer bfloor;
    private Integer bnumber;
    private Integer barea;
}
