package mutiThread.exercise6;

/*
*	多线程核心   练习题
*	@author  zaichiyikoua
*	@time  2019年12月30日
*	@description  { 立即加载/饿汉模式  }
*/

public class MyThread {
    // 立即加载是指使用类的时候已经将对象创建完成，常见的实现方式是new实例化
    // 这种就是最最基础的饿汉模式，但是存在缺点：不能有其他的实例变量，因为getInstance()没有同步
    // 所以可能出现非线程安全问题

    private static MyThread mythread = new MyThread();

    private MyThread() {

    }

    public static MyThread getInstance() {
        return mythread;
    }

    // 验证
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        MyThread myThread4 = new MyThread();

        System.out.println(myThread2.getInstance().hashCode());
        System.out.println(myThread3.getInstance().hashCode());
        System.out.println(myThread4.getInstance().hashCode());

        // 同一个对象，hashcode是相同的
//		366712642
//		366712642
//		366712642
    }

}
