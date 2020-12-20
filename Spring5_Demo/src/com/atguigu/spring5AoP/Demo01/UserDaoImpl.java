package com.atguigu.spring5AoP.Demo01;

public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("add");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update");
        return id;
    }
}
