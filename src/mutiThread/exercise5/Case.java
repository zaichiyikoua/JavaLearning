package mutiThread.exercise5;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
*	多线程核心   练习题1
*	@author  zaichiyikoua
*	@time  2019年12月30日
*	@description  { Timer的使用  }	
*/

public class Case {
    // 在Java中，定时/计划任务功能主要就是靠Timer实现的，它在内部是使用多线程的方式进行处理
    // Timer的主要作用是设置计划任务，即在指定时间开始执行某个任务
    // TimerTask类的主要作用是封装任务，这是一个抽象类
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("当前时间为：" + currentTimeMillis);

        long scheduleTime = (currentTimeMillis + 10000);
        System.out.println("计划时间为：" + scheduleTime);

        MyTask task = new MyTask();
        Timer timer = new Timer();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // ***********************************************
        // schedule()的使用
        // 该方法的作用是在指定日期执行一次任务
        // ***********************************************

        // ***********************************************
        // schedule()有多个重载的形式
        // 这里如果有第三个参数，则表示的是在指定日期之后按照指定的间隔周期无限次循环地执行某一任务
        // 第三参数就是指定周期
        // ***********************************************
        timer.schedule(task, new Date(scheduleTime));

        // 2s之后线程结束
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // cancel()的使用
        // 如果不使用这个方法，TimerThread不会销毁
        timer.cancel();

//		当前时间为：1577702331982
//		计划时间为：1577702341982
//		任务执行了，时间为：1577702341983

        // 10s之后任务执行了，虽然执行了，但是进程没有销毁,这是因为Timer内部有一个TimerThread线程
    }

}

class MyTask extends TimerTask {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("任务执行了，时间为：" + System.currentTimeMillis());
    }

}