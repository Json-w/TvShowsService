package com.jason.model;

import static com.jason.model.Status.*;

public class ResponseData {
    private int statusCode;
    private String statusDesc;
    private Object data;

    public ResponseData(int statusCode, String statusDesc, Object data) {
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
        this.data = data;
    }

    public ResponseData() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public void setStatus(Status status) {
        setStatusCode(status.getStatusCode());
        setStatusDesc(status.getStatusDesc());
    }
}
