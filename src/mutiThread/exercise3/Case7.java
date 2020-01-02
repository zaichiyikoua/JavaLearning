package mutiThread.exercise3;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题7
*	@author  zaichiyikoua
*	@time  2019年12月28日
*	@description  {	join()的使用之 基本用法  }
*/

public class Case7 {
    // join()的使用情况：
    // 很多时候，主线程创建之后启动子线程，让子线程去计算复杂的运算，很多时候主线程会先于子线程结束
    // 所以要让主线程等待子线程执行完成之后再结束

    // join()的作用是使线程执行run()中的方法，当前线程阻塞，直到join()线程执行完成
    // 这样的话，就具有了让线程排队的作用，达到了同步的效果，但是和同步不同的是，
    // join()内部使用的wait()，所以会释放锁
    public static void main1(String[] args) {
        try {
            // TODO Auto-generated method stub
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        // TODO Auto-generated method stub
                        int value = (int) (Math.random() * 10000);
                        System.out.println(value);
                        TimeUnit.SECONDS.sleep(2);
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            thread.join();
            System.out.println("main中输出");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        // 输出如下:
//		1789
//		main中输出
        // thread线程中先输出，main中后输出，但是这里没有进行同步操作却达到了同步的效果
    }
}
