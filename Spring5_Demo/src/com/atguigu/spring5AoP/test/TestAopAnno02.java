package com.atguigu.spring5AoP.test;

import com.atguigu.spring5AoP.aopanno.User;
import com.atguigu.spring5AoP.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopAnno02 {

    @Test
    public void testAnno(){
        ApplicationContext context = new AnnotationConfigApplicationContext("configAop.class");


        Book book = context.getBean("book", Book.class);
        book.buy();

    }
}
