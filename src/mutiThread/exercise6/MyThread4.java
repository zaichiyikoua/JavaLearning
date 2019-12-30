package mutiThread.exercise6;

/*
*	多线程核心   练习题4
*	@author  zaichiyikoua
*	@time  2019年12月30日
*	@description  { 懒汉模式的解决办法之  DCL机制  }
*/

public class MyThread4 {

    // DCL-->>指的是Double-check-Locking，双检查锁机制
    // 使用volatile禁止代码重排序(必要)，否则会发生重排序出现错误
    volatile private static MyThread4 mythread;

    private MyThread4() {

    }

    public MyThread4 getInstance() {
        try {
            if (mythread == null) {
                synchronized (MyThread4.class) {
                    if (mythread == null) {
                        mythread = new MyThread4();
                        return mythread;
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return mythread;
    }
}
