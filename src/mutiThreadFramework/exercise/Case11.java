package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程API和框架   练习题11
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { Semaphore实现生产者/消费者模式 }
*/

public class Case11 {
    // 用semaphore来控制并发的线程数量，用reentrantLock来控制同步
    // 这样比单纯的用reentrantLock来实现生产者/消费者模式要复杂一点

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Service service = new Service();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.set();
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                service.get();
            }
        };
        // 生产者组
        Thread[] threadOne = new Thread[10];
        // 消费者组
        Thread[] threadTwo = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threadOne[i] = new Thread(runnable);
            threadTwo[i] = new Thread(runnable2);
        }

        for (int i = 0; i < 10; i++) {
            threadOne[i].start();
            threadTwo[i].start();
        }
    }

}

//服务类
class Service {
    // 生产者,允许最大并发量为10
    volatile private Semaphore setSemaphore = new Semaphore(10);
    // 消费者,允许最大并发量为10
    volatile private Semaphore getSemaphore = new Semaphore(10);
    // 锁
    volatile private ReentrantLock lock = new ReentrantLock();
    volatile private Condition setCondition = lock.newCondition();
    volatile private Condition getCondition = lock.newCondition();
    // 最多只能存放四个生产者生产的作品
    volatile private Object[] produce = new Object[4];

    public boolean isEmpty() {
        boolean isEmpty = false;
        for (int i = 0; i < produce.length; i++) {
            // 检测produce是否为空
            if (produce[i] != null) {
                isEmpty = true;
                break;
            }
        }
        return isEmpty;
    }

    public boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < produce.length; i++) {
            // 检测produce是否已经满了
            if (produce[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    // 生产
    public void set() {
        try {
            // 首先进行线程的数量控制
            setSemaphore.acquire();
            // 锁定
            lock.lock();
            // 因为是生产者，所以只要不是满的，就会一直进行生产
            while (isFull()) {
                setCondition.await();
            }
            // 生产中，只要有空的，就进行生产
            for (int i = 0; i < produce.length; i++) {
                if (produce[i] == null) {
                    // 简单模拟生产过程
                    produce[i] = "data";
                    System.out.println(Thread.currentThread().getName() + "生产了" + produce[i]);
                    break;
                }
            }
            // 生产完成，唤醒消费者
            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            setSemaphore.release();
        }
    }

    // 消费
    public void get() {
        try {
            getSemaphore.acquire();
            lock.lock();
            while (isEmpty()) {
                getCondition.await();
            }
            // 消费过程
            for (int i = 0; i < produce.length; i++) {
                if (produce[i] != null) {
                    System.out.println(Thread.currentThread().getName() + "消费了" + produce[i]);
                    produce[i] = null;
                    break;
                }
            }
            // 消费干净了，唤醒生产者
            setCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            getSemaphore.release();
        }
    }
}