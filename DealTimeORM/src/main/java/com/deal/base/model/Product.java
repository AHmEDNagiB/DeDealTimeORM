package com.deal.base.model;

import java.io.Serializable;

public class Product implements Serializable {

    private long productId;
    private String productName;
    private String productDesc;
    private double productPrice;
    private int availableQuantity;
    private String productImageFileName;
    private Category productCategory;
     
    public Product() {
    }
    
    public Product(long productId) {
        this.productId=productId;
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Product(String productName, double productPrice, int availableQuantity, String productImageFileName) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.availableQuantity = availableQuantity;
        this.productImageFileName = productImageFileName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductImageFileName() {
        return productImageFileName;
    }

    public void setProductImageFileName(String productImageFileName) {
        this.productImageFileName = productImageFileName;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc + ", productPrice=" + productPrice + ", availableQuantity=" + availableQuantity + ", productImageFileName=" + productImageFileName + ", productCategory=" + productCategory + '}';
    }

}
