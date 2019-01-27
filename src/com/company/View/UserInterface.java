package com.company.View;

import com.company.Models.Customer;
import com.company.Models.Product;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner sc = new Scanner(System.in);

    public int choseCustomer(List<Customer> customers) {
        int counter = 0;
        for (Customer customer : customers) {
            System.out.print(counter + " ");
            System.out.println(customer);
            counter++;
        }

        System.out.println("Vem shoppar (Ange siffra): ");
        int choice = Integer.parseInt(sc.nextLine());

        return choice;
    }

    public int choseProduct(List<Product> products) {
        int counter = 0;
        for (Product product : products) {
            System.out.print(counter + " ");
            System.out.println(product);
            counter++;
        }

        System.out.println("Vem shoppar (Ange siffra): ");
        int choice = Integer.parseInt(sc.nextLine());

        return choice;
    }

}
