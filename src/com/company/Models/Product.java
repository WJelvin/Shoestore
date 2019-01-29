package com.company.Models;

public class Product {

    private int id;
    private String name;
    private String colour;
    private int size;
    private double price;
    private Brand brand;
    private int stock;

    public Product(int id, String name, String colour, int size, double price, Brand brand, int stock) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.size = size;
        this.price = price;
        this.brand = brand;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "-> " + "Märke: " + brand +
                ", Modell: " + name +
                ", Färg: " + colour +
                ", Storlek: " + size +
                ", Pris: " + price +
                ", Lagerantal: " + stock + "\n";
    }
}
