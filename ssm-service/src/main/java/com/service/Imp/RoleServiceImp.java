package com.service.Imp;

import com.dao.roleDao;
import com.domain.Role;
import com.github.pagehelper.PageHelper;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-07-31 10:08
 **/
@Service
@Transactional
public class RoleServiceImp implements RoleService {
    @Autowired
    private roleDao dao;
    @Override
    public List<Role> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void save(Role role) {
        dao.save(role);
    }

    @Override
    public List<Role> findOtherRole(Integer id) {
        return dao.findOtherRole(id);
    }

    @Override
    public Role findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void addPermissionToRole(Integer roleId, int[] permissionIds) {
        for (int i = 0; i < permissionIds.length; i++) {
            dao.addPermissionToRole(roleId,permissionIds[i]);
        }
    }
}
