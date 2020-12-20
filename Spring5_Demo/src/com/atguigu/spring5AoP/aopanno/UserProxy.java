package com.atguigu.spring5AoP.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 2. 增强类
 */
@Component
@Aspect
@Order(0)
public class UserProxy {

    /**
     * around before...
     * before...
     * add...
     * around after...
     * after...
     * afterReturning...
     */

    // 前置通知 @Before
    @Before(value = "execution(* com.atguigu.spring5AoP.aopanno.User.add(..))")
    public void before(){
        System.out.println("before...");
    }

    // 后置通知,在方法之后执行，最终通知，不管有没有异常都执行
    @After(value = "execution(* com.atguigu.spring5AoP.aopanno.User.add(..))")
    public void after() {
        System.out.println("after...");
    }

    // 后置通知，在返回值之后进行执行，也叫返回通知
    @AfterReturning(value = "execution(* com.atguigu.spring5AoP.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    // 后置通知，异常才会执行，
    @AfterThrowing(value = "execution(* com.atguigu.spring5AoP.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    // 环绕通知
    @Around(value = "execution(* com.atguigu.spring5AoP.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before...");

        // 被增强的方法进行执行
        proceedingJoinPoint.proceed();

        System.out.println("around after...");
    }
}

/**
 * 3. 进行通知的配置
 * （1）在spring配置文件中，开启注解扫描
 * （2）使用注解创建User和UserProxy对象
 * （3）在增强类上增加注解@Aspect
 * （4）在spring配置文件中开启生成代理对象
 *
 * 4. 配置不同类型的通知
 * （1）在增强类的里面，在作为通知方法上面添加通知类型注解，使用切入点表达式配置
 *      前置通知@Before
 *      @Before(value = "execution(* com.atguigu.spring5AoP.aopanno.User.add(..))")
 */

