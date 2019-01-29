package com.company.View;

import com.company.Models.Customer;
import com.company.Models.Order;
import com.company.Models.Product;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner sc = new Scanner(System.in);

    public int choseCustomer(List<Customer> customers) {
        System.out.println("------------------------------------------------------------");
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
        System.out.println("------------------------------------------------------------");
        int counter = 0;
        for (Product product : products) {
            System.out.print(counter + " ");
            System.out.println(product);
            counter++;
        }

        System.out.println("Vilken produkt vill du lägga till i din order (Ange siffra): ");
        int choice = Integer.parseInt(sc.nextLine());

        return choice;
    }

    public int choseOrder(List<Order> orders) {
        System.out.println("------------------------------------------------------------");
        int counter = 0;
        for (Order order : orders) {
            System.out.print(counter + " ");
            System.out.println(order);
            counter++;
        }

        System.out.println((counter) + " -> Ny beställning" + "\n");
        System.out.println("Vilken beställning vill du lägga till din produkt i (Ange siffra): ");
        int choice = Integer.parseInt(sc.nextLine());


        return choice;
    }

}
