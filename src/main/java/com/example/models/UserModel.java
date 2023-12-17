package com.example.models;

import lombok.Data;

@Data
public class UserModel extends QueryPage{
    private Integer  uid;
    private String uname;
    private String uloginname;
    private String upassword;
    private String utype;
}
