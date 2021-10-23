package com.baoleme.service;

import com.baoleme.pojo.MerchantGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantService {

    @Autowired
    com.baoleme.Repository.MerchantGraph merchantGraph;

    public MerchantGraph getMerchant(Long id){
        Optional<MerchantGraph> merchants = merchantGraph.findById(id);
        return merchants.get();
    }
}
