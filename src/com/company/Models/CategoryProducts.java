package com.company.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CategoryProducts {

    private Map<Integer, List<Product>> categoryMap = new TreeMap<>();

    public ArrayList<Product> getProductsFromCategory(int categoryId) {
        return (ArrayList<Product>) categoryMap.get(categoryId);
    }

    public void addProductToCategory(int categoryId, Product product) {
        categoryMap.computeIfAbsent(categoryId, o -> new ArrayList<>()).add(product);
    }
}
