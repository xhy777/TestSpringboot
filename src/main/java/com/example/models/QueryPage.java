package com.example.models;

import lombok.Data;

@Data
public class QueryPage {
    private Integer Current;
    private Integer Size;
    public Integer getCurrent(){
        return Current !=null ? Current:1;
    }
    public Integer getSize(){
        return Size !=null ? Size:1;
    }
}
