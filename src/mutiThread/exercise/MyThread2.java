package mutiThread.exercise;

/*
*	多线程核心   练习题2
*	@author  zaichiyikoua
*	@time  2019年12月14日
*	@description  {	使用多线程之	实现runnable接口	}
*/

public class MyThread2 implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("运行中！");
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
        System.out.println("运行结束！");// 输出 运行结束！ 运行中！
    }
}
