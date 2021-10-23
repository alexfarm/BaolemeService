package com.baoleme.dao;

import com.baoleme.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TagDao {

    Tag getById(Long id);

    List<Tag> getAll();



}
