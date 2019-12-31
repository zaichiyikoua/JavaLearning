package mutiThread.exercise6;

/*
*	多线程核心   练习题6
*	@author  zaichiyikoua
*	@time  2019年12月31日
*	@description  { 静态类实现单例  }
*/

public class MyThread6 {
    // 静态代码块中的代码会在类加载的时候执行，只会加载一次
    // 所以只会有一个实例

    private static MyThread6 mythread = null;

    private MyThread6() {

    }

    static {
        mythread = new MyThread6();
    }

    public MyThread6 getInstance() {
        return mythread;
    }
}
