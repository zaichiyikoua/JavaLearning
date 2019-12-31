package mutiThread.exercise6;

/*
*	多线程核心   练习题5
*	@author  zaichiyikoua
*	@time  2019年12月31日
*	@description  { 内部类实现单例   }
*/

public class MyThread5 {
    // 使用内部类来实现
    private static class innerClass {
        private static MyThread5 mythread = new MyThread5();
    }

    private MyThread5() {

    }

    public MyThread5 getInstance() {
        return innerClass.mythread;
    }
}
