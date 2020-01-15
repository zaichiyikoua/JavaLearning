package codingInterviewByJava.past;

//面试题24：反转单链表

//题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
//头结点。

public class ReverseList {
    // 反转时需要考虑断链情况
    // 为了保证不断链 需要知道节点的前节点和后节点
    public ListNode solution(ListNode header) {
        if (header == null) {
            return null;
        }

        // 初始化三个节点 头节点是没有前一个节点的
        ListNode preNode = null;
        ListNode node = header;
        // 优化
        ListNode nextNode = null;
        if (node.nextNode != null && node != null) {
            nextNode = node.nextNode;
        }
        // 反转之后的链表的头节点
        ListNode ReverseListHeader = null;

        while (node != null) {
            // 进行反转 注意不要断链
            nextNode = preNode;
            // 原链表的尾节点就是新链表的头节点
            if (nextNode == null) {
                ReverseListHeader = node;
            }

            preNode = node;
            node = nextNode;
        }

        return ReverseListHeader;
    }
}
