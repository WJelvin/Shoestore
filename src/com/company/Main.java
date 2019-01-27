package com.company;

import com.company.Models.Customer;
import com.company.Models.Product;
import com.company.View.UserInterface;

import java.util.List;
//import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DbRepo db = new DbRepo();
        UserInterface ui = new UserInterface();

        List<Customer> customers = db.getAllCustomers();
        List<Product> products = db.getAllProductsInStock();

//        int chosenCustomer = ui.choseCustomer(customers);
        int chosenProduct = ui.choseProduct(products);



    }
}