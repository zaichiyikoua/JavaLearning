package mutiThreadFramework.exercise2;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题2
*	@author  zaichiyikoua
*	@time  2020年1月3日
*	@description  { ConcurrentHashMap的使用之 HashTable线程安全 }
*/

public class Case2 {

    // HashTable是可以在并发条件下使用的K-V集合
    // 但是，当多个线程分别调用迭代器，然后调用remove()等会改变结构的方法的时候，会出现异常
    // 也就是说不支持并发条件下集合的删除
    @SuppressWarnings("rawtypes")
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        Hashtable map = new Hashtable();

        new Thread(new Runnable() {

            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 0; i < 100; i++) {
                    map.put("ThreadA" + (i + 1), "ThreadA" + i + 1);
                    System.out.println("ThreadA" + (i + 1));
                }
            }
        }, "线程A").start();

        new Thread(new Runnable() {

            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 0; i < 100; i++) {
                    map.put("ThreadB" + (i + 1), "ThreadB" + i + 1);
                    System.out.println("ThreadB" + (i + 1));
                }
            }
        }, "线程B").start();
        // 两个线程都添加了100个元素
    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        Hashtable map = new Hashtable();

        new Thread(new Runnable() {

            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 0; i < 10; i++) {
                    map.put("ThreadA" + (i + 1), "ThreadA" + i + 1);
                    System.out.println("ThreadA" + (i + 1));
                }
            }
        }, "线程A").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    Iterator iterator = map.keySet().iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
