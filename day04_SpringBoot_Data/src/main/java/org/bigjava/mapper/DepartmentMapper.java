package org.bigjava.mapper;

import org.bigjava.bean.Department;

/**
  * @ProjectName: JavaEESenior
  * @ClassName: DepartmentMapper
  * @Description: TODO
  * @Author: 洛笙
  * @Date: 2020-08-25 13:22
  * @Version v1.0
  *
  */
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}