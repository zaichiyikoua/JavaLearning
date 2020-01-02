package codingInterviewByJava;

//单例模式
//双检锁/双重校验锁

public class Singleton4 {
    // 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
    // 但是一般情况下没有必要，特殊要求下可以使用
    private volatile static Singleton4 singleton;

    private Singleton4() {
    }

    public static Singleton4 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton4.class) {
                if (singleton == null) {
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }
}
