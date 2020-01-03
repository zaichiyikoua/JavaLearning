package mutiThreadFramework.exercise2;

import java.util.concurrent.ConcurrentLinkedQueue;

/*
*	多线程API和框架   练习题5
*	@author  zaichiyikoua
*	@time  2020年1月3日
*	@description  { ConcurrentLinkedQueue的使用 }
*/

public class Case5 {
    // ConcurrentLinkedQueue提供了并发环境的队列容器
    // 用法也和队列一样的，唯一的区别就是支持了并发
    // poll()如果没有获得数据会返回null，而不是抛出异常，作用是弹出并返回队列的头部
    // offer()还是一样的，将元素添加进入队列的队尾
    // peek(),element()都是一样的使用
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        Thread thread = new Thread(new Runnable() {

            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 0; i < 30; i++) {
                    queue.add("threadA" + (i + 1));
                }
            }
        }, "线程A");
        Thread thread2 = new Thread(new Runnable() {

            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 0; i < 30; i++) {
                    queue.add("threadB" + (i + 1));
                }
            }
        }, "线程B");

        thread.start();
        thread2.start();

        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(queue.size());
        System.out.println(queue.poll());
    }

    // 60
    // threadA1

}
