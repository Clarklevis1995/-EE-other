package com.java.jdbc.demo;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @program: JDBCDemo
 * @description
 * @author: ClarkLevis
 * @Date Created in: 2021-02-20 16:14
 * @Modified by:
 **/
public class Demo1Test {

    @Test
    public void createTable() {
    }

    @Test
    public void insertData() throws SQLException, ClassNotFoundException {
        Demo1.insertData();
    }

    @Test
    public void deleteData() throws SQLException, ClassNotFoundException {
        Demo1.deleteData();
    }

    @Test
    public void updateData() throws SQLException, ClassNotFoundException {
        Demo1.updateData();
    }

    @Test
    public void queryData() throws SQLException, ClassNotFoundException {
        Demo1.queryData();
    }
}