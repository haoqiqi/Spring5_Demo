package com.atguigu.spring5AoP.test;

import com.atguigu.spring5AoP.aopanno.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopAnno {

    @Test
    public void testAnno(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beanAOP1.xml");
        User user = context.getBean("user", User.class);
        user.add();

    }
}
