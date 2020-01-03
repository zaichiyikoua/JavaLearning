package mutiThreadFramework.exercise2;

import java.util.HashMap;

/*
*	多线程API和框架   练习题1
*	@author  zaichiyikoua
*	@time  2020年1月3日
*	@description  { ConcurrentHashMap的使用之 HashMap是非线程安全的 }
*/

public class Case {
    // 多个线程操作的情况，会出现问题"假死状态"
    @SuppressWarnings("rawtypes")
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        HashMap map = new HashMap();

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

    // 单线程状态下符合预期结果，证明HashMap在单线程条件下可以正确运行
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        HashMap map = new HashMap();
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
    }
}
