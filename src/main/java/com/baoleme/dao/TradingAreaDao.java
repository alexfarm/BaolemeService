package com.baoleme.dao;

import com.baoleme.pojo.TradingArea;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TradingAreaDao {
    TradingArea getById(Long id);

    List<TradingArea> getAll();
}
