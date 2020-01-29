package codingInterviewByJava.chapter2;

import codingInterviewByJava.publicClass.ListNode;

/*
*	剑指offer面试题复习  笔记2
*	@author  zaichiyikoua
*	@time  2020年1月29日
*	@title  { 删除链表的节点 }
*/

//题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
public class Offer2 {
    // 如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点
    // 然后令该节点指向下下个节点，再删除下一个节点，时间复杂度为 O(1)。
    // 否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向 null，时间复杂度为 O(N)。
    // 如果进行 N 次操作，那么大约需要操作节点的次数为 N-1+N=2N-1
    // 其中 N-1 表示 N-1 个不是尾节点的每个节点以 O(1)的时间复杂度操作节点的总次数
    // N 表示 1 个尾节点以 O(N) 的时间复杂度操作节点的总次数。(2N-1)/N ~ 2，因此该算法的平均时间复杂度为 O(1)。
    public void solution(ListNode head, ListNode toBeDeleteNode) {
        if (head == null || toBeDeleteNode == null) {
            return;
        }
        // 要删除的节点不是尾节点
        if (toBeDeleteNode.next != null) {
            // 将下一节点的值赋给该节点,然后移动节点
            toBeDeleteNode.value = toBeDeleteNode.next.value;
            toBeDeleteNode = toBeDeleteNode.next;
            // 删除
            toBeDeleteNode.next = null;
        } else if (head == toBeDeleteNode) {
            // 如果只有一个节点，头节点也就是要删除的节点
            head = null;
            toBeDeleteNode = null;
        } else {
            // 如果运气不好是尾节点，那么只能遍历整个链表
            ListNode currentNode = head;
            // 遍历
            while (currentNode.next != toBeDeleteNode) {
                currentNode = currentNode.next;
            }
            // 直到找到要删除的节点，然后删除
            currentNode.next = null;
        }
    }
}
