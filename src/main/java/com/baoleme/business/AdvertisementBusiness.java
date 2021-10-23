package com.baoleme.business;

import com.baoleme.dao.*;
import com.baoleme.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AdvertisementBusiness {
    @Autowired
    private AdvertisementDao advertisementDao;

    public List<Advertisement> findAll() {
        return advertisementDao.getAll();
    }
}
