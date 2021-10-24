package com.baoleme.pojo;

public class UserTrace {

    public UserTrace(String userId, String operation, String value) {
        this.userId = userId;
        this.operation = operation;
        this.value = value;
    }

    public UserTrace() {
    }

    private long id;

    private String userId;

    private String operation;

    private String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
