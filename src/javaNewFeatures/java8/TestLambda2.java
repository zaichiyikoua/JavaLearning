package javaNewFeatures.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8内置的四大核心函数式接口
 * 
 * @author zaichiyikoua
 * @since 2020-4-20
 *
 */
/**
 * 实际上java已经内置了常用的几个接口，不用我们去自己创建
 */
public class TestLambda2 {
    /**
     * 1.Comsumer<T>：消费型接口 void accept(T t)
     */
    public void test1() {
        happy(1000, (x) -> {
            System.out.println("x" + x);
        });
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * 2.Supplier<T>：供给型接口 T get()
     */
    public void test2() {
        // 自己去指定怎样产生，产生怎样的数
        List<Integer> numList = getNumList(100, () -> {
            // 比如产生0-100的随机整数
            Random random = new Random();
            return random.nextInt(100);
        });
        for (Integer integer : numList) {
            System.out.println(integer);
        };
    }

    // 需求：产生一些整数，并放进集合中
    /**
     * 
     * @param num 产生多少个数
     *            
     * @param supplier 内置接口
     *            
     * @return
     */
    public List<Integer> getNumList(Integer num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 这里只是说明了产生一些数，然后放进了集合，但没有具体说明怎样产生
            // 也没有说明产生怎样的数
            Integer e = supplier.get();
            list.add(e);
        }
        return list;
    }
    /**
     * 3.Function<T,R>：函数型接口 R apply(T t)
     * 传进来一个参数，转出去一个
     */
    public void test3() {
        stringHandler("函数型接口测试", (str) -> {
            return str.trim();
        });
        stringHandler("再来一次", (str) -> {
            return str.toLowerCase();
        });
    }

    // 需求：处理字符串
    public String stringHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }
    /**
     * 4.Predicate<T>：断言型接口 boolean test(T t)
     */
    @SuppressWarnings("unused")
    public void test4() {
        List<String> list = Arrays.asList("lambda", "ok", "tste");
        List<String> predicateList = predicateList(list, (str) -> str.length() > 3);
    }

    // 该接口主要用于判断
    // 需求：将满足条件的字符串提取，然后添加到集合中
    public static List<String> predicateList(List<String> list, Predicate<String> predicate) {
        List<String> strList = new ArrayList<>();
        for (String string : list) {
            // 断言接口
            if (predicate.test(string)) {
                strList.add(string);
            }
        }
        return list;
    }
}
