package com.baoleme.business;

import com.baoleme.dao.AdvertisementDao;
import com.baoleme.pojo.Advertisement;
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
    private HttpServletRequest request;

    public List<Advertisement> findAll() {

        String userId = request.getHeader("X-USER-FLAG");

        //获取用户上一次的操作意图
        String target = "shop";

        List<Advertisement> advertisements = advertisementDao.getAll();

        List<Advertisement> ads = advertisements.stream().sorted(Comparator.comparing(e -> {
            if(e.getType().equals(target)) {
                return -1;
            } else {
                return 1;
            }
        })).collect(Collectors.toList());

        return ads;
    }
}
