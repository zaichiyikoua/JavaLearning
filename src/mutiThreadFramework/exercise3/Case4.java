package mutiThreadFramework.exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
*	多线程API和框架   练习题4
*	@author  zaichiyikoua
*	@time  2020年1月14日
*	@description  { 使用executor工厂来创建线程池之 使用newSingleThreadPool来创建线程池 }
*/

public class Case4 {
    // 还是一样的,就是限制线程池中的最大容量为1,最多只有一个线程在运行
    // 不过这种创建方法的好处就是可以实现"以队列的方式来执行任务"
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            singleThreadExecutor.execute(new MyThread("" + (i + 1)));
        }
    }

}
