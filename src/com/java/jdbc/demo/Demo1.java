package com.java.jdbc.demo;

import jdk.jshell.StatementSnippet;

import java.sql.*;

/**
 * @program: JDBCDemo
 * @description
 * @author: ClarkLevis
 * @Date Created in: 2021-02-19 11:36
 * @Modified by:
 **/
public class Demo1 {
    public static void createTable() throws ClassNotFoundException, SQLException {
        //1. 加载数据库驱动
        //  mysql6以下驱动：com.mysql.jdbc.Driver
        //  mysql6和6以上驱动：com.mysql.cj.jdbc.Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 通过驱动管理器。获取JDBC的连接对象
        //  链接地址格式：主协议：子协议：//ip地址：端口号/数据库名称
        //             mysql:       jdbc:mysql://localhost:3306/test
        //为了保证时区的正确性，在mysql的url后面加上时区的参数：?serverTimezone=UTC
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?serverTimezone=UTC","root","146768");
        //3. 通过连接对象创建SQL的执行对象（SQL执行环境）
        Statement state = conn.createStatement();
        //4. 通过SQL执行对象，执行SQL
        state.execute("create table person(id int, nickname varchar(32))");
        //5. 释放连接
        state.close();
        conn.close();

    }
    public static void insertData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC","root","146768");
        Statement state = conn.createStatement();
        int flag = state.executeUpdate("insert into person value(1,'张三'),(2,'李四'),(3,'王二')");
        state.close();
        conn.close();
        System.out.println("返回"+flag);
    }

    public static void deleteData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC","root","146768");
        Statement state = conn.createStatement();
        int flag = state.executeUpdate("delete from person where id=1");
        state.close();
        conn.close();
        System.out.println("返回"+flag);
    }

    public static void updateData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC","root","146768");
        Statement state = conn.createStatement();
        state.executeUpdate("update person set nickname='王五' where id=2");
        state.close();
        conn.close();
    }

    public static void queryData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC","root","146768");
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("select * from person");
        while(rs.next()){
            int id = rs.getInt("id");
            String nickname = rs.getString("nickname");
            System.out.println("id="+id+"\tnickname="+nickname);
        }
        rs.close();
        state.close();
        conn.close();
    }


}
