package com.study.springboot.controller;

import com.study.springboot.dao.DepartmentDao;
import com.study.springboot.dao.EmployeeDao;
import com.study.springboot.entities.Department;
import com.study.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Map<String,Object> map) {
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中共享
        map.put("emps",employees);

        //thymeleaf默认会拼串
        //classpath:/templates/
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Map<String,Object> map){
        //来到添加页面,查出所有的部门并在添加页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts",departments);
        return "emp/add";
    }

    /**
     * 员工添加
     * SpringMVC自动将请求参数和入参对象的属性进行一一绑定，
     * 要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //来到员工列表页面
        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeDao.save(employee);
        //redirect表示重定向一个地址
        //forward表示转发到一个地址
        return "redirect:/emps";
    }

    /**
     * 来到修改页面，查出当前员工，在页面回显
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Map<String,Object> map) {
        Employee employee = employeeDao.get(id);
        map.put("emp",employee);
        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面)
        return "emp/add";
    }

    /**
     * 修改员工信息，需要提交员工的id
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("修改的员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 员工删除
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
