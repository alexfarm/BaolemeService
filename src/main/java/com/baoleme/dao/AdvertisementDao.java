package com.baoleme.dao;

import com.baoleme.pojo.Advertisement;
import com.baoleme.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdvertisementDao {
    List<Advertisement> getAll();
}
