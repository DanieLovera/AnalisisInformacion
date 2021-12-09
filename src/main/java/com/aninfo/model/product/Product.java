package com.aninfo.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @JsonProperty("id")
    private Long productID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("versions")
    private Collection<Float> versions;

    public Product(Long productID, String name, Collection<Float> versions) {
        this.productID = productID;
        this.name = name;
        this.versions = versions;
    }

    public Long getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public Collection<Float> getVersions() {
        return versions;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(ArrayList<Float> version) {
        this.versions = version;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", versions=" + versions.toString() +
                '}';
    }
}
