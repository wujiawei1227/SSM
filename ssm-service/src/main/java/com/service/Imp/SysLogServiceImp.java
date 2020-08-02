package com.service.Imp;

import com.dao.SysLogDao;
import com.domain.SysLog;
import com.github.pagehelper.PageHelper;
import com.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: wudaren
 * @create: 2020-08-01 16:38
 **/
@Service
public class SysLogServiceImp implements SysLogService {
        @Autowired
        private SysLogDao dao;
    @Override
    public void save(SysLog log) throws Exception {
        dao.save(log);
    }

    @Override
    public List<SysLog> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }
}
