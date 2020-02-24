package leetcode.part9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记89
*	@author  zaichiyikoua
*	@time  2020年2月24日
*	@title  { 二叉树的最近公共祖先 }
*/

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
//示例 1:
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//示例 2:
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//说明:
//所有节点的值都是唯一的。
//p、q 为不同节点且均存在于给定的二叉树中。
public class LowestCommonAncestorOfABinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 迭代法
    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        // 使用栈
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        // map来保存 当前节点和它的父节点映射
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
        // 初始化
        stack.push(root);
        // 根节点没有父节点
        parentMap.put(root, null);
        // 遍历找到p 和 q
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode curNode = stack.pop();
            if (curNode.left != null) {
                stack.push(curNode.left);
                parentMap.put(curNode.left, curNode);
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
                parentMap.put(curNode.right, curNode);
            }
        }
        // 此时找到pq节点
        // 得到p的所有先祖节点
        HashSet<TreeNode> ancestors = new HashSet<TreeNode>();
        while (p != null) {
            ancestors.add(p);
            // 自下向上移动
            p = parentMap.get(p);
        }
        // 遍历节点 q 的祖先。如果祖先存在于为 p 设置的祖先中
        // 这意味着这是 p 和 q 之间的第一个共同祖先（同时向上遍历），因此这是 LCA 节点。
        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }
        // 此时q就指向了最近的公共先祖
        return q;
    }
}
