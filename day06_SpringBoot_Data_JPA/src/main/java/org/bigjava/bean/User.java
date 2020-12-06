package org.bigjava.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: User
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-26 14:44
 * @Version v1.0
 */
//告诉JPA这是一个实体类（和数据表映射的类）
@Entity
//@Table 来指定和哪个数据表对应，如果省略默认表名就是实体类名（user）
@Table(name = "tbl_user")
public class User {
    //指定这是一个主键
    @Id
    //指定主键自增策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //指定对应数据表的列名
    @Column(name = "last_name",length = 50)
    private String lastName;

    //默认列名就是属性名
    @Column
    private String email;

    public User() {
    }

    public User(Integer id, String lastName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
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
}
