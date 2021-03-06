package mutiThread.exercise2;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题3
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	synchronized }
*				**总结：
*						1.在某个线程持有锁的时候，另外的线程是可以调用非同步的方法的
*						(就像你上厕所的时候，单间是锁定的，但是外面可以有保洁人员进行工作)
*						2.synchronized锁定的永远永远是对象，不是代码块或者方法(最重要)
*						3.java中只有将对象作为锁这种说法，没有锁方法的这种说法
*						4.java中，锁 就是 对象，哪个线程拿到这把锁，哪个线程就可以执行该对象中的synchronized方法
*						5.只有共享资源的读写访问才需要同步，如果不是共享的，那么没有必要同步
*/

public class Case3 {
    // 一个同步
    synchronized public void methodA() {
        System.out.println("begin methodA threadName =" + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("end methodA");
    }

    // 一个不同步
    public void methodB() {
        System.out.println("begin methodB threadName =" + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("end methodB");
    }

    // A线程调用的是同步方法，B线程调用的是非同步的
    public static void main(String[] args) {
        Case3 service = new Case3();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service.methodA();
            }
        }, "线程A").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service.methodB();
            }
        }, "线程B").start();

        // 输出
//		begin methodB threadName =B
//		begin methodA threadName =A
//		end methodB
//		end methodA
    }
}
