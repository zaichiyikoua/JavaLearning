package javaNewFeatures.java8;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

/*
 * lambda表达式的学习
 * 2020-4-18
 */

public class TestLambda {

    // 1.先看个例子
    @SuppressWarnings("unused")
    public static void main1(String[] args) {
        /*
         * 原来的匿名内部类这样写
         */
        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> set = new TreeSet<>(comparator);
        /*
         * 我们可以看到 真正有用的，我们想要的也就Integer.compare(01, 02);这样一行 其他的都可以是多余的
         * 那么下面就是使用lambda表达式的写法 我们可以看到 大大减少了代码量
         */
        Comparator<Integer> comparator2 = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> set2 = new TreeSet<>(comparator2);
    }

    // 2.lambda表达式的基础语法
    /*
     * java8中加入一个新的操作符 -> 这就是箭头操作符，或者叫做lambda操作符 它将lambda表达式拆分成左右两部分，可以理解为java的一个语法糖
     * 左侧部分就是表达式的参数列表 右侧是需要执行的功能，即lambda体 总结：“左右遇一，括号省略。左侧推断，类型省略”
     * 在以上情况的基础上，lambda会出现多种语法格式
     */
    @SuppressWarnings("unused")
    public static void main2(String[] args) {
        /*
         * 语法格式一：无参数，无返回值 () -> syso;
         */
        int num = 0; // java8之前如果引用了 必须是final
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(">>>>>>" + num);
            }
        };
        runnable.run();

        System.out.println("************************");

        Runnable runnable2 = () -> System.out.println(">>>>>");
        runnable2.run();

        /*
         * 语法格式二：有一个参数，无返回值
         */
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("testLambda");
        /*
         * 语法格式三：如果只有一个参数，小括号可以省略不写(但是一般习惯还是写上)
         */
        Consumer<String> consumer2 = x -> System.out.println(x);
        consumer.accept("testLambda2");

        /*
         * 语法格式四：有两个以上的参数，有返回值，并且lambda体中有多条语句(如果有多条语句，必须要使用大括号)
         */
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        /*
         * 语法格式五：lambda参数列表的数据类型可以省略不写，因为JVM会通过上下文推断出数据类型，即为“类型推断”
         */
        Comparator<Integer> comparator2 = (Integer x, Integer y) -> Integer.compare(x, y);
        /*
         * 语法格式六：若lambda体中只有一条语句，则return和大括号都可以省略
         */
        Comparator<Integer> comparator3 = (x, y) -> Integer.compare(x, y);
    }
    
    // 3.lambda表达式需要函数式接口的支持
    /*
     * 函数式接口：如果接口中只有一个抽象方法时，那么这个接口就是函数式接口。可是使用注解@FunctionalInterface修饰
     * 修饰之后可以检查是不是函数式接口
     */
    
    // 4.实际例子看看lambda的实现
    // 实际需求：对一个数进行计算
    // 函数式接口
    public Integer operation(Integer number,MyFunction myfunction) {
        return myfunction.getValue(number);
    }
    public void doOperation() {
        // lambda表达式  这样可以指定计算的方式
        Integer resultInteger = operation(100, (x) -> x*x);
        System.out.println(resultInteger);
        Integer ressultInteger2 = operation(100, (x) -> x+200);
    }
}
