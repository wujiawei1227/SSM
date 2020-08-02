package com.service;

import com.domain.SysLog;

import java.util.List;

public interface SysLogService {
    public void save(SysLog log) throws Exception;
    public List<SysLog> findAll(int page,int size) throws Exception;
}
