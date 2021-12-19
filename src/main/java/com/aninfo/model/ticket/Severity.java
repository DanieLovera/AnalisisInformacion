package com.aninfo.model.ticket;

public enum Severity {
    S1(7),
    S2(30),
    S3(90),
    S4(365);

    private final Integer responseTime;

    Severity(Integer responseTime) {
        this.responseTime = responseTime;
    }

    public Integer getResponseTime() {
        return responseTime;
    }
}
