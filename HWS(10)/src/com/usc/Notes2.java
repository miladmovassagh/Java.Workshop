package com.usc;

import java.sql.*;
import java.util.Date;

public class Notes2 extends Thread {

    @Override
    public void run() {
        insert(4, new Date().toString(),"study","i read physics today");
        insert(5, new Date().toString(),"study","i read java today");
        insert(6, new Date().toString(),"study","i read family knowledge today");
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
