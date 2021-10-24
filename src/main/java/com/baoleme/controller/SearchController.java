package com.baoleme.controller;

import com.baoleme.business.SearchBusiness;
import com.baoleme.pojo.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchBusiness searchBusiness;

    @RequestMapping(value = "/search.json", method = RequestMethod.GET)
    public List<Merchant> search(String content) {
        return searchBusiness.search(content);
    }
}
