package mutiThread.exercise2;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题11
*	@author  zaichiyikoua
*	@time  2019年12月18日
*	@description  {	多线程死锁问题  }
*/

public class Case11 implements Runnable {
    private String userName;
    private Object lockOne = new Object();
    private Object lockTwo = new Object();

    public void setFlag(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        if (userName.equals("a")) {
            synchronized (lockOne) {
                try {
                    System.out.println("userName=" + userName);
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (lockTwo) {
                    System.out.println("先执行了lock1 再执行了lock2");
                }
            }
        }
        if (userName.equals("b")) {
            synchronized (lockTwo) {
                try {
                    System.out.println("userName=" + userName);
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (lockOne) {
                    System.out.println("先执行了lock2 在执行了lock1");
                }
            }

        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Case11 case1 = new Case11();
            case1.setFlag("a");

            Thread thread1 = new Thread(case1);
            thread1.start();

            TimeUnit.SECONDS.sleep(1);
            case1.setFlag("b");

            Thread thread2 = new Thread(case1);
            thread2.start();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 输出 userName=a userName=b 并且线程一直执行，没有停止
        // 这就是简单的死锁情况
        // 形象一点就是A线程占用了a资源不放，请求b资源，但此时b资源被B线程占用，并且B线程也在请求a资源
        // 两个线程持有当前资源不释放锁，都在等待另外的线程释放，这样就造成了死锁

        // java对于死锁没有提供语言上的支持，能否设计程序避免死锁取决于程序猿自己 != =!

        // 要修正死锁问题，必须全部满足一下四个条件，缺少一个都不行：
        // 1.互斥，任务中使用的资源不能共享
        // 2.至少有一个任务持有资源并且在等待另外一个被另外任务占有的资源
        // 3.资源不能被抢占，也就是说任务不会暴力获取，而是会等待获取
        // 4.必须有循环等待(当前例子是最简单的死锁情况，实际情况要比当前例子更复杂)

        // 解决办法：最推荐破坏第四个条件，改一下循环等待条件就好了，也可以破坏其他条件

    }

}
