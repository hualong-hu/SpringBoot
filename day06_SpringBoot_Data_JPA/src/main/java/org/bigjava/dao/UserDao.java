package org.bigjava.dao;

import org.bigjava.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: UserDao
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-26 14:56
 * @Version v1.0
 */
public interface UserDao extends JpaRepository<User,Integer> {

}
