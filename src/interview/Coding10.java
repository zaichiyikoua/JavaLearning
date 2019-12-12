package interview;

/*
*	javaSE专项练习10
*	2019年12月12日
*/

public class Coding10 {
	public static void main(String[] args) {
		String classfile = "com.jd.".replaceAll(".", "/") + "Myclass.class";
		System.out.println(classfile);
		// 输出///////Myclass.class
		// 小心有坑 replaceAll方法第一个参数是正则表达式
		// "."表示任意字符 如果想替换的是"." 要写成"\\."

	}
}
