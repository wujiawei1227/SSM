package com.dao;


import com.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface memberDao {
    @Select("select * from member where id =#{id}")
    public Member findById(int id);
}
