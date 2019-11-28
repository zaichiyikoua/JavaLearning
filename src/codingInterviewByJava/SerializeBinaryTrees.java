package codingInterviewByJava;

//面试题37：序列化二叉树
//题目：请实现两个函数，分别用来序列化和反序列化二叉树。
//		1
//	2		3			====>>>    1,2,4,*,*,*,3,5,*,*,6,*,*
//4			5	6

public class SerializeBinaryTrees {

	// 序列化二叉树
	// 前序
	public void solution(TreeNode root) {
		if (root == null) {
			System.out.println("*");
		}
		System.out.println(root.value);
		solution(root.left);
		solution(root.right);

	}

}
