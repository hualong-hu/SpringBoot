package org.bigjava.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: User
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-09-22 19:35
 * @Version v1.0
 */

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private String name;
    private Integer age;
}
