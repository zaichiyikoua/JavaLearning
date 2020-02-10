package leetcode.part4;

import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记36
*	@author  zaichiyikoua
*	@time  2020年2月10日
*	@title  { 最小栈 }
*/

//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//push(x) -- 将元素 x 推入栈中。
//pop() -- 删除栈顶的元素。
//top() -- 获取栈顶元素。
//getMin() -- 检索栈中的最小元素。
//示例:
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
public class MinStack {
    // 可以用辅助栈来实现
    private LinkedList<Integer> mainStack;
    private LinkedList<Integer> supportStack;

    /** initialize your data structure here. */

    public MinStack() {
        super();
        mainStack = new LinkedList<Integer>();
        supportStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        // 入栈时，主栈直接入栈
        mainStack.push(x);
        // 辅助栈判断入栈的值是否更小
        if (supportStack.isEmpty() || supportStack.peek() > x) {
            supportStack.push(x);
        }
    }

    public void pop() {
        // 出栈时，判断出栈值是不是在辅助栈的栈顶
        if (mainStack.peek() == supportStack.peek()) {
            supportStack.pop();
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return supportStack.peek();
    }
}
