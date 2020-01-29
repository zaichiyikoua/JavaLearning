package mutiThreadFramework.exercise3;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题6
*	@author  zaichiyikoua
*	@time  2020年1月29日
*	@description  { 前两个构造参数和getCorePoolSize()和getMaximumPoolSize()方法 }
*/

public class Case6 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getMaximumPoolSize());
        System.out.println("***************************");
        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        System.out.println(executor2.getCorePoolSize());
        System.out.println(executor2.getMaximumPoolSize());

//        7
//        8
//        ***************************
//        7
//        8

        // 熟悉下api，查询线程池中保存的core线程数量为7，最大为8
    }

}
