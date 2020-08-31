package com.service;

import com.domain.Role;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-31 10:07
 **/

public interface RoleService {
    public List<Role> findAll(Integer page,Integer size) throws Exception;
    public void save(Role role);
    public List<Role> findOtherRole(Integer id);
    public Role findById(Integer id);
    public void addPermissionToRole(Integer roleId,int[] permissionIds);
}
