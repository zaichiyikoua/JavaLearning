package leetcode.part15;

import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记146
*	@author  zaichiyikoua
*	@time  2020年4月6日
*	@title  { 移除重复节点lcci }
*/

//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//示例1:
//输入：[1, 2, 3, 3, 2, 1]
//输出：[1, 2, 3]
//示例2:
//输入：[1, 1, 1, 1, 2]
//输出：[1, 2]
//提示：
//链表长度在[0, 20000]范围内。
//链表元素在[0, 20000]范围内。
public class RemoveDuplicateNodelcci {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 利用hashset去重
    public ListNode removeDuplicateNodes(ListNode head) {
        // 入值检测
        if (head == null) {
            return head;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        // 指针
        ListNode currentNode = head;
        ListNode preNode = new ListNode(0);
        preNode.next = head;
        while (currentNode != null) {
            if (hashSet.add(currentNode.val)) {
                // 没有重复 移动前置指针
                preNode = currentNode;
            } else {
                // 重复了 跳一位
                preNode.next = currentNode.next;
            }
            // current指针后移
            currentNode = currentNode.next;
        }
        return head;
    }
}
