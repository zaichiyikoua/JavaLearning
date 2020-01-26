package designPattern.pattern13.case1;

import java.util.ArrayList;

//抽象目标类
public abstract class MySubject {
    @SuppressWarnings("rawtypes")
    protected ArrayList observers = new ArrayList();

    // 注册方法
    @SuppressWarnings("unchecked")
    public void attach(MyObserver observer) {
        observers.add(observer);
    }

    // 注销方法
    public void detach(MyObserver observer) {
        observers.remove(observer);
    }

    // 抽象通知方法
    public abstract void cry();
}
