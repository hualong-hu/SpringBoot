package org.bigjava.service;

import org.apache.ibatis.annotations.Param;
import org.bigjava.bean.Department;

import java.util.List;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: DepartmentService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-25 14:28
 * @Version v1.0
 */
public interface DepartmentService {


    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> findByAll();

    int findCount(Integer id);

    Department findByDepartmentName(@Param("departmentName")String departmentName);

    Department findByAddress(@Param("address")String address);
}


