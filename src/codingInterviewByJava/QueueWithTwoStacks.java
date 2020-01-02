package codingInterviewByJava;

import java.util.LinkedList;

//面试题9：用两个栈实现队列
//题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
//和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。

public class QueueWithTwoStacks {
    private LinkedList<Integer> stackOne = new LinkedList<Integer>();
    private LinkedList<Integer> stackTwo = new LinkedList<Integer>();

    // 入队很简单，直接放进栈1中
    public void appendTail(int number) {
        stackOne.push(number);
    }

    public Integer deleteHead() {
        if (stackOne.isEmpty() && stackTwo.isEmpty()) {
            return null;
        }
        // 只要栈1不为空，则将栈1元素弹出，放进栈2
        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }
        // 出队就是从栈2中弹出
        return stackTwo.pop();
    }
}
