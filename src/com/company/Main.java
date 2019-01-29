package com.company;

import com.company.Controllers.Controller;
import com.company.Models.Customer;
import com.company.Models.Order;
import com.company.Models.Product;
import com.company.View.UserInterface;

import java.util.List;
//import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        controller.startShopping();

    }
}