package org.bigjava.bean;

import java.util.Date;

/**
  * @ProjectName: JavaEESenior
  * @ClassName: Employee
  * @Description: TODO
  * @Author: 洛笙
  * @Date: 2020-08-25 14:29
  * @Version v1.0
  *
  */
public class Employee {
    private Integer id;

    private String lastName;

    private String email;

    //1 male, 0 female
    private Integer gender;

    private Date birth;

    private Integer salary;

    private Integer departmentId;

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                ", department=" + department +
                '}';
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Date birth, Integer salary, Integer departmentId) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
        this.salary = salary;
        this.departmentId = departmentId;
    }
}