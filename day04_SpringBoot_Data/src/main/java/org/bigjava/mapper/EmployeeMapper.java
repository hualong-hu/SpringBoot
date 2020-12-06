package org.bigjava.mapper;

import org.bigjava.bean.Employee;

/**
  * @ProjectName: JavaEESenior
  * @ClassName: EmployeeMapper
  * @Description: TODO
  * @Author: 洛笙
  * @Date: 2020-08-25 13:25
  * @Version v1.0
  *
  */
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer employeeId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}