package com.atguigu.spring5AoP.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 2. 增强类
 * (1)相同切入点进行抽取
 * (2)多个增强类，可以设置优先级，值越小优先级越高
 */
@Component
@Aspect
@Order(1)
public class UserProxy02 {

    /**
     * around before...
     * before...
     * around before pointDemo...
     * before pointDemo...
     * add...
     * around after pointDemo...
     * after pointDemo...
     * afterReturning pointDemo...
     * around after...
     * after...
     * afterReturning...
     */

    //相同切入点进行抽取
    @Pointcut(value = "execution(* com.atguigu.spring5AoP.aopanno.User.add(..))")
    public void pointDemo(){

    }

    // 前置通知 @Before
    @Before(value = "pointDemo()")
    public void before(){
        System.out.println("before pointDemo...");
    }

    // 后置通知,在方法之后执行，最终通知，不管有没有异常都执行
    @After(value = "pointDemo()")
    public void after() {
        System.out.println("after pointDemo...");
    }

    // 后置通知，在返回值之后进行执行，也叫返回通知
    @AfterReturning(value = "pointDemo()")
    public void afterReturning() {
        System.out.println("afterReturning pointDemo...");
    }

    // 后置通知，异常才会执行，
    @AfterThrowing(value = "pointDemo()")
    public void afterThrowing() {
        System.out.println("afterThrowing pointDemo...");
    }

    // 环绕通知
    @Around(value = "pointDemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before pointDemo...");

        // 被增强的方法进行执行
        proceedingJoinPoint.proceed();

        System.out.println("around after pointDemo...");
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

