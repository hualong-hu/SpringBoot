package org.bigjava.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.bigjava.mapper.EmployeeMapper;
import org.bigjava.bean.Employee;
import org.bigjava.service.EmployeeService;

import java.util.List;

/**
  * @ProjectName: JavaEESenior
  * @ClassName: EmployeeServiceImpl
  * @Description: TODO
  * @Author: 洛笙
  * @Date: 2020-08-25 14:29
  * @Version v1.0
  *
  */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Employee record) {
        return employeeMapper.insert(record);
    }

    @Override
    public int insertSelective(Employee record) {
        return employeeMapper.insertSelective(record);
    }

    @Override
    public Employee selectByPrimaryKey(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return employeeMapper.updateByPrimaryKey(record);
    }

    @Override
    public Employee selectByPrimaryKeyWithDepartment(Integer id) {
        return null;
    }

    @Override
    public List<Employee> findByAll() {
        return employeeMapper.findByAll();
    }

    @Override
    public List<Employee> selectAllByLastName(String lastName) {
        return employeeMapper.selectAllByLastName(lastName);
    }

}
