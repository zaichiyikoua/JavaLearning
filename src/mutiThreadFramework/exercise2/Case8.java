package mutiThreadFramework.exercise2;

import java.util.concurrent.LinkedBlockingQueue;

/*
*	多线程API和框架   练习题
*	@author  zaichiyikoua
*	@time  2020年1月3日
*	@description  { LinkedBlockingQueue }
*/

public class Case8 {
    // 和ArrayBlockingQueue大同小异，API和功能也差不多，这里就简单练习
    // 区别就当作数组和链表的区别
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            LinkedBlockingQueue queue = new LinkedBlockingQueue(3);
            queue.put("a1");
            queue.put("a2");
            queue.put("a3");
            System.out.println(queue.size());
            System.out.println(System.currentTimeMillis());
            queue.put("a4");
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
