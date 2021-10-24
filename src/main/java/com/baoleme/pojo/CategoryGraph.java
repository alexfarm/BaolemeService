package com.baoleme.pojo;

public class CategoryGraph {
    private long id;

    private long mysqlId;

    private String name;

    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getMysqlId() {
        return mysqlId;
    }

    public void setMysqlId(long mysqlId) {
        this.mysqlId = mysqlId;
    }
}
