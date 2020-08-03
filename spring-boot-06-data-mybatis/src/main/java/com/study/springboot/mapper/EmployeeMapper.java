package com.study.springboot.mapper;

import com.study.springboot.bean.Employee;

//@Mapper或者@MapperScan注解将接口扫描装配到容器中
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public int insertEmp(Employee employee);
}
