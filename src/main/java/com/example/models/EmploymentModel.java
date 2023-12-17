package com.example.models;

import lombok.Data;

@Data
public class EmploymentModel extends QueryPage{
    private Integer eid;
    private String ename;
    private Integer eage;
    private String idcard;
    private String eaddr;
    private String sex;
}
