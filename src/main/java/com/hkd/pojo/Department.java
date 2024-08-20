package com.hkd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门表
//自动构造set/get/..
@Data
//有参构造
@AllArgsConstructor
//无参构造
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;

}
