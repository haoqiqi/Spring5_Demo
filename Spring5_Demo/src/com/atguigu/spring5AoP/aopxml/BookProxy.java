package com.atguigu.spring5AoP.aopxml;

import org.aspectj.lang.annotation.Before;

public class BookProxy {

    public void before(){
        System.out.println("before...");
    }
}
