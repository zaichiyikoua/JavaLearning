package mutiThread.exercise;

/*
*	多线程核心   练习题4
*	@author  zaichiyikoua
*	@time  2019年12月14日
*	@description  {	执行start()的顺序不代表执行run()的顺序	}
*				**也就是说先启动线程并不代表会先执行该线程中的任务**
*/

public class MyThread4 extends Thread {
    private int i;

    public MyThread4(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(i);
    }

    public static void main(String[] args) {
        MyThread4 thread1 = new MyThread4(1);
        MyThread4 thread2 = new MyThread4(2);
        MyThread4 thread3 = new MyThread4(3);
        MyThread4 thread4 = new MyThread4(4);
        MyThread4 thread5 = new MyThread4(5);
        MyThread4 thread6 = new MyThread4(6);
        MyThread4 thread7 = new MyThread4(7);
        MyThread4 thread8 = new MyThread4(8);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();

        // 结果显示 每次启动显示都不太一样
    }
}
