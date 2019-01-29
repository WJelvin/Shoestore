package com.company.Controllers;

import com.company.DbRepo;
import com.company.Models.Customer;
import com.company.Models.Order;
import com.company.Models.Product;
import com.company.View.UserInterface;

import java.util.List;

public class Controller {

    DbRepo db = new DbRepo();
    UserInterface ui = new UserInterface();

    List<Customer> customers = db.getAllCustomers();
    List<Product> products = db.getAllProductsInStock();

    public void startShopping() {

        int chosenCustomer = ui.choseCustomer(customers);
        System.out.println(customers.get(chosenCustomer));
        int chosenProduct = ui.choseProduct(products);

        List<Order> orders = db.getOrdersByCustomerId(customers.get(chosenCustomer).getId());

        int chosenOrder = ui.choseOrder(orders);
        if (chosenOrder == orders.size()) {
            ui.printOrderStatus(db.addToCart(customers.get(chosenCustomer).getId(), products.get(chosenProduct).getId()));
        } else {
            ui.printOrderStatus(db.addToCart(customers.get(chosenCustomer).getId(), orders.get(chosenOrder).getId(), products.get(chosenProduct).getId()));
        }


    }

}
