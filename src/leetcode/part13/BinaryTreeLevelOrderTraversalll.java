package leetcode.part13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记129
*	@author  zaichiyikoua
*	@time  2020年3月6日
*	@title  { 二叉树的层次遍历ll }
*/

//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其自底向上的层次遍历为：
//[
//  [15,7],
//  [9,20],
//  [3]
//]
public class BinaryTreeLevelOrderTraversalll {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 层次遍历的变种
    public List<List<Integer>> solution(TreeNode root) {
        // 自底向上的 res当作stack
        LinkedList<List<Integer>> resList = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        // 层级遍历的queue
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode tempNode;
        // BFS标准模板(也是层级遍历的模板)
        while (!queue.isEmpty()) {
            size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                tempNode = queue.poll();
                tempList.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
            resList.push(tempList);
        }
        return resList;
    }
}
