package javaNewFeatures.java8.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
*	lambda表达式练习题记录
*	@author  zaichiyikoua
*	@time  2020年4月19日
*/

public class LambdaPractice {
    /**
     * 实体类集合
     */
    static List<Employee> list = Arrays.asList(
        new Employee(100, "张三", 18, 1000),
        new Employee(101, "李四", 19, 1001),
        new Employee(102, "王二", 20, 1002),
        new Employee(103, "麻子", 21, 1003)    
        );    
    
    /**
     * 1.调用collections.sort方法，通过定制排序来比较两个实体类 先按照年龄比较，年龄相同再按照姓名比较 使用lambda表达式作为参数传递
     */
    public static void practice1() {
        // sort重载方法第二个参数是一个compare接口
        Collections.sort(list, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    
    /**
     * 2.1 声明一个函数式接口，接口中声明抽象方法，String getValue(String str)
     * 2.2 声明类TestLambda，类中编写方法使用接口作为参数，将字符串转换为大写并返回
     * 2.3 截取字符串内2-4的子串
     */
    public static String convertStringToUpperCase(String str,FuncInterface funcInterface) {
        return funcInterface.getValue(str);
    }
    public static void practice2() {
        // 在调用时 使用lambda表达式进行操作 指定字符串，并且指定操作
        convertStringToUpperCase("你好啊lambda", (str) -> {
            return str.toUpperCase();
        });
        convertStringToUpperCase("你好啊lambda2", (str) -> {
            return str.substring(2, 4);
        });
    }
}
