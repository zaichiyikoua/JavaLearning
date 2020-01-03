package mutiThreadFramework.exercise2;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题6
*	@author  zaichiyikoua
*	@time  2020年1月3日
*	@description  { CopyOnWriteArrayList和CopyOnWriteArraySet }
*/

public class Case6 {
    // ArrayList使线程不安全的，如果要在并发条件下使用，可以使用CopyOnWriteArrayList
    // 同时，和CopyOnWriteArrayList配套使用的还有CopyOnWriteArraySet
    // CopyOnWriteArrayList可以解决并发条件下的HashSet的安全问题
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();
        Runnable runnable = new Runnable() {
            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    arrayList.add("data");
                }
            }
        };

        Thread[] arr = new Thread[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Thread(runnable);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(arrayList.size());
    }

//    100

}
