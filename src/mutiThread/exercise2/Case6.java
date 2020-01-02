package mutiThread.exercise2;

/*
*	多线程核心   练习题6
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	出现异常的时候，会释放锁  }
*/

public class Case6 {
    synchronized public void solution() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName =" + Thread.currentThread().getName());
            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + " run exceptionTime="
                            + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("ThreadB run Time=" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        try {
            Case6 service = new Case6();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    service.solution();
                }
            }, "a").start();
            new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    service.solution();
                }
            }, "b").start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 输出
//		ThreadName =a
//		ThreadName=a run exceptionTime=1576484100231
//		Exception in thread "a" ThreadB run Time=1576484100232

        // 可以看到a中出现了异常，并且b正常输出
        // 如果发生异常不释放锁的话b永远也不会输出，所以发生异常会释放锁
    }
}
