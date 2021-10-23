package com.baoleme.controller;

import com.baoleme.business.MerchantBusiness;
import com.baoleme.pojo.Merchant;
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

    @RequestMapping(value="/findMerchant",method = RequestMethod.GET)
    public Merchant Hello(Long id){
        Merchant merchant = merchantBusiness.findMerchantById(id);
        return merchant;
    }
}
