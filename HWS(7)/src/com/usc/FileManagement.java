package com.usc;

import java.sql.*;

public class FileManagement implements AutoCloseable {
    private String name;
    private String size;
    private String extension;
    private Connection connection;
    private PreparedStatement preparedStatement;

    public FileManagement() {

    }

    public FileManagement(String name, String size, String extension) {
        this.name = name;
        this.size = size;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public FileManagement setName(String name) {
        this.name = name;
        return this;
    }

    public String getSize() {
        return size;
    }

    public FileManagement setSize(String size) {
        this.size = size;
        return this;
    }

    public String getExtension() {
        return extension;
    }

    public FileManagement setExtension(String extension) {
        this.extension = extension;
        return this;
    }

    public void connection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert() throws Exception {
        preparedStatement = connection.prepareStatement ("insert into files(name, weight, extension) values (?,?,?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, size);
        preparedStatement.setString(3, extension);
        preparedStatement.executeUpdate();
        System.out.println("insert successfully");
    }

    public void update() throws Exception {
        if(checkInformation()) {
            preparedStatement = connection.prepareStatement("update files set weight = ?, extension = ? where name = ?");
            preparedStatement.setString(1, size);
            preparedStatement.setString(2, extension);
            preparedStatement.setString(3, name);
            preparedStatement.executeUpdate ();
            System.out.println("update successfully.");
        }
        else
            System.out.println("invalid name of file.");
    }

    public void delete() throws Exception {
        if(checkInformation()) {
            preparedStatement = connection.prepareStatement("delete from files where name = ?");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("delete successfully.");
        }
        else
            System.out.println("invalid name of file.");
    }

    public void select() throws Exception {
        preparedStatement = connection.prepareStatement ("select * from files");
        ResultSet resultSet = preparedStatement.executeQuery ();
        if(name != null) {
            if(checkInformation()) {
                while (resultSet.next()) {
                    if (resultSet.getString("name").equals(name)) {
                        System.out.println("file information:");
                        System.out.println("name of file: " + resultSet.getString("name"));
                        System.out.println("size of file: " + resultSet.getString("weight"));
                        System.out.println("extension of file: " + resultSet.getString("extension"));
                        break;
                    }
                }
            }
            else
                System.out.println("invalid name of file");
        }
        else {
            int i = 1;
            while (resultSet.next()) {
                FileManagement fileManagement = new FileManagement();
                fileManagement.setName(resultSet.getString("name"));
                fileManagement.setSize(resultSet.getString("weight"));
                fileManagement.setExtension(resultSet.getString("extension"));
                System.out.println(i + "th file information:");
                System.out.println("name of file: " + fileManagement.getName());
                System.out.println("size of file: " + fileManagement.getSize());
                System.out.println("extension of file: " + fileManagement.getExtension());
                i++;
            }
        }
    }

    public boolean checkInformation() throws Exception {
        boolean check = false;
        String name;
        preparedStatement = connection.prepareStatement ("select * from files");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next ()) {
            name = resultSet.getString("name");
            if(this.name != null && this.name.equals(name)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void commit() throws Exception{
        connection.commit ();
    }
    public void rollback() throws Exception{
        connection.rollback ();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close ();
        connection.close ();
    }
}
