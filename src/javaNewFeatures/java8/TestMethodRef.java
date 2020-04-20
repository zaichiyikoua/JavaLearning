package javaNewFeatures.java8;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * lambda表达式方法引用
 * 
 * @author zaichiyikou
 * @since 2020-4-20
 */

public class TestMethodRef {
    /**
     * 如果lambda体中的方法已经有实现了，那么可以使用方法引用
     * 
     * (可以理解为 方法引用是lambda表达式的另外一种表现方式)
     * 
     * 主要有三种语法格式
     * 
     * 1. 对象::实例方法名
     * 
     * 2. 如果是静态的 类::静态方法名
     * 
     * 3. 类::实例方法名
     */
    /**
     * 对象::实例方法名
     */
    @SuppressWarnings("unused")
    public void test1() {
        Consumer<String> comsumer = (x) -> System.out.println(x);
        // 方法引用的方式
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("asdfasd");
    }

    /**
     * 类::静态方法名
     */
    @SuppressWarnings("unused")
    public void test2() {
        Comparator<Integer> comparator = (x, y) -> {
            return Integer.compare(x, y);
        };
        // 方法引用
        Comparator<Integer> comparator2 = Integer::compare;
    }

    /**
     * 类::实例方法名
     */
    @SuppressWarnings("unused")
    public void test3() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        // 方法引用
        BiPredicate<String, String> biPredicate2 = String::equals;
    }
}
