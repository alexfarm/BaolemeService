package com.baoleme.dao;

import com.baoleme.pojo.Category;
import com.baoleme.pojo.UserTrace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserTraceDao {
    Integer add(UserTrace userTrace);

    UserTrace getByUserId(String userId);
}
