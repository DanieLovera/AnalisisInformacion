package com.aninfo.model.ticket;

public enum Severity {
    S1(7),
    S2(30),
    S3(90),
    S4(365);

    private Integer value;

    private Severity(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
