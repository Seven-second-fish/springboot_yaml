package com.hkd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hkd.pojo.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
}
