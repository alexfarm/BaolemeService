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
public class MerchantBusiness {

    @Autowired
    private MerchantDao merchantDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private TradingAreaDao tradingAreaDao;

    @Autowired
    private MerchantTagDao merchantTagDao;

    public Merchant findMerchantById(Long id) {
        return merchantDao.getById(id);
    }

    public List<Merchant> findAll() {
        List<Merchant> merchantList = merchantDao.getAll();
        List<TradingArea> tradingAreaList = tradingAreaDao.getAll();
        List<MerchantTag> merchantTagList = merchantTagDao.getAll();
        List<Tag> tagList = tagDao.getAll();
        List<Category> categoryList = categoryDao.getAll();

        Map<Long, TradingArea> tradingAreaMap = tradingAreaList.stream().collect(
                Collectors.toMap(TradingArea::getId, Function.identity()));

        Map<Long, Category> categrayMap = categoryList.stream().collect(
                Collectors.toMap(Category::getId, Function.identity()));

        Map<Long, Tag> tagMap = tagList.stream().collect(
                Collectors.toMap(Tag::getId, Function.identity()));

        Map<Long, List<MerchantTag>> merchantTagListMap = merchantTagList.stream().collect(Collectors.groupingBy(MerchantTag::getMerchantId));

        for (Merchant merchant: merchantList) {
            merchant.setTradingArea(tradingAreaMap.get(merchant.getTradingAreaId()));
            merchant.setCategory(categrayMap.get(merchant.getCategoryId()));
            List<MerchantTag> merchantTags = merchantTagListMap.get(merchant.getId());

            List<Tag> tags = new ArrayList<>();
            if (merchantTags != null) {
                for (MerchantTag merchantTag: merchantTags) {
                    Tag tag = tagMap.get(merchantTag.getTagId());
                    tag.setWeight(merchantTag.getWeight());
                    tags.add(tag);
                }
            }

            merchant.setTags(tags);
        }

        return  merchantList;
    }

    public Merchant findById(Long id) {
        Merchant merchant = merchantDao.getById(id);
        merchant.setCategory(categoryDao.getById(merchant.getCategoryId()));
        merchant.setTradingArea(tradingAreaDao.getById(merchant.getTradingAreaId()));

        List<Tag> tagList = tagDao.getAll();
        List<MerchantTag> merchantTagList = merchantTagDao.getByMerchantId(merchant.getId());

        Map<Long, Tag> tagMap = tagList.stream().collect(
                Collectors.toMap(Tag::getId, Function.identity()));

        List<Tag> tags = new ArrayList<>();
        for (MerchantTag merchantTag: merchantTagList) {
            Tag tag = tagMap.get(merchantTag.getTagId());
            tag.setWeight(merchantTag.getWeight());
            tags.add(tag);
        }
        merchant.setTags(tags);

        return merchant;
    }
}
