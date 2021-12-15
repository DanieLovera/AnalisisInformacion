package com.aninfo.model.ticket;

public class FilterParams {

    private Type type;
    private Boolean outOfTime;
    private Long productID;
    private String productVersion;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Boolean getOutOfTime() {
        return outOfTime;
    }

    public void setOutOfTime(Boolean outOfTime) {
        this.outOfTime = outOfTime;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }
}
