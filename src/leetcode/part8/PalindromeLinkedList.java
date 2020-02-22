package leetcode.part8;

import java.util.ArrayList;

/*
*	leetCode算法刷题记录   笔记78
*	@author  zaichiyikoua
*	@time  2020年2月22日
*	@title  { 回文链表 }
*/

//请判断一个链表是否为回文链表。
//示例 1:
//输入: 1->2
//输出: false
//示例 2:
//输入: 1->2->2->1
//输出: true
public class PalindromeLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 比较取巧的方法，遍历链表，记录节点的值，然后再判断是否为回文
    public boolean solution(ListNode head) {
        if (head == null) {
            return true;
        }
        // 准备一个数组
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 遍历链表的指针
        ListNode indexNode = head;
        while (indexNode != null) {
            list.add(indexNode.val);
            indexNode = indexNode.next;
        }
        // 然后回文经典的对撞指针
        int headIndex = 0;
        int tailIndex = list.size() - 1;
        while (headIndex < tailIndex) {
            // 这里用 == 比较的话会不通过，换成equals就好了
            if (!list.get(headIndex).equals(list.get(tailIndex))) {
                return false;
            }
            headIndex++;
            tailIndex--;
        }
        return true;
    }
}
