package javaBasicExercises.part5;

/*
*	javaSE专项练习41
*	@author  zaichiyikoua
*	@time  2020年1月30日
*/

public class Coding41 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer a = 1;
        Integer b = 1;
        Integer c = 500;
        Integer d = 500;
        System.out.print(a == b);// true
        System.out.print(c == d);// false

        // 这是为什么呢?

//      一、包装类和基本数据类型在进行“==”比较时，包装类会自动拆箱成基本数据类型，integer(0)会自动拆箱，结果为true
//      二、两个integer在进行“==”比较时，如果值在-128和127之间，结果为true，否则为false
//      三、两个包装类在进行“equals”比较时，首先会用equals方法判断其类型，如果类型相同，再继续比较值，如果值也相同，则结果为true
//      四、基本数据类型如果调用“equals”方法，但是其参数是基本类型，此时此刻，会自动装箱为包装类型
    }

}
