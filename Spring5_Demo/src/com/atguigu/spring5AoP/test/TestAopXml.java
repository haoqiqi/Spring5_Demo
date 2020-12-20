package com.atguigu.spring5AoP.test;

import com.atguigu.spring5AoP.aopanno.User;
import com.atguigu.spring5AoP.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopXml {

    @Test
    public void testAnno(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beanAOP2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
