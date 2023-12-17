package com.example.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("employment")
public class Employments {
    @TableId(type = IdType.INPUT)
    private Integer eid;
    private String ename;
    private Integer eage;
    private String idcard;
    private String eaddr;
    private String sex;
}
