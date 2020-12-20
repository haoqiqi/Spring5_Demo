package com.atguigu.spring5AoP.Demo01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * JDK中的动态代理
 */

public class JDKProxy {
    public static void main(String[] args) {
        // 1. 创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        String a = dao.update("a");
        System.out.println(a);
    }
}


class UserDaoProxy implements InvocationHandler{

    // 1. 把创建的是谁的代理对象，把谁传递进来
    // 有参构造
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

    // 2. 增强的逻辑部分
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 方法之前与之后的代码
        System.out.println("方法之前执行" + method.getName() + ":传递的参数" + Arrays.toString(args));
        Object res = method.invoke(obj, args);
        System.out.println("方法之后执行" + obj);


        return null;
    }
}