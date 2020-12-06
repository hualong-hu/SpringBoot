package org.bigjava.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.bigjava.bean.Department;
import org.bigjava.bean.Employee;
import org.bigjava.service.impl.DepartmentServiceImpl;
import org.bigjava.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @ProjectName: JavaEESenior
 * @ClassName: EmployeeController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-22 14:36
 * @Version v1.0
 */
@Controller
public class EmployeeController  {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    DepartmentServiceImpl departmentService;
    
    /**
     * 查询所有员工返回列表页面
     * @data: 2020-08-22-14:44
     * @method: getEmployees
     * @params: []
     * @return: java.lang.String
     */
    @GetMapping(value="/employees")
    public String  getEmployees(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum, Model model){
        PageHelper.startPage(pageNum, 6);
        List<org.bigjava.bean.Employee> employees = employeeService.findByAll();
        PageInfo<Employee> pageInfo = new PageInfo<>(employees,5);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("employees", employees);
        //thymeleaf默认就会拼串，classpath:/templates/employee/list.html
        return "employee/list";
    }

    /**
     * 来到员工添加页面,并查出所有的部门信息
     * @data: 2020-08-23-11:43
     * @method: toAddPage
     * @params: []
     * @return: java.lang.String
     */
    @GetMapping(value="/employee")
    public String  toAddPage(Model model){
        List<Department> departments = departmentService.findByAll();
        model.addAttribute("departments",departments);
        return "employee/add";
    }

    /**
     * 实现员工添加
     * @data: 2020-08-23-12:49
     * @method: addEmployee
     * @params: []
     * @return: java.lang.String
     */
    @PostMapping(value="/employee")
    public String addEmployee(Employee employee){
        employeeService.insert(employee);
        departmentService.findCount(employee.getDepartmentId());
        //回到员工列表页面
        return "redirect:/employees";
    }

    /**
     * 来到员工修改页面
     * @data: 2020-08-23-13:08
     * @method: xxx
     * @params: []
     * @return: java.lang.String
     */
    @GetMapping(value="/employee/{id}")
    public String toEditPage(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeService.selectByPrimaryKey(id);
        model.addAttribute("emp", employee);
        List<Department> departments = departmentService.findByAll();
        model.addAttribute("departments",departments);
        return "employee/update";
    }
    /**
     * 员工修改完成，回到列表页面
     * @data: 2020-08-23-13:42
     * @method: updateEmployee
     * @params: [employee]
     * @return: java.lang.String
     */
    @PutMapping(value="/employee")
    public String  updateEmployee(Employee employee){
        //修改员工信息
        employeeService.updateByPrimaryKeySelective(employee);
        Integer id = employee.getDepartmentId();

        for (int i = 1 ; i <= id ; i++){
            departmentService.findCount(i);
        }

        //回到员工列表页面
        return "redirect:/employees";
    }
    /**
     * 删除某个员工
     * @data: 2020-08-29-15:21
     * @method: deleteEmployee
     * @params: [id]
     * @return: java.lang.String
     */
    @DeleteMapping(value="/employee/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id){

        employeeService.deleteByPrimaryKey(id);
        return "redirect:/employees";
    }
    /**
     * 通过员工姓名精确搜索员工
     * @data: 2020-08-29-19:13
     * @method: search
     * @params: [employeeName, pageNum, model, request]
     * @return: java.lang.String
     */
    @GetMapping(value="/searchEmployees")
    public String search(@RequestParam("employeeName") String employeeName,
                         @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                         Model model, HttpServletRequest request){
        request.removeAttribute("employees");
        request.removeAttribute("pageInfo");
        List<Employee> employees = employeeService.selectAllByLastName(employeeName);
        PageHelper.startPage(pageNum, 6);
        PageInfo<Employee> pageInfo = new PageInfo<>(employees,5);
        if (employees.isEmpty()){
            model.addAttribute("isEmpty","true");
        }
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("employees", employees);
        model.addAttribute("employeeName",employeeName);
        return "employee/list";
    }

}
