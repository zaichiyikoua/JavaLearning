package javaBasicExercises.part2;

/*
*	javaSE专项练习11
*	2019年12月12日
*/

public class Coding11 {
    public synchronized static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                Sogou();
            }
        };
        thread.run();
        System.out.println("Hellow");
        // 输出Sogou Hellow
        // 还是没有启动线程 调用的run方法
        // 补充：Sogou函数用的锁是Coding11.class 两个方法用的都是同一个锁
        // synchronized还是可重入的锁
    }

    static synchronized void Sogou() {
        System.out.println("Sogou");
    }
}
