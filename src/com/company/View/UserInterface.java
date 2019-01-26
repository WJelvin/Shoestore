package com.company.View;

import com.company.Models.Customer;

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

}
