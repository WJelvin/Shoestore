package com.company;

import com.company.Models.Customer;
import com.company.View.UserInterface;

import java.util.List;
//import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DbRepo db = new DbRepo();
        UserInterface ui = new UserInterface();

        List<Customer> al = db.getAllCustomers();

        int chosenCustomer = ui.choseCustomer(al);



    }
}