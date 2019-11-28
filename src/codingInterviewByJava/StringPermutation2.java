package codingInterviewByJava;

import java.util.LinkedList;

//面试题38：字符串的排列2
//题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
//则打印出由字符a、b、c所能排列出来的所有字符串{a,b,c,ab,ac,bc,abc}

public class StringPermutation2 {
	// 思路
	// 有1个字符的组合，2个字符的组合，3个字符的组合
	// 一般规律 从n个字符里面找到m个字符的组合
	// 可以把n个字符分成两部分，第一个字符和其他所有字符。
	// 如果组合里包含第一个字符，则下一步在剩余的字符里选取m-1个字符
	// 如果组合里不包含第一个字符，则下一步在剩余的n-1个字符里选取m个字符
	public void solution(String string) {
		char[] charArray = string.toCharArray();
		for (int i = 1; i < charArray.length; i++) {
			permutation(charArray, 0, i);
		}
	}

	// 排列函数
	public void permutation(char[] charArray, int beginIndex, int secondIndex) {
		if (charArray == null) {
			return;
		}
		// 不能为负数，不能超过数组长度
		if (beginIndex < 0 || beginIndex > charArray.length) {
			return;
		}
		// 字符串只有一位的时候不用排列组合
		if (beginIndex == charArray.length - 1) {
			System.out.println(charArray);
		}
		// m小于n
		if (secondIndex > beginIndex) {
			return;
		}
		LinkedList<Character> stack = new LinkedList<Character>();
		// 把第一个字符放进栈中,在剩余的字符中选取num-1个字符
		stack.push(charArray[beginIndex]);
		permutation(charArray, beginIndex + 1, secondIndex - 1);
		// 不包含第一个字符,则下一步在剩余的字符中选取num个字符
		stack.pop();
		permutation(charArray, beginIndex + 1, secondIndex);

	}

}
