package com.hkd.dao;

import com.hkd.pojo.Department;
import com.hkd.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {
    public static Map<Integer, Employee> employees = null;
    private DepartmentDao departmentDao;

    //员工所属的部门
    @Autowired
    //不推荐field注入bean
//    @Resource
    public void setDependency(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    static {
        employees = new HashMap<Integer, Employee>(); //创建一个员工表

         employees.put(101,new Employee(101,"MMM","123456@qq.com",1,new Department(101,"教学部")));
         employees.put(102,new Employee(102,"MMM","123456@qq.com",1,new Department(102,"市场部")));
         employees.put(103,new Employee(103,"MMM","123456@qq.com",1,new Department(103,"科研部")));
         employees.put(104,new Employee(104,"MMM","123456@qq.com",1,new Department(104,"运营部")));
         employees.put(105,new Employee(105,"MMM","123456@qq.com",1,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initId = 106;
    //增加员工
    public void addEmployee(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //通过id删除员工
    public Employee removeEmployeeById(Integer id){
        return employees.remove(id);
    }

}
