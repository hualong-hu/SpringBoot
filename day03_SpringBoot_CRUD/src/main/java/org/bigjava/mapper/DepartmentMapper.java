package org.bigjava.mapper;
import org.apache.ibatis.annotations.Param;

import org.bigjava.bean.Department;
import java.util.List;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: DepartmentMapper
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-09-06 20:00
 * @Version v1.0
 */
public interface DepartmentMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Department record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Department record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Department selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Department record);

    List<Department> findByAll();

    int findCount(Integer id);

	List<Department> findByAll(Department department);

	Department findByDepartmentName(@Param("departmentName")String departmentName);

    Department findByAddress(@Param("address")String address);




}