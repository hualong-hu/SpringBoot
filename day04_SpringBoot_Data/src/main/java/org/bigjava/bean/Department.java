package org.bigjava.bean;

import org.springframework.stereotype.Component;

/**
  * @ProjectName: JavaEESenior
  * @ClassName: Department
  * @Description: TODO
  * @Author: 洛笙
  * @Date: 2020-08-25 13:22
  * @Version v1.0
  *
  */
@Component
public class Department {
    private Integer departmentId;

    private String departmentName;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append("]");
        return sb.toString();
    }
}