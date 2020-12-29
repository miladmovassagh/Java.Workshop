package com.usc;

import java.sql.*;
import java.util.Date;

public class Notes4 extends Thread {

    @Override
    public void run() {
        insert(10, new Date().toString(),"study","i read literature today");
        insert(11, new Date().toString(),"study","i read arabic today");
        insert(12, new Date().toString(),"study","i read chemistry today");
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
