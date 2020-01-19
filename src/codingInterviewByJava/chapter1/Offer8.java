package codingInterviewByJava.chapter1;

import java.util.ArrayList;
import java.util.LinkedList;

import codingInterviewByJava.publicClass.ListNode;

/*
*	剑指offer面试题复习  笔记8
*	@author  zaichiyikoua
*	@time  2020年1月19日
*	@title  { 从尾到头打印链表 }
*/

//面试题6：从尾到头打印链表
//题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
public class Offer8 {
    // 像这种的要求，可以使用栈来完成，简单高效
    public void solution(ListNode node) {
        if (node == null) {
            return;
        }
        LinkedList<ListNode> list = new LinkedList<ListNode>();
        // 游标指针
        ListNode currentNode = node;

        // 遍历链表，将节点放进栈中
        while (currentNode != null) {
            list.push(currentNode);
            currentNode = currentNode.next;
        }
        // 输出每个节点的值
        while (!list.isEmpty()) {
            ListNode pop = list.pop();
            System.out.println(pop.value);
        }
    }

    // 这是以前做的 思路还是一样的 用栈来实现 区别就是打印值的方式不同
    public ArrayList<Integer> solution2(ListNode header) {
        if (header == null) {
            System.out.println("空指针");
        }
        // 用linkedList实现栈
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        // 要打印出来的数值
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (!(header == null)) {
            linkedList.push(header.value);
            header = header.next;
        }
        // 打印出来
        while (!linkedList.isEmpty()) {
            arrayList.add(linkedList.pop());
        }
        return arrayList;
    }
}
