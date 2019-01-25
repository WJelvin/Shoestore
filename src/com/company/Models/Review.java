package com.company.Models;

public class Review {

    private int id;
    private String comment;
    private Customer customer;
    private Product product;
    private Rating rating;

    public Review(int id, String comment, Customer customer, Product product, Rating rating) {
        this.id = id;
        this.comment = comment;
        this.customer = customer;
        this.product = product;
        this.rating = rating;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
