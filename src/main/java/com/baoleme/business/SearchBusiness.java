package com.baoleme.business;

import com.baoleme.dao.MerchantDao;
import com.baoleme.pojo.Merchant;
import com.baoleme.pojo.MerchantGraph;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchBusiness {

    @Autowired
    private CategoryBusiness categoryBusiness;

    @Autowired
    private MerchantDao merchantDao;

    public List<Merchant> search(String content) {
        List<MerchantGraph> merchantGraphs = categoryBusiness.getMerchantByCategory(content);

        List<Merchant> merchants = new ArrayList<>();
        for (MerchantGraph graph : merchantGraphs) {
            Merchant merchant = new Merchant();
            BeanUtils.copyProperties(graph, merchant);
            merchants.add(merchant);
        }

        return merchants;
    }
}
