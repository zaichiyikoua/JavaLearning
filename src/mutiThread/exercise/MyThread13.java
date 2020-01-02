package mutiThread.exercise;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题13
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	用stop()停止线程	}
*				**暴力法停止线程，是不再采用的方法  强烈建议不要使用
*/

public class MyThread13 extends Thread {
    private int count = 0;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                count++;
                System.out.println("count = " + count);
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("catch in run");
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try {
            MyThread13 thread = new MyThread13();
            thread.start();
            TimeUnit.SECONDS.sleep(6);
            // 这里就可以很明显 IDE都不建议这么做
            thread.stop();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
