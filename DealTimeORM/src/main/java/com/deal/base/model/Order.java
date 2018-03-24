package com.deal.base.model;

import java.io.Serializable;

public class Order implements Serializable {

    private long orderId;
    private Customer customer;
    private Product orderProduct;
    private int quantity;
    private char status; // 'c' --> in cart .. 'd' --> done 
                            // if customer cancelled order it will be deleted for now as we don't save history uptill now
    
    public Order() {
    }
    
    public Order(Customer customer, Product orderProduct, int quantity, char status) {
        this.customer = customer;
        this.orderProduct = orderProduct;
        this.quantity = quantity;
        this.status = status;
    }
    
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Product orderProduct) {
        this.orderProduct = orderProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customer=" + customer + ", orderProduct=" + orderProduct + ", quantity=" + quantity + ", status=" + status + '}';
    }
    
}
