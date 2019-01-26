package com.company;


import com.company.Models.City;
import com.company.Models.Customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbRepo {

    private Properties p = new Properties();

    public DbRepo(){

        try {
            p.load(new FileInputStream("src/Db.properties"));
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }


    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("select id from Customers")){

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                customers.add(getCustomerById(id)); //todo: Skriva egen kod för metoden för att undvika onödiga db-anrop
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer getCustomerById(int id) {

        Customer customer = null;

        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from Customers where id = " + id)){

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                City city = getCityByCustomerId(id);
                customer = new Customer(id, name, city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public City getCityByCustomerId(int id) {
        City city = null;

        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from Cities inner join Customers on Cities.id = Customers.cityId having customers.id = " + id)){

            while (resultSet.next()) {
                int cityId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                city = new City(id, name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }


}
