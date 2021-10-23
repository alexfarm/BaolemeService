package com.baoleme.dao;

import com.baoleme.pojo.Merchant;
import com.baoleme.pojo.MerchantTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MerchantTagDao {

    MerchantTag getById(Long id);

    List<MerchantTag> getAll();

    List<MerchantTag> getByMerchantId(Long merchantId);
}
