package javaBasicExercises.part4;

/*
*	javaSE专项练习37
*	@author  zaichiyikoua
*	@time  2020年1月29日
*/

public class Coding37 {

    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer i = 42;
        Long l = 42l;
        Double d = 42.0;

//        System.out.println(i == l);// A
//        System.out.println(i == d);// B
//        System.out.println(l == d);// C
        System.out.println(i.equals(d));// D
        System.out.println(d.equals(l));// E
        System.out.println(i.equals(l));// F
        System.out.println(l.equals(42L));// G

        // ABC因为不同类型引用的==来比较很明显编译都过不了
        // DEF调用了equals来比较，但是是不同类型，所有返回false
        // G会自动装箱和拆箱

        // 要注意要注意要注意
        // 包装类的“==”运算在不遇到算术运算的情况下不会自动拆箱
        // 包装类的equals()方法不处理数据转型
    }

}
