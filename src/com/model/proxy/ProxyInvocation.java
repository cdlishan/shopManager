package com.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocation implements InvocationHandler {

    private Object obj;
    
    public ProxyInvocation(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("before invoke");
        method.invoke(obj, args);
        System.out.println("after invoke");
        return null;
    }

}
