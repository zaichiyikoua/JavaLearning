package leetcode.part15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记150
*	@author  zaichiyikoua
*	@time  2020年4月12日
*	@title  { 回文链表lcci }
*/

//编写一个函数，检查输入的链表是否是回文的。
//示例 1：
//输入： 1->2
//输出： false 
//示例 2：
//输入： 1->2->2->1
//输出： true 
public class PalindromeLinkedListlcci {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 可以考虑用栈来实现
    public boolean isPalindrome(ListNode head) {
        // 入值
        if (head == null) {
            return true;
        }
        LinkedList<Integer> stackList = new LinkedList<>();
        ListNode indexNode = head;
        while (head != null) {
            stackList.push(head.val);
            head = head.next;
        }
        // 此时栈中保存了链表的数据，并且是镜像的，判断是否为回文
        while (indexNode != null) {
            if (indexNode.val != stackList.pop()) {
                return false;
            }
            indexNode = indexNode.next;
        }
        return true;
    }
}
