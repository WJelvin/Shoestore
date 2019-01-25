package com.company.Models;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OrderProducts {

    private Map<Integer, List<Product>> orderMap = new TreeMap<>();

    public ArrayList<Product> getProductsFromOrder(int orderId) {
        return (ArrayList<Product>) orderMap.get(orderId);
    }

    public void addProductToOrder(int orderId, Product product) {
        orderMap.computeIfAbsent(orderId, o -> new ArrayList<>()).add(product);
    }
}
