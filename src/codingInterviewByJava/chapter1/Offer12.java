package codingInterviewByJava.chapter1;

/*
*	剑指offer面试题复习  笔记12
*	@author  zaichiyikoua
*	@time  2020年1月28日
*	@title  { 二叉树的下一个节点 }
*/

//题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
//树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
public class Offer12 {
    // 中序遍历的顺序:左->根->右
    public TreeLinkednode solution(TreeLinkednode root) {
        if (root == null) {
            return null;
        }
        TreeLinkednode node = null;
        // 左 根 右
        // 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点
        if (root.right != null) {
            node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            // 为空的话，向上找寻第一个左连接指向的树包含该节点的祖先节点
            while (root.next != null) {
                TreeLinkednode parent = root.next;
                if (parent.left == root) {
                    return parent;
                }
                root = root.next;
            }
        }
        return null;
    }
}

class TreeLinkednode {
    int value;
    TreeLinkednode left = null;
    TreeLinkednode right = null;
    TreeLinkednode next = null;

    public TreeLinkednode(int value) {
        super();
        this.value = value;
    }

}