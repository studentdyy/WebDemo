package com.demo.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BDConnection {
    private static final String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
    private static final String user = "root";
    private static final String password="123";
    public Connection con = null;
    public PreparedStatement preparedStatement = null;

    public BDConnection(String sql) {
        try{
            System.out.println("正在连接数据库。。。");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, user, password);
            System.out.println("连接成功");
            preparedStatement = con.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }

    }
    public void close() {
        try {
            this.con.close();
            this.preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
