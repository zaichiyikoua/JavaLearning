package leetcode.part4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记40
*	@author  zaichiyikoua
*	@time  2020年2月11日
*	@title  { 二叉树的前序遍历 }
*/

//给定一个二叉树，返回它的 前序 遍历。
// 示例:
//输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//输出: [1,2,3]
public class BinaryTreePreorderTraversal {
    // 二叉树的常规遍历其实有两种，第一种肯定就是递归了，也是最简单的，在39练习中已经实现过
    // 这次用非递归的方式来实现二叉树的前序遍历
    // 后续不会再记录二叉树的后序遍历
    public List<Integer> solution(TreeNode root) {
        // 方法就是使用栈来完成，利用先进先出的特点
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        // 要输出的
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 入值检测
        if (root == null) {
            return list;
        }
        // 入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // 取出栈顶元素
            TreeNode node = stack.pop();
            list.add(node.val);
            // 这里要注意以下，树的前序遍历顺序是 根 左 右
            // 所以这里使用栈的话是先右 再左
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
