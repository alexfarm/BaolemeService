package com.baoleme.business;

import com.baoleme.dao.MerchantDao;
import com.baoleme.pojo.Merchant;
import com.baoleme.pojo.MerchantGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchBusiness {

    @Autowired
    private CategoryBusiness categoryBusiness;

    @Autowired
    private MerchantDao merchantDao;

    public List<Merchant> search(String content) {
        List<MerchantGraph> merchantGraphs = categoryBusiness.getMerchantByCategory(content);
        List<Long> merchantIds = merchantGraphs.stream().map(MerchantGraph::getId).collect(Collectors.toList());

        List<Merchant> merchants = merchantDao.getAllByIds(merchantIds);

        return merchants;
    }
}
