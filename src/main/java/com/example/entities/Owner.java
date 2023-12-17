package com.example.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("owner")
public class Owner {
    @TableId(type = IdType.INPUT)
    private Integer pid;
    private String pname;
    private String phone;
    private Integer pnumber;
    private String pwhether;
}
