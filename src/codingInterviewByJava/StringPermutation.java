package codingInterviewByJava;

//面试题38：字符串的排列
//题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
//则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。

public class StringPermutation {
    // 思路，将字符串转换成字符数组，求整个数组的排列组合
    // 将整个数组视作两部分，一部分是第一个字符，一部分是后面的所有字符
    // 第一步先求出所有可能在第一位的字符，就是把第一个字符和后面的所有字符交换
    // 第二部，固定首字符，求后面的字符的排列组合
    // 递归过程
    public void solution(String string) {
        if (string == null) {
            return;
        }
        char[] charArray = string.toCharArray();
        // 调用排列函数,默认从0开始
        detail(charArray, 0);
    }

    // beginIndex指向当前执行排列的时候的字符串的第一个字符
    public void detail(char[] charArray, int beginIndex) {
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
        for (int i = beginIndex; i < charArray.length; i++) {
            // 优化，如果有重复字符串，则不交换
            if ((charArray[i] == charArray[beginIndex]) && beginIndex != i) {
                continue;
            }
            // 交换
            char temp = charArray[beginIndex];
            charArray[beginIndex] = charArray[i];
            charArray[i] = temp;
            // 固定第一个字符，指针移动
            detail(charArray, beginIndex + 1);
            // 复原
            temp = charArray[beginIndex];
            charArray[beginIndex] = charArray[i];
            charArray[i] = temp;

            System.out.println(charArray);

        }
    }

}
