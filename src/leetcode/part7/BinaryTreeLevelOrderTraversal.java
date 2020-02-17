package leetcode.part7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记63
*	@author  zaichiyikoua
*	@time  2020年2月17日
*	@title  { 二叉树的层次遍历 }
*/

//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//例如:
//给定二叉树: [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
//[
//  [3],
//  [9,20],
//  [15,7]
//]
public class BinaryTreeLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 迭代
    public List<List<Integer>> solution(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        // 要返回的list
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        // 迭代用的队列
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        // BFS
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每一层的节点个数，全部遍历完之后才进入下一层
            int count = queue.size();
            // 每层的val值，是一个list
            ArrayList<Integer> currentValList = new ArrayList<Integer>();
            while (count > 0) {
                TreeNode currentNode = queue.poll();
                currentValList.add(currentNode.val);
                // 题中是先左后右
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                count--;
            }
            resultList.add(currentValList);
        }
        return resultList;
    }
}
