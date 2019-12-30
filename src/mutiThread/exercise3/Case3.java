package mutiThread.exercise3;

/*
*	多线程核心   练习题3
*	@author  zaichiyikoua
*	@time  2019年12月26日
*	@description  {	wait()和sleep()  }
*				总结：wait会立即释放锁，sleep不会立即释放锁
*/

public class Case3 {

    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        Object lock = new Object();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    synchronized (lock) {
                        System.out.println("begin wait");
                        lock.wait();
                        System.out.println("end wait");
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "线程A").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    synchronized (lock) {
                        System.out.println("begin wait");
                        lock.wait();
                        System.out.println("end wait");
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "线程B").start();

        // 输出 begin wait begin wait
        // 很显然的可以从结果看出，wait会立即释放锁

    }

    public static void main2(String[] args) {
        Object lock = new Object();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    synchronized (lock) {
                        System.out.println("begin wait");
                        Thread.sleep(1000);
                        System.out.println("end wait");
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "线程A").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    synchronized (lock) {
                        System.out.println("begin wait");
                        Thread.sleep(1000);
                        System.out.println("end wait");
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "线程B").start();
        // 输出结果：
//		begin wait
//		end wait
//		begin wait
//		end wait
        // 可以看到，如果wait换成了sleep方法，就变成了同步，说明sleep方法不会释放锁
    }

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    synchronized (lock) {
                        System.out.println("begin wait");
                        // 带参wait
                        lock.wait(5000);
                        System.out.println("end wait");
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "线程A").start();
        // 输出
//		begin wait
//		end wait
        // 中间时隔5秒
        // 可以发现，wait()是可以带参的，功能是使线程等待相应的时间，如果没有其他线程来唤醒的话，会自动唤醒
        // 并且继续往下运行的前提条件是要再次持有锁
    }
}
