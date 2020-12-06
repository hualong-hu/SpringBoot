package org.bigjava.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: Users
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-30 17:12
 * @Version v1.0
 */

@Data
@TableName("user")
public class Users {

    private Integer id;
    private String username;
    private String password;

}
