package com.example.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("s_user")
public class UserBean {
    @TableId(type = IdType.INPUT)
    private Integer  uid;
    private String uname;
    private String uloginname;
    private String upassword;
    private String utype;

}
