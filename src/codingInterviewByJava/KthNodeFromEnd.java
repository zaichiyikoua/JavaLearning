package codingInterviewByJava;

//面试题22：链表中倒数第k个结点

//题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
//本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
//从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
//值为4的结点。

public class KthNodeFromEnd {
    // 思路
    // 使用快慢指针 让两个指针保持一定距离
    // 当快指针到达链尾时，慢指针指向的就是倒数第k个节点
    public int solution(ListNode header, int k) {
        if (header == null || k < 0) {
            return -1;
        }

        // 初始时。快慢指针都指向头节点
        ListNode quickIndex = header;
        ListNode slowIndex = header;

        // 先让快指针多走k-1步。 因为是从1开始计数 保持距离
        for (int i = 0; i < k - 1; i++) {
            // 优化
            if (quickIndex.nextNode != null) {
                quickIndex = quickIndex.nextNode;
            }
        }

        // 然后同时移动 直到到达链尾
        // 快指针先到链尾
        while (quickIndex.nextNode != null) {
            quickIndex = quickIndex.nextNode;
            slowIndex = slowIndex.nextNode;
        }

        // 此时 慢指针的值就是倒数第k个值
        return slowIndex.value;
    }
}
