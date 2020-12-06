package org.bigjava.day04;

import org.bigjava.bean.Employee;
import org.bigjava.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Day04ApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads() throws SQLException {

        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
        connection.close();
    }

    @Test
    public void test(){
        Employee employee = employeeMapper.selectByPrimaryKey(2);
        System.out.println("employee = " + employee);
    }
}
