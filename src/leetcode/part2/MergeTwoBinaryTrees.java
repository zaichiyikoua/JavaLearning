package leetcode.part2;

/*
*	leetCode算法刷题记录   笔记17
*	@author  zaichiyikoua
*	@time  2020年2月6日
*	@title  { 合并二叉树 }
*/

//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
//注意: 合并必须从两个树的根节点开始。
public class MergeTwoBinaryTrees {
    // 思路，首先输入值检测，因为是覆盖的树，所以如果t1空，返回t2，如果t2空，返回t1
    // 然后生成节点递归即可
    public TreeNode solution(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 生成新树的节点
        int mergedValue = t1.val + t2.val;
        TreeNode node = new TreeNode(mergedValue);
        node.left = solution(t1.left, t2.left);
        node.right = solution(t1.right, t2.right);

        return node;

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
