package com.service.Imp;

import com.dao.userDao;
import com.domain.Role;
import com.domain.UserInfo;
import com.github.pagehelper.PageHelper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-29 11:39
 **/
@Service("userService")
@Transactional
public class UserServiceImp implements UserService {
        @Autowired
        private userDao dao;
        @Autowired
        private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("service被执行了");
        UserInfo user=null;
        try {
            user= dao.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities=getAuthority(roles);
        User user1=new User(user.getUsername(),user.getPassword(),user.getStatus()==0?false:true,true,true,true,authorities);
        System.out.println("service执行完了" );
        return user1;
    }
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for (Role role:roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public List<UserInfo> findAll(int size, int page) throws Exception {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        dao.save(userInfo);
    }

    @Override
    public UserInfo findById(int id) throws Exception {
        UserInfo byId = dao.findById(id);
        return byId;
    }

    @Override
    public void addRoleToUser(int userId, int[] roleIds) {

        for (int i = 0; i < roleIds.length; i++) {
            dao.addRoleToUser(userId,roleIds[i]);
        }
    }
}
