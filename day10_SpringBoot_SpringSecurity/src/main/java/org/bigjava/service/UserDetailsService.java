package org.bigjava.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.bigjava.entity.Users;
import org.bigjava.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: UserDetailsService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-30 16:50
 * @Version v1.0
 */
@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", s);
        Users users = usersMapper.selectOne(wrapper);

        if (users == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("manager,ROLE_sale");
        User user = new User(users.getUsername(), new BCryptPasswordEncoder().encode(users.getPassword()), authorities);

        return user;
    }
}
