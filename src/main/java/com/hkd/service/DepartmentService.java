package com.hkd.service;

import com.hkd.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DepartmentService {
    //获取所有部门信息
    public Collection<Department> getDepartment();
    //通过id查询部门
    public Department getDepartmentById(Integer id);
}
