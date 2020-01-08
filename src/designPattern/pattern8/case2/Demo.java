package designPattern.pattern8.case2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InvocationHandler handler;
        AbstractSubject subject;

        handler = new DynamicProxy(new RealSubjectA());
        subject = (AbstractSubject) Proxy.newProxyInstance(AbstractSubject.class.getClassLoader(),
                new Class[] { AbstractSubject.class }, handler);
        subject.request();

//        调用之前
//        RealSubjectA show
//        调用之后
    }

}
