package com.aninfo.model.ticket;

public enum Severity {
    S1(7),
    S2(30),
    S3(90),
    S4(365);

    private int value;

    private Severity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
