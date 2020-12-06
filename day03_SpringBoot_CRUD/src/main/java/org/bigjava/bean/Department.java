package org.bigjava.bean;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: Department
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-09-06 20:00
 * @Version v1.0
 */
public class Department {
    private Integer id;

    private String departmentName;

    private String manager;

    private String address;

    private Integer personcount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPersoncount() {
        return personcount;
    }

    public void setPersoncount(Integer personcount) {
        this.personcount = personcount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", manager=").append(manager);
        sb.append(", address=").append(address);
        sb.append(", personcount=").append(personcount);
        sb.append("]");
        return sb.toString();
    }
}