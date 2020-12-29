package com.usc;

import java.sql.*;
import java.util.Date;

public class Notes1 extends Thread {

    @Override
    public void run() {
        insert(1, new Date().toString(),"study","i read programming today");
        insert(2, new Date().toString(),"study","i read math today");
        insert(3, new Date().toString(),"study","i read language today");
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
