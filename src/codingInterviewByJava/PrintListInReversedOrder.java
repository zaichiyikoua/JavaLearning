package codingInterviewByJava;

import java.util.ArrayList;
import java.util.LinkedList;

//面试题6：从尾到头打印链表
//题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。

public class PrintListInReversedOrder<E> {

    // 思路 用栈来实现 栈用集合实现
    public ArrayList<Integer> solution(ListNode header) {
        if (header == null) {
            System.out.println("空指针");
        }
        // 用linkedList实现栈
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        // 要打印出来的数值
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (!(header == null)) {
            linkedList.push(header.value);
            header = header.nextNode;
        }
        // 打印出来
        while (!linkedList.isEmpty()) {
            arrayList.add(linkedList.pop());
        }
        return arrayList;
    }
}
