package com.baoleme.controller;

import com.baoleme.business.SearchBusiness;
import com.baoleme.dao.UserTraceDao;
import com.baoleme.pojo.Merchant;
import com.baoleme.pojo.UserTrace;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchBusiness searchBusiness;

    @Autowired
    private UserTraceDao userTraceDao;

    @RequestMapping(value = "/search.json", method = RequestMethod.GET)
    public List<Merchant> search(@RequestParam("content") String content, @RequestHeader(value="X-USER-FLAG",defaultValue = "") String userFlag) {

        if (!StringUtils.isEmpty(userFlag)) {
            userTraceDao.deleteByUserId(userFlag);
            userTraceDao.add(new UserTrace(userFlag, "OPERATION", content));
        }

        return searchBusiness.search(content);
    }
}
