package com.company.Models;


import java.sql.Date;

public class Order {

    private int id;
    private Date orderDate;
    private int customerid;

    public Order(int id, Date orderDate, int customerid) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerid = customerid;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }
}
