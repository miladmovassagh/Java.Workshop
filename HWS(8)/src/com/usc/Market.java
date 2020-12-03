package com.usc;

import java.sql.*;

public class Market implements AutoCloseable {
    private String productCategory;
    private String productName;
    private long price;
    private Connection connection;
    private PreparedStatement preparedStatement;

    public Market() {

    }

    public Market(String productCategory, String productName, long price) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.price = price;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public Market setProductCategory(String productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public Market setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public Market setPrice(long price) {
        this.price = price;
        return this;
    }

    public void connection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert() throws Exception {
        preparedStatement = connection.prepareStatement("insert into market(product_category,product_name,price) values (?,?,?)");
        preparedStatement.setString(1,productCategory);
        preparedStatement.setString(2,productName);
        preparedStatement.setLong(3,price);
        preparedStatement.executeUpdate();
        System.out.println("insert successfully");
    }

    public void showProducts(String categoryName) throws Exception {
        boolean check = false;
        preparedStatement = connection.prepareStatement("select * from market");
        ResultSet resultSet = preparedStatement.executeQuery();
        int i = 1;
        while(resultSet.next()) {
            if(resultSet.getString("product_category").equals(categoryName)) {
                check = true;
                System.out.println(i + "th product information");
                System.out.println("name: " + resultSet.getString("product_name"));
                System.out.println("price per kilo: " + resultSet.getString("price"));
                i++;
            }
        }
        if(!check)
            System.out.println("Category is empty.");
    }

    public void commit() throws Exception {
        connection.commit();
    }

    public void rollback() throws Exception {
        connection.rollback();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
