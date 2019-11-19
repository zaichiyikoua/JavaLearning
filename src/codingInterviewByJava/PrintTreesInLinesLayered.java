package codingInterviewByJava;

import java.util.LinkedList;

//面试题32（二）：分行从上到下打印二叉树
//题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层
//打印到一行。

public class PrintTreesInLinesLayered {

	public void solution(TreeNode root) {
		// 本题是分层打印二叉树的拓展
		// 要求分行打印 思路 需要新增两个变量
		// 一个是本层需要打印的节点数 一个是下一层需要打印的节点数
		if (root == null) {
			System.out.println("空指针");
		}
		// 使用队列来放入二叉树
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		// 初始化时 本层只有根节点 所以数量为1
		int thislayerNode = 1;
		int nextlayerNode = 0;

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
			System.out.println("/d" + node.value);

			if (node.left != null) {
				queue.offer(node.left);
				++nextlayerNode;
			}
			if (node.right != null) {
				queue.offer(node.right);
				++nextlayerNode;
			}
			// 循环一次 本层要打印的数量减少
			--thislayerNode;
			if (thislayerNode == 0) {
				// 本层打印完成 换行
				System.out.println("/n");
				// 获得下一层的要打印的节点数 然后重置下一层的节点数
				thislayerNode = nextlayerNode;
				nextlayerNode = 0;
			}
		}

	}
}
