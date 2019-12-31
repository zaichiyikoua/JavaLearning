package mutiThreadInterview;

//leetcode  按序打印
/*我们提供了一个类：

public class Foo {
  public void one() { print("one"); }
  public void two() { print("two"); }
  public void three() { print("three"); }
}
三个不同的线程将会共用一个 Foo 实例。

线程 A 将会调用 one() 方法
线程 B 将会调用 two() 方法
线程 C 将会调用 three() 方法
请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
*/

//思路，设定条件，先执行的线程开启满足条件，否则不会执行

public class PrintInOrder {
    // 锁
    private Object lock;
    // 为了确保能按顺序打印，使用标志
    private boolean firstFlag;
    private boolean secondFlag;

    // 构造器
    public PrintInOrder() {
        this.lock = new Object();
        this.firstFlag = false;
        this.secondFlag = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            // 打印操作
            printFirst.run();
            // 然后让设定标志
            firstFlag = true;
            // 唤醒其他线程
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!firstFlag) {
                lock.wait();
            }
            printSecond.run();
            secondFlag = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!secondFlag) {
                lock.wait();
            }
            printThird.run();
        }
    }
}
