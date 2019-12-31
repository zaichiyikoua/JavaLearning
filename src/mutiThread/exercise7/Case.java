package mutiThread.exercise7;

/*
*	多线程核心   练习题
*	@author  zaichiyikoua
*	@time  2019年12月31日
*	@description  { 线程组 }
*/

public class Case {
    // 线程组是为了方便某些具有相同功能的线程进行管理，可以把线程归属到一个组里
    // 简单来说就是批量管理线程

    // 这种是最简单的关联--一级关联
    // 这种就是父对象中有子对象，子对象中没有孙对象
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };

        ThreadGroup group = new ThreadGroup("test");
        Thread thread = new Thread(group, runnable);
        Thread thread2 = new Thread(group, runnable2);

        thread.start();
        thread2.start();

        System.out.println("活动的线程数量为：" + group.activeCount());
        System.out.println("线程组名称为：" + group.getName());

//        ThreadName=Thread-0
//                活动的线程数量为：2
//        ThreadName=Thread-1
//                线程组名称为：test
//        ThreadName=Thread-1
    }
}
