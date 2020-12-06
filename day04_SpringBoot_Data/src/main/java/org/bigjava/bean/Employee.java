package org.bigjava.bean;

import org.springframework.stereotype.Component;

/**
  * @ProjectName: JavaEESenior
  * @ClassName: Employee
  * @Description: TODO
  * @Author: 洛笙
  * @Date: 2020-08-25 13:25
  * @Version v1.0
  *
  */
@Component
public class Employee {
    private Integer employeeId;

    private String employeeName;

    private String gender;

    private String email;

    private Integer salary;

    private Integer departmentId;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", employeeName=").append(employeeName);
        sb.append(", gender=").append(gender);
        sb.append(", email=").append(email);
        sb.append(", salary=").append(salary);
        sb.append(", departmentId=").append(departmentId);
        sb.append("]");
        return sb.toString();
    }
}