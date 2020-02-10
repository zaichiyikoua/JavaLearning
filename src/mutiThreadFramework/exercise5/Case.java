package mutiThreadFramework.exercise5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题
*	@author  zaichiyikoua
*	@time  2020年2月10日
*	@description  { get()结合ExecutorService中的submit()的使用 }
*/

public class Case implements Callable<String> {
    // 默认情况下thread对象是不具备返回值的功能，如果需要取得返回值，需要使用future和callable来实现
    // Callable接口的call()方法是有返回值的，Runnable接口的run()没有返回值
    private int age;

    public Case(int age) {
        super();
        this.age = age;
    }

    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "返回值 年龄是: " + age;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Case callable = new Case(100);
            // 线程池初始化
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 3, 5l, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>());
            // 执行任务
            Future<String> future = poolExecutor.submit(callable);
            // 得到返回值，使用future的get()方法
            System.out.println(future.get());// 返回值 年龄是: 100
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
