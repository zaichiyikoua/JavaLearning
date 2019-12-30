package interview;

/*
*	javaSE专项练习19
*	2019年12月13日
*/

public class Coding19 {
    public static void main(String[] args) {
        try {
            int i = 100 / 0;
            System.out.println(i);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(1);
            throw new RuntimeException();
        } finally {
            // TODO: handle finally clause
            System.out.println(2);
        }
        System.out.println(3);
    }
    // 输出1 2 然后抛出异常
    // 要注意在catch中又抛出了异常
    // 所以不会执行System.out.println(3)
}
