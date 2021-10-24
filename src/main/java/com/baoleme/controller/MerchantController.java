package com.baoleme.controller;

import com.baoleme.business.MerchantBusiness;
import com.baoleme.pojo.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 17/6/25.
 */
@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantBusiness merchantBusiness;

    @RequestMapping(value = "/detail.json",method = {RequestMethod.GET})
    public Merchant getById(@RequestParam("id") String id) {
        return merchantBusiness.findById(Long.valueOf(id));
    }

    @RequestMapping(value="/all.json",method = RequestMethod.GET)
    public List<Merchant> getAll(){
        return  merchantBusiness.findAll();
    }
}
