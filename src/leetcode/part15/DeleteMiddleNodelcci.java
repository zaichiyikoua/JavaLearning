package leetcode.part15;

/*
*	leetCode算法刷题记录   笔记149
*	@author  zaichiyikoua
*	@time  2020年4月8日
*	@title  { 删除中间节点lcci }
*/

//实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。
//示例：
//输入：单向链表a->b->c->d->e->f中的节点c
//结果：不返回任何数据，但该链表变为a->b->d->e->f
public class DeleteMiddleNodelcci {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 只访问当前节点不考虑首尾节点 就很简单
    public void deleteNode(ListNode node) {
        if (node != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
