package codingInterviewByJava.chapter1;

/*
*	剑指offer面试题复习  笔记2
*	@author  zaichiyikoua
*	@time  2020年1月15日
*	@title  { 单例模式2 }
*/

public class Offer2 {
    // 懒汉式单例模式
    private Offer2 offer = null;

    private Offer2() {

    }

    public Offer2 getInstance() {
        if (offer == null) {
            offer = new Offer2();
            return offer;
        }
        return offer;
    }
}
