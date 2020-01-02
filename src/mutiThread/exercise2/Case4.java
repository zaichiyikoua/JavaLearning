package mutiThread.exercise2;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题4
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	脏读  }
*/

public class Case4 {
    private String userName = "A";
    private String password = "AA";

    synchronized public void getValue() {
        System.out.println("getValue Method   ThreadName=" + Thread.currentThread().getName() + " userName =" + userName
                + " password =" + password);
    }

    synchronized public void setValue(String userName, String password) {
        try {
            this.userName = userName;
            // 模拟实际情况
            TimeUnit.SECONDS.sleep(5);
            this.password = password;
            System.out.println("setValue Method   ThreadName=" + Thread.currentThread().getName() + " userName ="
                    + userName + " password =" + password);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // 首先什么是脏读
    // 在数据库中就是某个事务改了数据但还没提交，另外的事务去读，然后第一个事务因为某些原因回滚了，别的事务读取的数据就是有误的
    // 在java中发生的主要原因是在读取实例变量的时候，该值被别的线程改了
    // 解决方案就是读写都加锁,如果只加写的锁，那么读是非同步的，就会出现脏读现象
    public static void main(String[] args) {
        try {
            Case4 service = new Case4();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    service.setValue("B", "BB");
                }
            }, "线程A").start();
            TimeUnit.SECONDS.sleep(2);
            service.getValue();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 输出
//		getValue Method   ThreadName=main userName =B password =AA
//		setValue Method   ThreadName=ThreadA userName =B password =BB

        // 加上之后
//		setValue Method   ThreadName=ThreadA userName =B password =BB
//		getValue Method   ThreadName=main userName =B password =BB
    }
}
