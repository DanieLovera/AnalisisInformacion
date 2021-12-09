package com.aninfo.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @JsonProperty("id")
    private Long productID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("version")
    private Float version;

    public Long getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public Float getVersion() {
        return version;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(Float version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}
