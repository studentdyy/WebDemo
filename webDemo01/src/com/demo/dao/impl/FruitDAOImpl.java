package com.demo.dao.impl;

import com.demo.dao.FruitDAO;
import com.demo.pojo.fruit;
import com.demo.until.BDConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FruitDAOImpl implements FruitDAO {
    @Override
    public List<fruit> getFruitList() {
        List<fruit> fruitsList = new ArrayList<fruit>();
        String sql = "select * from fruit_table";
        BDConnection bdConnection = new BDConnection(sql);
        try{
            ResultSet result = bdConnection.preparedStatement.executeQuery();
            while(result.next()){
                int uid = result.getInt(1);
                String name = result.getString(2);
                int price = result.getInt(3);
                int number = result.getInt(4);
                fruit fruit = new fruit(uid,name,price,number);
                fruitsList.add(fruit);
            }

            result.close();
            bdConnection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return fruitsList;
    }

    @Override
    public fruit getFruitListById(int id) {
        String sql = "SELECT * FROM fruit_table where id=?";
        BDConnection bdConnection = new BDConnection(sql);
        fruit fru = null;
        try {
            bdConnection.preparedStatement.setInt(1, id);
            ResultSet result = bdConnection.preparedStatement.executeQuery();
            while (result.next()) {
                int uid = result.getInt(1);
                String name = result.getString(2);
                int price = result.getInt(3);
                int number = result.getInt(4);
                fru = new fruit(uid, name, price, number);
            }
            result.close();
            bdConnection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return fru;
    }

    @Override
    public void updateFruitListById(fruit fru) {
        String sql = "update fruit_table set name=?,price=?,number=? where id = ?";
        BDConnection bdConnection = new BDConnection(sql);
        try{
            bdConnection.preparedStatement.setString(1,fru.getName());
            bdConnection.preparedStatement.setInt(2,fru.getPrice());
            bdConnection.preparedStatement.setInt(3,fru.getNumber());
            bdConnection.preparedStatement.setInt(4,fru.getUid());
            bdConnection.preparedStatement.executeUpdate();
            bdConnection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteFruitById(int uid) {
        String sql = "delete from fruit_table where id =?";
        BDConnection bdConnection = new BDConnection(sql);
        try{
            bdConnection.preparedStatement.setInt(1,uid);
            bdConnection.preparedStatement.executeUpdate();
            bdConnection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void addFruit(fruit fru) {
        String sql = "insert into fruit_table values(0,?,?,?)";
        BDConnection bdConnection = new BDConnection(sql);
        try{
            bdConnection.preparedStatement.setString(1,fru.getName());
            bdConnection.preparedStatement.setInt(2,fru.getPrice());
            bdConnection.preparedStatement.setInt(3,fru.getNumber());
            bdConnection.preparedStatement.executeUpdate();
            bdConnection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<fruit> getFruitListByPageNum(String keyWordName,int pageNum) {
        String sql = "select * from fruit_table where name like ? limit ?,5;";
        List<fruit> fruitsList = new ArrayList<>();
        BDConnection bdConnection =new BDConnection(sql);
        try{
            bdConnection.preparedStatement.setString(1,"%"+keyWordName+"%");
            bdConnection.preparedStatement.setInt(2,(pageNum-1)*5);
            ResultSet result = bdConnection.preparedStatement.executeQuery();
            while(result.next()){
                int uid = result.getInt(1);
                String name = result.getString(2);
                int price = result.getInt(3);
                int number = result.getInt(4);
                fruit fruit = new fruit(uid,name,price,number);
                fruitsList.add(fruit);
            }
            result.close();
            bdConnection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return fruitsList;
    }

    @Override
    public Long getFruitCount(String keyWordName) {
        String sql ="select count(*) from fruit_table where name like ?";
        BDConnection bdConnection =new BDConnection(sql);
        Long count = null;
        try{
            bdConnection.preparedStatement.setString(1,"%"+keyWordName+"%");
            ResultSet resultSet =bdConnection.preparedStatement.executeQuery();
            while(resultSet.next()){
                count = resultSet.getLong(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }


}
