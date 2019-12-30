package codingInterviewByJava;

//单例模式
//懒汉式，但是线程安全

public class Singleton2 {
    // 能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
    // 优点：第一次调用才初始化，避免内存浪费。
    // 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
