package com.baoleme.controller;

import com.baoleme.business.MerchantBusiness;
import com.baoleme.pojo.Merchant;
import com.baoleme.pojo.MerchantGraph;
import com.baoleme.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 17/6/25.
 */
@RestController
public class HelloController {

    @Autowired
    private MerchantBusiness merchantBusiness;

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value="/findMerchant",method = RequestMethod.GET)
    public Merchant Hello(Long id){
        Merchant merchant = merchantBusiness.findMerchantById(id);
        return merchant;
    }

    @RequestMapping(value="/graph/findMerchant",method = RequestMethod.GET)
    public MerchantGraph Hellov2(Long id){
        MerchantGraph merchant = merchantService.getMerchant(id);
        return merchant;
    }
}
