package leetcode.part7;

import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记67
*	@author  zaichiyikoua
*	@time  2020年2月18日
*	@title  { 用队列实现栈 }
*/

//使用队列实现栈的下列操作：
//push(x) -- 元素 x 入栈
//pop() -- 移除栈顶元素
//top() -- 获取栈顶元素
//empty() -- 返回栈是否为空
//注意:
//你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
//你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
//你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
public class ImplementStackUsingQueues {
    // 两个队列
    private LinkedList<Integer> queueOne;
    private LinkedList<Integer> queueTwo;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        // 初始化两个队列
        queueOne = new LinkedList<Integer>();
        queueTwo = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 入1号队
        queueOne.offer(x);
        // 将二号队列的全部元素转给1号队
        while (!queueTwo.isEmpty()) {
            queueOne.offer(queueTwo.poll());
        }
        // 再将一号队的全部转给2号队
        while (!queueOne.isEmpty()) {
            queueTwo.offer(queueOne.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 出队就是二号队出队
        return queueTwo.poll();
    }

    /** Get the top element. */
    public int top() {
        // 也是二号队
        return queueTwo.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueTwo.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */