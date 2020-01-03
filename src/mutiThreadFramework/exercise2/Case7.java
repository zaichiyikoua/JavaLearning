package mutiThreadFramework.exercise2;

import java.util.concurrent.ArrayBlockingQueue;

/*
*	多线程API和框架   练习题7
*	@author  zaichiyikoua
*	@time  2020年1月3日
*	@description  { ArrayBlockingQueue }
*/

public class Case7 {
    // ArrayBlockingQueue的加入数据
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        try {
            ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
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

        // 结果如下
//        3
//        1578040035608

        // 这是因为new ArrayBlockingQueue(3)设定了最大容量，所以添加第四个的时候添加不了
        // 然后线程呈现等待状态
    }

    // ArrayBlockingQueue的取走数据
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        try {
            ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
            System.out.println("begin" + System.currentTimeMillis());
            System.out.println(queue.take());
            System.out.println("end" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 也是一样的，进入等待状态，因为队列中没有数据
//      begin1578040276210
    }
}
