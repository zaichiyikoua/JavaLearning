package mutiThread.exercise3;

import java.util.ArrayList;
import java.util.List;

/*
*	多线程核心   练习题1
*	@author  zaichiyikoua
*	@time  2019年12月26日
*	@description  {	wait和notify机制之  不使用wait和notify的情况  }
*/

public class Case {
    // 线程可见
    volatile private List<String> list = new ArrayList<String>();

    public void add() {
        list.add("****");
    }

    public int size() {
        return list.size();
    }

    // 案例为A线程增加数量，B线程监听，数量到5时B提出消息通知
    // 从结果上看因为使用了volatile关键字，让线程之间可以通信，但是B线程一直在不停的轮询去检测是否达到了5
    // 这样的话很浪费cpu的资源
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Case service = new Case();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    for (int i = 0; i < 10; i++) {
                        service.add();
                        System.out.println("增加" + (i + 1) + "个元素");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "线程A").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    // 这里死循环，让线程一直执行
                    while (true) {
                        if (service.size() == 5) {
                            System.err.println("集合中数量达到5了，线程退出");
                            throw new InterruptedException();
                        }
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "线程B").start();
        // 输出结果：
//		增加4个元素
//		增加5个元素
//		集合中数量达到5了，线程退出
//		java.lang.InterruptedException
//			at mutiThread.exercise3.case1.ThreadB.run(ThreadB.java:19)
//		增加6个元素
//		增加7个元素
//		增加8个元素
//		增加9个元素
//		增加10个元素
    }

}
