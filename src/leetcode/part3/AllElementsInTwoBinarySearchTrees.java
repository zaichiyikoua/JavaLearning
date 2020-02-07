package leetcode.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记23
*	@author  zaichiyikoua
*	@time  2020年2月7日
*	@title  { 两棵二叉搜索树中的全部元素 }
*/

//给你 root1 和 root2 这两棵二叉搜索树。
//请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
//示例 1：
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
//示例 2：
//输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
//输出：[-10,0,0,1,2,5,7,10]
//示例 3：
//输入：root1 = [], root2 = [5,1,7,0,2]
//输出：[0,1,2,5,7]
//示例 4：
//输入：root1 = [0,-10,10], root2 = []
//输出：[-10,0,10]
//示例 5：
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
//提示：
//每棵树最多有 5000 个节点。
//每个节点的值在 [-10^5, 10^5] 之间。
public class AllElementsInTwoBinarySearchTrees {
    // 比较简单直接的思路就是遍历两棵树，记录所有的节点值，然后统一排序
    List<Integer> resultList;

    public List<Integer> solution(TreeNode root1, TreeNode root2) {
        resultList = new ArrayList<Integer>();
        detail(root1);
        detail(root2);
        Collections.sort(resultList);
        return resultList;
    }

    public void detail(TreeNode node) {
        if (node == null) {
            return;
        }
        resultList.add(node.val);
        detail(node.left);
        detail(node.right);
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
