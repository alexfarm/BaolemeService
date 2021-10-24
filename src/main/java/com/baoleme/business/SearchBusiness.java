package com.baoleme.business;

import com.baoleme.dao.MerchantDao;
import com.baoleme.pojo.Merchant;
import com.baoleme.pojo.MerchantGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchBusiness {

    @Autowired
    private CategoryBusiness categoryBusiness;

    @Autowired
    private MerchantDao merchantDao;

    public List<Merchant> search(String content) {
        //首先去图数据库检索类别
        List<MerchantGraph> merchantGraphs = categoryBusiness.getMerchantByCategory(content);

        List<Merchant> merchants;
        //如果没有类别，则从mysql中检索特定的商品
        if(CollectionUtils.isEmpty(merchantGraphs)){
            String merchantName = content;
            merchants = merchantDao.getAllByName(merchantName);
        } else {
            List<Long> merchantIds = merchantGraphs.stream().map(MerchantGraph::getId).collect(Collectors.toList());
            merchants = merchantDao.getAllByIds(merchantIds);
        }

        return merchants;
    }
}
