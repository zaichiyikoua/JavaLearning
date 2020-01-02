package mutiThread.exercise3;

/*
*	多线程核心   练习题6
*	@author  zaichiyikoua
*	@time  2019年12月28日
*	@description  {	使用wait和notify实现交叉输出  }
*/

public class Case6 {
    // 这是实现交叉输出的最重要的标志位，确定谁先打印
    volatile private static boolean FLAG = false;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 锁
        Object lock = new Object();
        // 一共十个线程，交叉打印
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    try {
                        synchronized (lock) {
                            while (FLAG == true) {
                                lock.wait();
                            }
                            System.out.println("********");
                            FLAG = true;
                            lock.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    try {
                        synchronized (lock) {
                            while (FLAG == false) {
                                lock.wait();
                            }
                            System.out.println("########");
                            FLAG = false;
                            lock.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // 输出如下：
//		********
//		########
//		********
//		########
//		********
//		########
//		********
//		########
//		********
//		########
        // 实现了交叉打印
    }

}
