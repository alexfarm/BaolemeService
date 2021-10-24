package com.baoleme.business;

import com.baoleme.constant.CategoryListConstant;
import com.baoleme.dao.AdvertisementDao;
import com.baoleme.dao.UserTraceDao;
import com.baoleme.pojo.Advertisement;
import com.baoleme.pojo.UserTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementBusiness {
    @Autowired
    private AdvertisementDao advertisementDao;

    @Autowired
    private UserTraceDao userTraceDao;

    @Autowired
    private HttpServletRequest request;

    public List<Advertisement> findAll() {

        String userId = request.getHeader("X-USER-FLAG");

        //获取用户上一次的操作意图
        String target = "";
        UserTrace userTrace = userTraceDao.getByUserId(userId);
        if (userTrace != null) {
            String targetValue = userTrace.getValue();
            if(CategoryListConstant.eats.contains(targetValue)) {
                target = "eat";
            } else if (CategoryListConstant.coffee.contains(targetValue)) {
                target = "coffee";
            } else {
                target = "";
            }
        }

        final String t = target;
        List<Advertisement> advertisements = advertisementDao.getAll();
        List<Advertisement> ads = advertisements.stream().sorted(Comparator.comparing(e -> {
            if(e.getType().equals(t)) {
                return -1;
            } else {
                return 1;
            }
        })).collect(Collectors.toList());

        return ads;
    }
}
