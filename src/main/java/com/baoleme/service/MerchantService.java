package com.baoleme.service;

import com.baoleme.Repository.MerchantGraphRepository;
import com.baoleme.pojo.MerchantGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    @Autowired
    MerchantGraphRepository merchantGraphRepository;


    public MerchantGraph getMerchant(String name){
        MerchantGraph merchants = merchantGraphRepository.findByName(name);
        return merchants;
    }
}
