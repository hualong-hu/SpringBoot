//package org.bigjava;
//
//import org.bigjava.bean.Department;
//import org.bigjava.bean.Employee;
//import org.bigjava.bean.Product;
//import org.bigjava.bean.User;
//import org.bigjava.mapper.DepartmentMapper;
//import org.bigjava.mapper.EmployeeMapper;
//import org.bigjava.service.impl.DepartmentServiceImpl;
//import org.bigjava.service.impl.ProductServiceImpl;
//import org.bigjava.service.impl.UserServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//import java.util.List;
//
//@SpringBootTest
//class DemoApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Autowired
//    DepartmentServiceImpl departmentService;
//    @Autowired
//    DepartmentMapper departmentMapper;
//
//    @Autowired
//    EmployeeMapper employeeMapper;
//
//    @Autowired
//    UserServiceImpl userService;
//
//    @Autowired
//    ProductServiceImpl productService;
//
//    @Test
//    public void test1(){
//        Department department = new Department();
//        department.setDepartmentName("测试部");
//        int i = departmentService.insert(department);
//        System.out.println("受影响的行数是："+i);
//    }
//    @Test
//    public void test2(){
//        Department department = new Department();
//        department.setDepartmentName("开发部");
//        int i = departmentMapper.insert(department);
//        System.out.println("受影响的行数是："+i);
//    }
////    @Test
////    public void test3(){
//////        Department department = new Department();
//////        department.setDepartmentName("开发部");
////        Employee employee = new Employee(null, "洛笙", "luosheng@qq.com", 0, new Date(), 10000, 20, null);
////        int i = employeeMapper.insert(employee);
////        System.out.println("受影响的行数是："+i);
////    }
//
//    @Test
//    public void test4(){
//        Employee employee = employeeMapper.selectByPrimaryKeyWithDepartment(1);
//        System.out.println("employee = " + employee);
//    }
//    @Test
//    public void test5(){
//        List<Department> list = departmentService.findByAll();
//        for (Department department : list) {
//            System.out.println("department = " + department);
//        }
//    }
//    @Test
//    public void test6(){
//        User list = userService.selectByUsernameAndPassword("洛笙666",null);
//        System.out.println("list = " + list);
//    }
//    @Test
//    public void test7(){
//        List<Employee> list = employeeMapper.selectAllByLastName("断念");
//        for (Employee employee : list) {
//            System.out.println("employee = " + employee);
//        }
//    }
//    @Test
//    public void test8(){
//        List<Product> products = productService.selectByAll(null);
//        for (Product product : products) {
//            System.out.println("product = " + product);
//        }
//    }
//
//    @Test
//    public void test9(){
//        List<Department> all = departmentMapper.findByAll();
//        for (Department department : all) {
//            System.out.println("department = " + department);
//        }
//    }
//}
