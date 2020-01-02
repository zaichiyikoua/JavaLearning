package mutiThread.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题9
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	不同步导致的逻辑错误及解决办法  }
*				**基本上只要对象在项目中是实例，是单例的，要共享，就要考虑并发情况
*/

public class Case9 {
    public Myutil addServiceMethod(Myutil myutil, String data) {
        try {
            // synchronized锁可以是任意对象
            synchronized (myutil) {
                if (myutil.getSize() < 1) {
                    // 模拟数据获取
                    TimeUnit.SECONDS.sleep(2);
                    myutil.addItem(data);
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return myutil;
    }

    public static void main(String[] args) {
        Myutil myutil = new Myutil();
        Case9 service = new Case9();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service.addServiceMethod(myutil, "BBBB");
            }
        }, "线程A").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service.addServiceMethod(myutil, "AAAA");
            }
        }, "线程B").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("listSize =" + myutil.getSize());// listSize =2 加上之后变成listSize =1
        // 出现错误的原因是因为两个线程没有以同步的方式返回size()大小
        // 解决就是加上synchronized
//		try {										synchronized(MyUtil){
//		if (list.getSize() < 1) {						if (list.getSize() < 1)..........
//			// 模拟数据获取				  ==>>
//			TimeUnit.SECONDS.sleep(2);
//			list.addItem(data);
//		}
    }
}

class Myutil {
    // 工具类
    private List<String> list = new ArrayList<String>();

    synchronized public void addItem(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }
}
