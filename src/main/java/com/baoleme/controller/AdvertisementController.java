package com.baoleme.controller;

import com.baoleme.business.AdvertisementBusiness;
import com.baoleme.pojo.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Autowired
    private AdvertisementBusiness advertisementBusiness;

    @RequestMapping(value="/all.json",method = RequestMethod.GET)
    public List<Advertisement> all(){
        return advertisementBusiness.findAll();
    }
}
