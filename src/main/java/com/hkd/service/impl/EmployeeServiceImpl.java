package com.hkd.service.impl;

import com.hkd.mapper.DepartmentMapper;
import com.hkd.mapper.EmployeeMapper;
import com.hkd.pojo.Employee;
import com.hkd.service.EmployeeService;

import java.util.Collection;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    //mapper匹配
    private EmployeeMapper employeeMapper;
    private DepartmentMapper departmentMapper;
    //查询全部员工信息
    public Collection<Employee> getAll(){
        List<Employee> employees = employeeMapper.selectList(null);
        return employees;
    }
    //增加员工
    public void addEmployee(Employee employee){
        employeeMapper.insert(employee);
    }
    //通过id查询员工
    public Employee getEmployeeById(Integer id){
//        List<Employee> employees = (List<Employee>) employeeMapper.selectById(id);
        Employee employees = employeeMapper.selectById(id);
        return employees;
    }
    //通过id删除员工
    public void removeEmployeeById(Integer id) {
        employeeMapper.deleteById(id);
    }
}
