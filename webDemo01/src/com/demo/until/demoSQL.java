package com.demo.until;

import java.sql.ResultSet;
import java.sql.SQLException;

public class demoSQL {
    public static void main(String[] args) {
        String sql = "select * from fruit_table";
        BDConnection bdConnection = new BDConnection(sql);
        try{
            ResultSet result = bdConnection.preparedStatement.executeQuery();
            while(result.next()){
                String uid = result.getString(1);
                String name = result.getString(2);
                String price = result.getString(3);
                String number = result.getString(4);
                System.out.println(uid+"\t" + name+"\t" +price+"\t" +number);
            }
            result.close();
            bdConnection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
