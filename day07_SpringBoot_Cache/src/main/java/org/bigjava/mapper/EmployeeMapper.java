package org.bigjava.mapper;

import org.apache.ibatis.annotations.*;
import org.bigjava.bean.Employee;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: EmployeeMapper
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-27 15:26
 * @Version v1.0
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName} ,email=#{email} ,gender=#{gender} ,d_id=#{dId} where id=#{id} ")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id = #{id} ")
    public void deleteEmpById(Integer id);

    @Insert("INSERT INTO employee(lastName, email, gender, d_id) VALUES (#{lastName} ,#{email} ,#{gender} ,#{dId} )")
    public void insertEmployee(Employee employee);

    @Select("select * from employee where lastName = #{lastName} ")
    public Employee getEmployeeByLastName(String lastName);
}
