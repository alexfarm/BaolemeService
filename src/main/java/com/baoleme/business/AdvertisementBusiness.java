package com.baoleme.business;

import com.baoleme.dao.AdvertisementDao;
import com.baoleme.pojo.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementBusiness {
    @Autowired
    private AdvertisementDao advertisementDao;

    public List<Advertisement> findAll() {
        return advertisementDao.getAll();
    }
}
