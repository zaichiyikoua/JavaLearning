package mutiThread.exercise3;

/*
*	多线程核心   练习题11
*	@author  zaichiyikoua
*	@time  2019年12月28日
*	@description  {	ThreadLocal的使用之	get()与null	}
*/

public class Case11 {
    private static ThreadLocal<Object> LOCAL = new ThreadLocal<Object>();
    // ThreadLocal的主要作用是将数据放入当前线程的map中，这个map是Thread类中的实例变量
    // ThreadLocal类自己是不会去管理，存储任何的数据，只是数据和map之间的桥梁(中间层??)
    // 执行之后，每个线程中的map存有自己的数据，线程之间互不影响，只对当前线程可见

    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    // 特别需要注意的是，因为map中的key是不可以重复的，所以一个ThreadLocal只会存一个数据
    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if (LOCAL.get() == null) {
            System.out.println("LOACL中目前还没有值");
            LOCAL.set("新设定的值");
        }
        System.out.println(LOCAL.get());
        System.out.println();

        // 输出如下：
//		LOACL中目前还没有值
//		新设定的值

        // 第一次调用LOCAL的时候，调用get()会返回null
    }

}
