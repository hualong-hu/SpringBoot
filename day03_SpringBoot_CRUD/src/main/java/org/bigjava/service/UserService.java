package org.bigjava.service;

import org.apache.ibatis.annotations.Param;
import org.bigjava.bean.User;

import java.util.List;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: UserService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-26 23:11
 * @Version v1.0
 */
public interface UserService {


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsernameAndPassword(String username, String password);

    boolean checkUsername(String username);

}

