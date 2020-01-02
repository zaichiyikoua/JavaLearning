package codingInterviewByJava;

//面试题28：对称的二叉树
//题目：请实现一个函数，用来判断一棵二叉树是不是对称的。
//如果一棵二叉树和它的镜像一样，那么它是对称的。
//		8
//	6		6
//5   7   7   5

public class SymmetricalBinaryTree {
    // 思路，遍历二叉树，比较左子树和右子树的值即可
    public boolean solution(TreeNode root) {

        return detail(root, root);

    }

    public boolean detail(TreeNode rootOne, TreeNode rootTwo) {
        if (rootOne == null && rootTwo == null) {
            // 都没有节点 肯定是对称的
            return true;
        }
        if (rootOne == null || rootTwo == null) {
            // 只要有一个是空指针，肯定不是对称的
            return false;
        }
        // 然后判断节点的值是否相同
        if (rootOne.value != rootTwo.value) {
            return false;
        }
        // 然后递归调用
        return detail(rootOne.left, rootTwo.right) && detail(rootOne.right, rootTwo.left);
    }
}
