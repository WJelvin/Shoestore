package com.company;


import com.company.Models.*;

import java.io.FileInputStream;
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

    public List<Product> getAllProductsInStock(){
        List<Product> products = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from products inner join brands on products.brandId = brands.id having stock > 0")){

            while (resultSet.next()) {
                int id = resultSet.getInt("products.id");
                String name = resultSet.getString("name");
                String colour = resultSet.getString("colour");
                int size = resultSet.getInt("size");
                double price = resultSet.getDouble("price");
                Brand brand = new Brand(resultSet.getInt("brands.id"), resultSet.getString("brands.name"));
                int stock = resultSet.getInt("stock");
                products.add(new Product(id, name, colour, size, price, brand, stock));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Order> getOrdersByCustomerId(int customerId){
        List<Order> orders = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from orders inner join customers " +
                     "on orders.customerId = Customers.id having customers.id = " + customerId + " and shipped is false")){

            while (resultSet.next()) {
                int id = resultSet.getInt("orders.id");
                Date orderDate = resultSet.getDate("orderDate");
                Customer customer = getCustomerById(customerId);
                orders.add(new Order(id, orderDate, customer));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public String addToCart(int customerId, int orderId, int productId) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
            CallableStatement statement = con.prepareCall("Call addToCart(?, ?, ?)");

            con.setAutoCommit(false);

            statement.setInt(1,customerId);
            statement.setInt(2,orderId);
            statement.setInt(3,productId);
            statement.execute();

            con.commit();
            return "Din vara har lagts till i ordern!";


        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return "Något gick tyvärr fel. Din vara har inte lagts till i ordern. Vid kontakt med kundtjänst uppge följande felkod: " + e.getErrorCode();
        }
    }

    public String addToCart(int customerId, int productId) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            CallableStatement statement = con.prepareCall("Call addToCart(?, ?, ?)");

            con.setAutoCommit(false);

            statement.setInt(1,customerId);
            statement.setNull(2,Types.INTEGER);
            statement.setInt(3,productId);
            statement.execute();

            con.commit();
            return "Din vara har lagts till i ordern!";

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return "Något gick tyvärr fel. Din vara har inte lagts till i ordern. Vid kontakt med kundtjänst uppge följande felkod: " + e.getErrorCode();
        }
    }


}
