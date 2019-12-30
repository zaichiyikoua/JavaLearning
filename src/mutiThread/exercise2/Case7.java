package mutiThread.exercise2;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题7
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	同步代码块的使用  }
*				**一般来说，使用代码块比使用方法要效率更高一点
*				**尽量减少代码块的内容  只在需要同步的地方使用
*/

public class Case7 {
    public void test() {
        synchronized (this) {
            try {
                System.out.println("begin time=" + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("end time=" + System.currentTimeMillis());
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Case7 service = new Case7();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service.test();
            }
        }, "线程A").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service.test();
            }
        }, "线程B").start();

//		begin time=1577351055797
//		end time=1577351057800
//		begin time=1577351057800
//		end time=1577351059801
    }
}
