package org.bigjava.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.bigjava.bean.Employee;

import java.util.List;

/**
  * @ProjectName: JavaEESenior
  * @ClassName: EmployeeMapper
  * @Description: TODO
  * @Author: 洛笙
  * @Date: 2020-08-25 14:29
  * @Version v1.0
  *
  */

public interface EmployeeMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Employee record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Employee record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Employee selectByPrimaryKey(Integer id);

    Employee selectByPrimaryKeyWithDepartment(Integer id);

    List<Employee> selectAllByLastName(String lastName);

    List<Employee> findByAll();
    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Employee record);
}