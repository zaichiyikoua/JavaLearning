package javaNewFeatures.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import javaNewFeatures.java8.practice.Employee;

/**
 * java8新特性学习
 * 
 * @author zaichiyikoua
 * 
 * @time 2020年4月21日
 */

public class StreamLearning {
    /**
     * 一.java8中有两大最为重要的改变
     * 
     * 1.lambda表达式 2.StreamAPI(java.util.stream.*)
     * 
     * Stream是java8中处理集合的关键抽象概念，它可以指定你希望的集合进行的操作
     * 
     * 可以执行非常复杂的查找，过了和映射数据库等操作
     * 
     * 使用streamAPI对集合数据操作，就类似与使用SQL操作数据库一样
     * 
     * 也可以使用StreamAPI来并行执行操作。
     */
    /**
     * 二.流(Stream)到底是什么？
     * 
     * 是数据渠道，用于操作数据源(集合，数组)所生成的元素序列 “集合讲的是数据结构，流讲的是计算”
     * 
     * 注意：
     * 
     * 1.Stream自己不会存储元素
     * 
     * 2.Stream不会改变源对象，会返回一个持有结果的新的Stream
     * 
     * 3.Stream操作时延迟执行的，这意味着他们会等到需要结果的时候才会执行
     */
    /**
     * 三.Stream的操作步骤
     * 
     * 1.创建一个Stream。一个数据源(比如集合、数组)，获取一个流
     * 
     * 2.中间操作。一个中间操作链，对数据源的数据进行处理
     * 
     * 3.终止操作(中段操作)。一个终止操作，执行中间操作链，并产生结果。
     */
    /**
     * 创建Stream
     */
    @SuppressWarnings("unused")
    public void StreamTest1() {
        // 1.可以通过Collection系列集合提供的Stream()(这个获取串行流)或ParallelStream()(这个获取并行流)获得
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 2.通过Arrays工具类中的静态方法获得数组流
        Employee[] array = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(array);

        // 3.通过Stream类中的静态方法来获取流，也是带泛型的
        Stream<String> stream3 = Stream.of("aa", "bb", "cc", "dd");

        // 4.创建无限流
        // 迭代 seed=起始值 后面是一个接口，可以使用lambda表达式
        // 会一直执行+2操作
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x += 2);
        iterate.limit(10).forEach(System.out::println);
        // 生成
        // 会一直生成随机数
        Stream.generate(() -> new Random().nextInt(10)).limit(10).forEach(System.out::println);
    }
}
