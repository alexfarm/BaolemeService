package com.baoleme.dao;

import com.baoleme.pojo.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MerchantDao {

    Merchant getById(Long id);
}
