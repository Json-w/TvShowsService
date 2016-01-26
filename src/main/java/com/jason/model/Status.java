package com.jason.model;

public enum Status {
    SUCCESS(1, "success"),
    FAILURE(0, "failure");

    private int statusCode;
    private String statusDesc;

    Status(int statusCode, String statusDesc) {
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }
}
