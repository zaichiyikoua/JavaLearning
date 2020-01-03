package mutiThreadFramework.exercise2;

import java.util.concurrent.ConcurrentHashMap;

/*
*	多线程API和框架   练习题3
*	@author  zaichiyikoua
*	@time  2020年1月3日
*	@description  { ConcurrentHashMap的使用之 concurrentHashMap }
*/

public class Case3 {

    // ConcurrentHashMap是支持并发的集合
    // 比起HashTabel，ConcurrentHashMap可以改变结构
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConcurrentHashMap map = new ConcurrentHashMap();

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
    }

}
