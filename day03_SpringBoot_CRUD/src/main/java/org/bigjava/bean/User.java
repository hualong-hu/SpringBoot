package org.bigjava.bean;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: User
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-26 23:51
 * @Version v1.0
 */
public class User {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String key;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", key=").append(key);
        sb.append("]");
        return sb.toString();
    }
}