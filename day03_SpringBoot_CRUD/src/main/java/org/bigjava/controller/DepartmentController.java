package org.bigjava.controller;

import org.bigjava.bean.Department;
import org.bigjava.bean.Employee;
import org.bigjava.service.EmployeeService;
import org.bigjava.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: DepartmentController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-09-05 21:08
 * @Version v1.0
 */
@Controller
public class DepartmentController {
    @Autowired
    DepartmentServiceImpl departmentService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value="/departments")
    public String  getAllDepartments( Model model){
        List<Department> list = departmentService.findByAll();
        model.addAttribute("departments", list);
        return "department/list";
    }

    @GetMapping("/checkEmployee")
    @ResponseBody
    public Map<String,Object> checkEmployee(String manager){
        HashMap<String, Object> map = new HashMap<>();
//        System.out.println("manager = " + manager);
        List<Employee> employees = employeeService.selectAllByLastName(manager);

        if (employees.isEmpty()){
            map.put("msg", "公司查无此人，不能任命为经理");
        }
//        System.out.println(employees.isEmpty());
        return map;
    }

    @PostMapping("/department")
    @ResponseBody
    public Map<String,Object> department(Department department){
        HashMap<String, Object> map = new HashMap<>();
        int i = departmentService.insertSelective(department);
        if (i != 0){
            map.put("msg", "部门开设成功!");
        }
        return map;
    }

    @DeleteMapping("/department/{id}")
    public Map<String,Object> delete(@PathVariable("id")Integer id){
        HashMap<String, Object> map = new HashMap<>();
        int i = departmentService.deleteByPrimaryKey(id);
        if (i!=0){
            map.put("msg", "取消成功！");
        }
        return map;
    }
    /**
     * 将部门信息回显至前端页面
     * @data: 2020-10-20-8:37
     * @method: getDepartment
     * @params: [id]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @ResponseBody
    @GetMapping("/department/{id}")
    public Map<String,Object> getDepartment(@PathVariable("id")Integer id){
        HashMap<String, Object> map = new HashMap<>();
        Department department = departmentService.selectByPrimaryKey(id);
//        System.out.println("department = " + department);
        map.put("department", department);
        return map;
    }

    @PutMapping("/department")
    @ResponseBody
    public Map<String,Object> updateDepartment(Department department){
        System.out.println("department = " + department);
        HashMap<String, Object> map = new HashMap<>();
        departmentService.updateByPrimaryKeySelective(department);
        map.put("msg", "部门修改成功！");
        return map;
    }

    /**
     * 检验部门名是否可用
     * @data: 2020-10-21-11:01
     * @method: checkDepartmentName
     * @params: [departmentName]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @ResponseBody
    @GetMapping("/checkDepartmentName")
    public Map<String,Object> checkDepartmentName(String departmentName){
        HashMap<String, Object> map = new HashMap<>();
        Department departmentName1 = departmentService.findByDepartmentName(departmentName);
//        System.out.println("departmentName = " + departmentName1);
        if (departmentName1 != null){
            map.put("msg", "该部门已开设，请选择其他部门");
        }

        return map;
    }

    /**
     * 检验地址是否可用
     * @data: 2020-10-21-11:01
     * @method: checkAddress
     * @params: [address]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @GetMapping("/checkAddress")
    @ResponseBody
    public Map<String,Object> checkAddress(String address){
        HashMap<String, Object> map = new HashMap<>();

        Department address1 = departmentService.findByAddress(address);
        System.out.println("address1 = " + address1);
        if (address1 != null){
            map.put("msg", "该地址已有部门存在，请选择其他地址");
        }

        return map;
    }

}
