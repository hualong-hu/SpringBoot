package org.bigjava.entity;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: Dog
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-20 15:35
 * @Version v1.0
 */
public class Dog {

    private String name;
    private Integer age;

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
