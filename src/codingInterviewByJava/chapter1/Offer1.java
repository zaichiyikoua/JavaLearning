package codingInterviewByJava.chapter1;

/*
*	剑指offer面试题复习  笔记1
*	@author  zaichiyikoua
*	@time  2020年1月15日
*	@title  { 单例模式1 }
*/

public class Offer1 {
    // 饿汉式单例模式
    private Offer1 offer = new Offer1();

    private Offer1() {

    }

    public Offer1 getInstance() {
        return offer;
    }
}
