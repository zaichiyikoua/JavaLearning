package javaBasicExercises;

/*
*	javaSE专项练习9
*	2019年12月12日
*/

public class Coding9 {

    private static int x = 100;
    // 该题在eclipse上存在部分问题
    // 中心思想就是想说static关键字 对于所有的实例来说 访问的x都是同一个x
    // 虽然有private 但是这里mian函数在本类的内部 是可以使用x的

    @SuppressWarnings("static-access")
    public static void mian() {
        // TODO Auto-generated method stub
        Coding9 co1 = new Coding9();
        co1.x++;
        Coding9 co2 = new Coding9();
        co2.x++;
        co1 = new Coding9();
        co1.x++;
        Coding9.x++;

        System.out.println("x = " + x);
    }
}
