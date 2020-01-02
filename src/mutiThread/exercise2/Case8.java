package mutiThread.exercise2;

/*
*	多线程核心   练习题
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	一半同步，一步异步  }
*/

public class Case8 {
    // 一个同步一个异步
    public void longTime() {
        for (int i = 0; i < 100; i++) {
            System.out.println("no synchronized ThreadName=" + Thread.currentThread().getName() + "i=" + i);

        }
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized ThreadName=" + Thread.currentThread().getName() + "i=" + i);

            }
        }
    }

    // 不在synchronized代码块中的是异步，在代码块中的是同步执行
    public static void main(String[] args) {
        Case8 service = new Case8();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service.longTime();
            }
        }, "线程A").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service.longTime();
            }
        }, "线程B").start();
        // 部分输出情况：
//		synchronized ThreadName=线程Ai=95
//		synchronized ThreadName=线程Ai=96
//		synchronized ThreadName=线程Ai=97
//		synchronized ThreadName=线程Ai=98
//		synchronized ThreadName=线程Ai=99
//		no synchronized ThreadName=线程Bi=1
//		no synchronized ThreadName=线程Bi=2
//		no synchronized ThreadName=线程Bi=3
//		no synchronized ThreadName=线程Bi=4
//		no synchronized ThreadName=线程Bi=5
//		no synchronized ThreadName=线程Bi=6
    }
}
