package com.baoleme.business;

import com.baoleme.dao.MerchantDao;
import com.baoleme.pojo.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantBusiness {

    @Autowired
    private MerchantDao merchantDao;

    public Merchant findMerchantById(Long id) {
        return merchantDao.getById(id);
    }
}
