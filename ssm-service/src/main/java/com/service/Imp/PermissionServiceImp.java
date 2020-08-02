package com.service.Imp;

import com.dao.permissionDao;
import com.domain.Permission;
import com.domain.UserInfo;
import com.github.pagehelper.PageHelper;
import com.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-31 11:05
 **/
@Service
@Transactional
public class PermissionServiceImp implements PermissionService {
    @Autowired
    private permissionDao dao;
    @Override
    public List<Permission> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Permission findById(int id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public void save(Permission permission) {
        try {
            dao.save(permission);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Permission> findOtherPermission(int roleId) {
        return dao.findOtherPermission(roleId);
    }
}
