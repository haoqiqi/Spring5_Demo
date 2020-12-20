package com.atguigu.spring5AoP.aopanno;

import org.springframework.stereotype.Component;

/**
 * 1. 创建类,被增强
 */
@Component
public class User {
    public void add(){
        System.out.println("add...");
    }
}
