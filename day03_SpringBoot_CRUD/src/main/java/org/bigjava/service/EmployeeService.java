package org.bigjava.service;

import org.bigjava.bean.Employee;

import java.util.List;

/**
  * @ProjectName: JavaEESenior
  * @ClassName: EmployeeService
  * @Description: TODO
  * @Author: 洛笙
  * @Date: 2020-08-25 14:29
  * @Version v1.0
  *
  */
public interface EmployeeService{


    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Employee selectByPrimaryKeyWithDepartment(Integer id);

    List<Employee> findByAll();

    List<Employee> selectAllByLastName(String lastName);
}
