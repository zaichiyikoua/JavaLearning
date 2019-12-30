package codingInterviewByJava;

//面试题25：合并两个排序的链表

//题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
//照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
//表3所示。

public class MergeSortedLists {

    // 要合并两个有序的链表 合并之后的链表也是要有序的（默认升序）
    // 思路 利用辅助链表 比较两个有序链表的节点值 小的放进辅助链表中
    // 返回是返回辅助链表的头节点
    public ListNode solution(ListNode oneHeader, ListNode twoHeader) {
        if (oneHeader == null && twoHeader == null) {
            return null;
        }
        // 这里考虑如果一边的链表为空的情况
        if (oneHeader == null) {
            return twoHeader;
        } else if (twoHeader == null) {
            return oneHeader;
        }

        // 接下来是两个链表都不为空
        // 合并后的新链表头节点
        ListNode afterMergeList = null;
        // 比较两个链表节点值
        if (oneHeader.value < twoHeader.value) {
            afterMergeList = oneHeader;
            afterMergeList.nextNode = solution(oneHeader.nextNode, twoHeader);
        } else {
            // 大于
            // 相等情况都可以 所以这里不用再else if判断
            afterMergeList = twoHeader;
            afterMergeList.nextNode = solution(oneHeader, twoHeader.nextNode);
        }

        return afterMergeList;
    }
}
