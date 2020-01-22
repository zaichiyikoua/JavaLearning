package codingInterviewByJava.chapter1;

import java.util.LinkedList;

/*
*	剑指offer面试题复习  笔记9
*	@author  zaichiyikoua
*	@time  2020年1月22日
*	@title  { 用两个栈实现队列 }
*/

public class Offer9 {
    // 这道题经常考，也很简单
    // 从栈中取出放进另外的一个栈即可实现队列的功能
    private LinkedList<Integer> stackOne = new LinkedList<Integer>();
    private LinkedList<Integer> stackTwo = new LinkedList<Integer>();

    public void add(int value) {
        if (value < 0) {
            System.out.println("请输入有效的数字");
            return;
        }
        stackOne.push(value);
    }

    public int delete() {
        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }
        return stackTwo.pop();
    }
}
