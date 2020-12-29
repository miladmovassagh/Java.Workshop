package com.usc;

import java.sql.*;
import java.util.Date;

public class Notes3 extends Thread {

    @Override
    public void run() {
        insert(7, new Date().toString(),"study","i read geology today");
        insert(8, new Date().toString(),"study","i read technical drawing today");
        insert(9, new Date().toString(),"study","i read thought today");
    }

    public void insert(int id, String date, String subject, String text) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "miladmovassagh", "mehr1379");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Notes(id,dates,subject,text) values (?,?,?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, subject);
            preparedStatement.setString(4, text);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
