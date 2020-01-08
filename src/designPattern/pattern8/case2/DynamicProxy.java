package designPattern.pattern8.case2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//动态代理类
public class DynamicProxy implements InvocationHandler {
    private Object object;

    public DynamicProxy() {
        super();
    }

    public DynamicProxy(Object object) {
        super();
        this.object = object;
    }

    public void preRequest() {
        System.out.println("调用之前");
    }

    public void afterRequest() {
        System.out.println("调用之后");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        preRequest();
        method.invoke(object, args);
        afterRequest();
        return null;
    }

}
