package com.hkd.service.impl;

import com.hkd.mapper.DepartmentMapper;
import com.hkd.mapper.EmployeeMapper;
import com.hkd.pojo.Department;
import com.hkd.service.DepartmentService;

import java.util.Collection;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    //mapper匹配
    private EmployeeMapper employeeMapper;
    private DepartmentMapper departmentMapper;

    //获取所有部门信息
    @Override
    public Collection<Department> getDepartment() {
        List<Department> departments = departmentMapper.selectList(null);
        return departments;
    }
    //根据id查询部门
    @Override
    public Department getDepartmentById(Integer id) {
        Department departments = departmentMapper.selectById(id);
        return departments;
    }
}
