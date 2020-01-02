package mutiThread.exercise;

/*
*	多线程核心   练习题7
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	i--和syso出现的非线程安全问题	}
*/

public class MyThread7 extends Thread {
    private int i = 5;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        // 注意 i--原本是单独一行执行 现在改为在syso中直接输出
        System.out.println("i = " + (i--) + ", ThreadName = " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread7 run = new MyThread7();

        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        Thread t5 = new Thread(run);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // 结果还是会出现线程安全问题，简单解决方案还是加锁
    }
}
