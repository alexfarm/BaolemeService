package com.baoleme.controller;

import com.baoleme.business.MerchantBusiness;
import com.baoleme.pojo.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alex on 17/6/25.
 */
@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantBusiness merchantBusiness;

    @RequestMapping(value = "/{id}.json",method = {RequestMethod.GET})
    public Merchant getById(@PathVariable("id") String id) {
        return merchantBusiness.findById(Long.valueOf(id));
    }

    @RequestMapping(value="/all.json",method = RequestMethod.GET)
    public List<Merchant> getAll(){
        return  merchantBusiness.findAll();
    }
}
