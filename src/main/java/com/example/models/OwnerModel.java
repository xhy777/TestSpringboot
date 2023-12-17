package com.example.models;

import lombok.Data;

@Data
public class OwnerModel extends QueryPage{
    private Integer pid;
    private String pname;
    private String phone;
    private Integer pnumber;
    private String pwhether;

}
