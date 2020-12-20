package model.repository;

import model.entity.StoreEntity;

import java.sql.*;
import java.util.*;

public class StoreRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public StoreRepository() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","miladmovassagh","mehr1379");
        connection.setAutoCommit(false);
    }

    public void insert(StoreEntity storeEntity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into Clothing(name,code,gender,size_,price) values (?,?,?,?,?)");
        preparedStatement.setString(1,storeEntity.getName());
        preparedStatement.setInt(2,storeEntity.getCode());
        preparedStatement.setString(3,storeEntity.getGender());
        preparedStatement.setString(4,storeEntity.getSize());
        preparedStatement.setLong(5,storeEntity.getPrice());
        preparedStatement.executeUpdate();
    }

    public void update(StoreEntity storeEntity) throws Exception {
        preparedStatement = connection.prepareStatement("update Clothing set name = ?, gender = ?, size_ = ?, price = ? where code = ?");
        preparedStatement.setString(1,storeEntity.getName());
        preparedStatement.setString(2,storeEntity.getGender());
        preparedStatement.setString(3,storeEntity.getSize());
        preparedStatement.setLong(4,storeEntity.getPrice());
        preparedStatement.setInt(5,storeEntity.getCode());
        preparedStatement.executeUpdate();
    }

    public void delete(int code) throws Exception {
        preparedStatement = connection.prepareStatement("delete from Clothing where code = ? ");
        preparedStatement.setInt(1,code);
        preparedStatement.executeUpdate();
    }

    public List<StoreEntity> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from Clothing");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<StoreEntity> storeEntityList = new ArrayList<>();
        while(resultSet.next()) {
            StoreEntity storeEntity = new StoreEntity();
            storeEntity.setName(resultSet.getString("Name"));
            storeEntity.setCode(resultSet.getInt("Code")) ;
            storeEntity.setGender(resultSet.getString("Gender"));
            storeEntity.setSize(resultSet.getString("Size_"));
            storeEntity.setPrice(resultSet.getLong("Price"));
            storeEntityList.add(storeEntity);
        }
            return storeEntityList;
    }

    public void commit() throws Exception {
        connection.commit();
    }

    public void rollback() throws Exception {
        connection.rollback();
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
