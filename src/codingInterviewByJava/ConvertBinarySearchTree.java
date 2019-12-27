package codingInterviewByJava;

import java.util.List;

//面试题36：二叉搜索树与双向链表
//题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
//要求不能创建任何新的结点，只能调整树中结点指针的指向。
//		10
//	6		14		====>>  4	6	8	10	12	14	16
//4	  8	  12  16

//*******************************************************************
//该题暂时未完成


public class ConvertBinarySearchTree {
	// 可以中序遍历二叉树 因为特点是从小到大遍历每个节点
	// 遍历顺序 左 根 右
	@SuppressWarnings("rawtypes")
	public List solution(TreeNode binaryTree) {

		return null;
	}
	
	// 转换方法
	public TreeNode convert(TreeNode binaryTree) {
		if (binaryTree == null) {
			return null;
		}
		if (binaryTree.left == null && binaryTree.right == null) {
			return binaryTree;
		}

		TreeNode node = null;
		// 中序
		TreeNode left = convert(binaryTree.left);
		node = left;

		if (node == null) {

		}

		return null;
	}
}
