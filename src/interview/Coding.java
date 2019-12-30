package interview;

/*
*	javaSE专项练习1
*	2019年12月11日
*/

public class Coding {
    private static final String MESSAGE = "taobao";

    public static void main(String[] args) {
        String a = "tao" + "bao";
        String b = "tao";
        String c = "bao";

        System.out.println(a == MESSAGE);// true
        System.out.println((b + c) == MESSAGE);// false

        /*
         * a会变成“taobao” 同一份字符串常量在内存中只占一份，因此a和MESSAGE是同一地址 b+c显然不会 是new的一个新的对象 所以为false
         */
    }

}
