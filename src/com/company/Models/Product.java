package com.company.Models;

public class Product {

    private int id;
    private String name;
    private String colour;
    private int size;
    private double price;
    private int brandId;
    private int stock;

    public Product(int id, String name, String colour, int size, double price, int brandId, int stock) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.size = size;
        this.price = price;
        this.brandId = brandId;
        this.stock = stock;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
