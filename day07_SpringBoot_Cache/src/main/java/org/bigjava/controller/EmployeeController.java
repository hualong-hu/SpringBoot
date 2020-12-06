package org.bigjava.controller;

import org.bigjava.bean.Employee;
import org.bigjava.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: EmployeeController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-27 15:49
 * @Version v1.0
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id")Integer id){
        return employeeService.getEmp(id);
    }

    @GetMapping("/emp")
    public Employee update(Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/deleteEmp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpLastName(@PathVariable("lastName")String lastName){

        return employeeService.getEmployeeByLastName(lastName);
    }
}
