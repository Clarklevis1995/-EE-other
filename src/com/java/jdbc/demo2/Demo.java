package com.java.jdbc.demo2;

/**
 * @program: JDBCDemo
 * @description
 * @author: ClarkLevis
 * @Date Created in: 2021-02-20 21:32
 * @Modified by:
 **/
public class Demo {
    public static void main(String[] args) {
        Fruit fruit = FruitFactory.get();
        fruit.eat();
    }
}
