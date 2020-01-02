package codingInterviewByJava;

//单例模式
//懒汉式

public class Singleton {
    // 这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。
    // 在多线程不能正常工作
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
