package com.service;

import com.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-29 11:38
 **/

    public interface UserService extends UserDetailsService {
        public List<UserInfo> findAll(int size, int page) throws Exception;
        public void save(UserInfo userInfo);
        public UserInfo findById(int id) throws Exception;
    public void addRoleToUser(int userId, int[] roleIds);
    }
