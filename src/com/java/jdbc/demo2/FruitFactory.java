package com.java.jdbc.demo2;

/**
 * @program: JDBCDemo
 * @description
 * @author: ClarkLevis
 * @Date Created in: 2021-02-20 17:54
 * @Modified by:
 **/
public class FruitFactory {
    public static Fruit get(){
        //return new Apple();
        return new Banana();
    }
}
