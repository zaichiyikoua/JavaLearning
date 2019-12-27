package codingInterviewByJava;

//面试题37：序列化二叉树
//题目：请实现两个函数，分别用来序列化和反序列化二叉树。
//		1
//	2		3			====>>>    1,2,4,*,*,*,3,5,*,*,6,*,*
//4			5	6

public class SerializeBinaryTrees {

	// 序列化二叉树
	// 前序
	public String solution(TreeNode root) {
		StringBuilder stringBuilder = new StringBuilder();
		if (root == null) {
			stringBuilder.append("*");
		}
		stringBuilder.append(root.value + ",");
		solution(root.left);
		solution(root.right);	
		return stringBuilder.toString();
	}
	
	//反序列化
	public TreeNode Deserialsize(String string) {
		if (string == null || string.equals("")) {
			return null;
		}
		//分割字符串
		String[] split = string.split(",");
		if (split.length <= 0) {
			return null;
		}
		return detail(split);

	}
		//计数器
		private int index = 0;
	public TreeNode detail(String[] stringArray) {
		//初始化头节点
		@SuppressWarnings("unused")
		TreeNode node;
		index ++;
		//只要值不是*
		if (stringArray[index] != "*") {
			//进行序列化
		}

		return null;
	}
}
