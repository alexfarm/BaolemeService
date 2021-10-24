package com.baoleme.dao;

import com.baoleme.pojo.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MerchantDao {

    Merchant getById(Long id);

    List<Merchant> getAll();

    List<Merchant> getAllByIds(List<Long> ids);

    List<Merchant> getAllByName(String merchantName);

}
