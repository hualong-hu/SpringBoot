package org.bigjava.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.bigjava.mapper.UserMapper;
import org.bigjava.bean.User;
import org.bigjava.service.UserService;

import java.util.List;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-26 23:11
 * @Version v1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        return userMapper.selectByUsernameAndPassword(username, password);
    }

    @Override
    public boolean checkUsername(String username) {
        User user = userMapper.selectByUsernameAndPassword(username, null);


        return false;
    }


}

