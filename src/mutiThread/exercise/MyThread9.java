package mutiThread.exercise;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题9
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	停止线程之 停不下来的线程  }
*/

public class MyThread9 extends Thread {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        for (int i = 0; i < 50000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }

    public static void main(String[] args) {
        MyThread9 thread = new MyThread9();
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        thread.interrupt();
        System.out.println("****************");

        // 要注意 单独调用interrupt()仅仅是在当前线程中设定了标志，并不会真正的停止线程
    }
}
