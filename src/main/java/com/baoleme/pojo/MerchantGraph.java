package com.baoleme.pojo;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class MerchantGraph {

    private Long id;

    private String name;

    private String site;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
