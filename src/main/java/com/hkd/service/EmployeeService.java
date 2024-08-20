package com.hkd.service;

import com.hkd.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmployeeService {
    //查询全部员工信息
    public Collection<Employee> getAll();
    //增加员工
    public void addEmployee(Employee employee);
    //通过id查询员工
    public Employee getEmployeeById(Integer id);
    //通过id删除员工
    public void removeEmployeeById(Integer id);
}
