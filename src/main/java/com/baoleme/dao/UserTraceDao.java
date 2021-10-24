package com.baoleme.dao;

import com.baoleme.pojo.UserTrace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserTraceDao {
    Integer add(UserTrace userTrace);

    UserTrace getByUserId(String userId);

    Integer deleteByUserId(String userId);
}
