package codingInterviewByJava.past;

//单例模式
//饿汉式

public class Singleton3 {
    // 这种方式比较常用，一般情况下用这种，但容易产生垃圾对象
    // 优点：没有加锁，执行效率会提高。
    // 缺点：类加载时就初始化，浪费内存。
    // 它基于 classloader 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化
    // 虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法
    private static Singleton3 instance = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}
