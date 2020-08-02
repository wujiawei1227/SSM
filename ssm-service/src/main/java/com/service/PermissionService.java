package com.service;

import com.domain.Permission;
import com.domain.UserInfo;

import java.util.List;

public interface PermissionService {
    public List<Permission> findAll(int page,int size) throws Exception;
    public Permission findById(int id) throws Exception;
    public void save(Permission permission);
    public List<Permission> findOtherPermission(int roleId);
}
