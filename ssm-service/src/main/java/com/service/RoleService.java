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
    public List<Role> findAll(int page,int size) throws Exception;
    public void save(Role role);
    public List<Role> findOtherRole(int id);
    public Role findById(int id);
    public void addPermissionToRole(int roleId,int[] permissionIds);
}
