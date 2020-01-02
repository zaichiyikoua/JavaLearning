package mutiThread.exercise;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题15
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	暂停线程之  使用suspend()和resume()方法	 }
*				**总结：使用这两个方法的确使线程暂停，并且可以恢复(stop方法会销毁线程对象，要重新运行要start)
*						但是，也看到了，IDE都不建议你使用，说明都是过期了作废的方法
*/

public class MyThread15 extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            count++;
        }
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try {
            MyThread15 thread = new MyThread15();
            thread.start();
            TimeUnit.SECONDS.sleep(2);
            // 第一段
            thread.suspend();
            System.out.println("A=" + thread.count);
            TimeUnit.SECONDS.sleep(2);
            // 第二段
            thread.resume();
            TimeUnit.SECONDS.sleep(2);
            // 第三段
            thread.suspend();
            System.out.println("B=" + thread.count);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
