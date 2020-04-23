package javaNewFeatures.java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * StreamAPI练习题记录
 * 
 * @author zaichiyikoua
 * 
 * @time 2020年4月23日
 */

@SuppressWarnings("unused")
public class StreamPractice {

    /*
     * 1.给定一个数字列表，如何返回一个由每个数字的平方构成的列表呢？
     * 列表：{1，2，3，4，5} 应当返回{1，4，9，16，25}
     */

    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> collect = list.stream().map(Math::sqrt).collect(Collectors.toList());
    }

    /*
     * 2.怎样用map和reduce方法数一数流中有多少个Employee呢？
     */
    List<Employee> list = Arrays.asList(new Employee(100, "张三", 18, 1000), new Employee(101, "李四", 19, 1001),
        new Employee(102, "王二", 20, 1002), new Employee(103, "麻子", 21, 1003));

    public void test2() {
        // 更简单的一种
        long count = list.stream().count();
        // map-reduce
        Optional<Integer> reduce = list.stream().map((e) -> 1).reduce(Integer::sum);
        Integer integer = reduce.get();
    }
}
