package leetcode.part2;

/*
*	leetCode算法刷题记录   笔记11
*	@author  zaichiyikoua
*	@time  2020年2月5日
*	@title  { 二进制链表转整数 }
*/

//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//请你返回该链表所表示数字的 十进制值 。
//示例 1：
//输入：head = [1,0,1]
//输出：5
//解释：二进制数 (101) 转化为十进制数 (5)
//示例 2：
//输入：head = [0]
//输出：0
//示例 3：
//输入：head = [1]
//输出：1
//示例 4：
//输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//输出：18880
//示例 5：
//输入：head = [0,0]
//输出：0
//提示：
//链表不为空。
//链表的结点总数不超过 30。
//每个结点的值不是 0 就是 1。
public class ConvertBinaryNumberInALinkedListToInteger {
    // 这道题唯一难点在于如何将二进制变成十进制，知道如何转换了就好办了
    // 遍历该单链表，将值变成十进制
    public int solution(ListNode head) {
        if (head == null) {
            return -1;
        }
        // 不要直接使用head
        ListNode currentNode = head;
        // 返回值初始化
        int result = 0;
        while (currentNode != null) {
            result = result * 2 + currentNode.val;
            currentNode = currentNode.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}