package com.baoleme.service;

import com.baoleme.Repository.MerchantGraphRepository;
import com.baoleme.pojo.MerchantGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantService {

    @Autowired
    MerchantGraphRepository merchantGraphRepository;

    public MerchantGraph getMerchant(Long id){
        Optional<MerchantGraph> merchants = merchantGraphRepository.findById(id);
        return merchants.get();
    }
}
