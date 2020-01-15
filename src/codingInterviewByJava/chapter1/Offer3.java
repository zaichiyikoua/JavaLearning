package codingInterviewByJava.chapter1;

/*
*	剑指offer面试题复习  笔记3
*	@author  zaichiyikoua
*	@time  2020年1月15日
*	@title  { 单例模式3 }
*/

public class Offer3 {
    // DCL单例模式
    private Offer3 offer = null;

    private Offer3() {

    }

    public Offer3 getInstance() {
        if (offer == null) {
            synchronized (Offer3.class) {
                if (offer == null) {
                    offer = new Offer3();
                    return offer;
                }
            }
        }
        return offer;
    }
}
