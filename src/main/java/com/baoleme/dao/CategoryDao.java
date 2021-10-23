package com.baoleme.dao;

import com.baoleme.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryDao {

    Category getById(Long id);

    List<Category> getAll();
}
