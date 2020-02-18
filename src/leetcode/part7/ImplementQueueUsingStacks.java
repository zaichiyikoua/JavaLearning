package leetcode.part7;

import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记66
*	@author  zaichiyikoua
*	@time  2020年2月18日
*	@title  { 用栈实现队列 }
*/

//使用栈实现队列的下列操作：
//push(x) -- 将一个元素放入队列的尾部。
//pop() -- 从队列首部移除元素。
//peek() -- 返回队列首部的元素。
//empty() -- 返回队列是否为空。
//示例:
//MyQueue queue = new MyQueue();
//queue.push(1);
//queue.push(2);  
//queue.peek();  // 返回 1
//queue.pop();   // 返回 1
//queue.empty(); // 返回 false
//说明:
//你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
//你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
//假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
public class ImplementQueueUsingStacks {
    // 两个栈
    private LinkedList<Integer> stackOne;
    private LinkedList<Integer> stackTwo;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        // 构造器初始化两个栈
        stackOne = new LinkedList<Integer>();
        stackTwo = new LinkedList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 放进1号栈
        stackOne.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 出栈是二号栈出栈
        if (stackTwo.isEmpty()) {
            // 如果二号栈为空，那么将一号栈的所有元素入二号栈
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }
        return stackTwo.pop();
    }

    /** Get the front element. */
    public int peek() {
        // peek也是二号栈的peek
        if (stackTwo.isEmpty()) {
            // 如果二号栈为空，那么将一号栈的所有元素入二号栈
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }
        return stackTwo.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // 要同时满足两个栈中都没有元素，才叫空
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
