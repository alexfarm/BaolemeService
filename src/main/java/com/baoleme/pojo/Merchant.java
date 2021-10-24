package com.baoleme.pojo;

import java.util.List;

public class Merchant {
    private long id;

    private String name;

    private String site;

    private String rate;

    private String businessHours;

    private String img;

    private long tradingAreaId;

    private long categoryId;

    private TradingArea tradingArea;

    private Category category;

    private List<Tag> tags;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getTradingAreaId() {
        return tradingAreaId;
    }

    public void setTradingAreaId(long tradingAreaId) {
        this.tradingAreaId = tradingAreaId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public TradingArea getTradingArea() {
        return tradingArea;
    }

    public void setTradingArea(TradingArea tradingArea) {
        this.tradingArea = tradingArea;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
