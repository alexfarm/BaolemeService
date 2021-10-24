package com.baoleme.business;

import com.baoleme.Repository.CategoryGraphRepository;
import com.baoleme.pojo.MerchantGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBusiness {

    @Autowired
    private CategoryGraphRepository categoryGraphRepository;

    public List<MerchantGraph> getMerchantByCategory(String category) {
        List<MerchantGraph> merchantGraphs = categoryGraphRepository.getMerchantsByCategory(category);
        return merchantGraphs;
    }
}
