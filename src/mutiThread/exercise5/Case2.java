package mutiThread.exercise5;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
*	多线程核心   练习题2
*	@author  zaichiyikoua
*	@time  2019年12月30日
*	@description  { 在Timer中执行多任务  }
*/

public class Case2 {
    // 也是比较简单的，实例化多个任务即可
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("当前时间为：" + currentTimeMillis);

        long scheduleTime = (currentTimeMillis + 5000);
        System.out.println("计划1时间为：" + scheduleTime);
        long scheduleTime2 = (currentTimeMillis + 5000);
        System.out.println("计划2时间为：" + scheduleTime);

        Task task = new Task();
        Task task2 = new Task();

        Timer timer = new Timer();
        timer.schedule(task, new Date(scheduleTime));
        timer.schedule(task2, new Date(scheduleTime2));
    }

}

class Task extends TimerTask {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("任务执行了，时间为：" + System.currentTimeMillis());
    }

}