package leetcode.part1;

/*
*	leetCode算法刷题记录   笔记2
*	@author  zaichiyikoua
*	@time  2020年1月13日
*	@title  { 两数相加 }
*/

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//示例：
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807

public class AddTwoNumbers {

    // 思路，就是遍历两个链表，将两个链表的值进行相加，生成第三个链表节点
    public ListNode solution(ListNode l1, ListNode l2) {
        // 要返回的链表
        ListNode returnNode = new ListNode(0);
        // 游标指针
        ListNode cursor = returnNode;
        // 两个个位数相加会有进位出现，要处理进位的问题
        int sum = 0;
        // 这里最好不要动原参数
        ListNode p1 = l1;
        ListNode p2 = l2;
        // 遍历两个链表，注意下判断条件
        while (p1 != null || p2 != null) {
            // 获得节点的值，然后移动到下一个节点
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            // 生成返回链表的节点
            cursor.next = new ListNode(sum % 10);
            // 处理进位的问题，然后移动游标
            sum /= 10;
            cursor = cursor.next;
            // 要注意循环结束时，可能还会有进位的问题
            if (sum > 0) {
                cursor.next = new ListNode(sum);
            }
        }
        return returnNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}