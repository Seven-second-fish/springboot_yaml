package com.hkd.controller;

import com.hkd.dao.DepartmentDao;
import com.hkd.dao.EmployeeDao;
import com.hkd.pojo.Department;
import com.hkd.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmplyeeController {
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;
    @Autowired
    public void setDependencyA(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Autowired
    public void setDependencyB(DepartmentDao departmentDao){this.departmentDao = departmentDao;}

    //员工列表
    @RequestMapping("/employeeList.action")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "employee/list";
    }

    //添加员工
    @RequestMapping(value = "/employeeAdd.do",method = RequestMethod.GET)
    public String toAdd(Model model){
        //获取部门信息
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "employee/add";
    }
    @RequestMapping(value = "/employeeAdd.do",method = RequestMethod.POST)
    public String addEmp(Model model,Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/employeeList.action";
    }


    //修改员工信息
    @RequestMapping(value = "/employeeUpdate.do/{id}",method = RequestMethod.GET)
//    @ResponseBody
    //resultful格式只能使用Pathvariable
    public String toUpdate(Model model,@PathVariable("id") Integer id){
        //获取员工信息
        Employee employee = employeeDao.getEmployeeById(id);
        //获取部门信息
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        model.addAttribute("employee",employee);
        return "employee/update";
    }
    @RequestMapping(value = "/employeeUpdate.do",method = RequestMethod.POST)
//    @ResponseBody
    public String updateEmp(Employee employee){
        //修改数据有问题，需要添加数据库后修改
        employeeDao.addEmployee(employee);
        return "redirect:/employeeList.action";
    }

    //删除员工
    @RequestMapping(value = "/employeeDel.do/{id}",method = RequestMethod.GET)
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.removeEmployeeById(id);
        return "redirect:/employeeList.action";
    }
}
