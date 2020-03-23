package leetcode.part14;

/*
*	leetCode算法刷题记录   笔记134
*	@author  zaichiyikoua
*	@time  2020年3月23日
*	@title  { 链表的中间节点 }
*/

//给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
//如果有两个中间结点，则返回第二个中间结点。
//示例 1：
//输入：[1,2,3,4,5]
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
//示例 2：
//输入：[1,2,3,4,5,6]
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
//提示：
//给定链表的结点数介于 1 和 100 之间。
public class IntermediateNodeOfLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 这道题比较简单，所以不去想太多，将链表转成数组来操作
    public ListNode middleNode(ListNode head) {
        // 因为链表的节点数在(1.100)
        ListNode[] result = new ListNode[100];
        if (head == null) {
            return result[0];
        }
        // 将链表转成数组
        int index = 0;
        while (head != null) {
            result[index++] = head;
            // 移动
            head = head.next;
        }
        // 返回中间 这里注意下不能是result.length() 实际的数量是index
        return result[index / 2];
    }
}
