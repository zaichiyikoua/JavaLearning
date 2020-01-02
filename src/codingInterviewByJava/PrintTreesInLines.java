package codingInterviewByJava;

import java.util.ArrayList;
import java.util.LinkedList;

//面试题32（二）：分行从上到下打印二叉树
//题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层
//打印到一行。

public class PrintTreesInLines<E> {
    // 本质上是二叉树的层次遍历
    // 思路 利用辅助的队列来实现 不管是图还是树的广度优先 都是层级遍历
    // 每次打印节点的时候，判断是否有子节点，有的话放入队列的队尾
    // 打印的时候出队（打印队列的头部）（先进先出） 重复直到所有节点都被打印

    public ArrayList<Integer> solution(TreeNode root) {
        if (root == null) {
            System.out.println("空指针");
        }
        // 这是要打印出来的数 放入集合中
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // 使用队列来放入二叉树
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        arrayList.add(root.value);
        // 入队 这里使用offer 如果队列为空 返回false
        if (root.left != null) {
            queue.offer(root.left);
        }
        if (root.right != null) {
            queue.offer(root.right);
        }

        while (!queue.isEmpty()) {
            // 出队
            TreeNode node = queue.poll();
            // 写入进array
            arrayList.add(node.value);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return arrayList;

    }
}
