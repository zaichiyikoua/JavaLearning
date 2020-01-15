package codingInterviewByJava.chapter1;

/*
*	剑指offer面试题复习  笔记4
*	@author  zaichiyikoua
*	@time  2020年1月15日
*	@title  { 单例模式4 }
*/

public class Offer4 {
    // 静态类单例模式
    private static Offer4 offer = null;

    private Offer4() {

    }

    static {
        offer = new Offer4();
    }

    public Offer4 getInstance() {
        return offer;
    }
}
