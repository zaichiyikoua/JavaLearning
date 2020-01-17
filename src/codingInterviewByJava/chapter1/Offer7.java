package codingInterviewByJava.chapter1;

/*
*	剑指offer面试题复习  笔记7
*	@author  zaichiyikoua
*	@time  2020年1月17日
*	@title  { 替换空格 }
*/

//题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
//则输出“We%20are%20happy.”。
public class Offer7 {
    // 思路1，这里题目没有其他的限制条件，所以最简单方便高效的方法就是用stringBuffer来完成
    public String solution(String string) {
        if (string == null || string.equalsIgnoreCase("")) {
            return null;
        }
        if (string.length() == 1) {
            return string;
        }
        StringBuffer stringBuffer = new StringBuffer();
        // 思路就是遍历字符串，如果不是，就放进buffer中，最后输出buffer
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(string.charAt(i));
            }
        }
        // 考虑如果要求返回的是String类型
        return stringBuffer.toString();
    }

    // 思路2，还是用stringBuffer来完成
    public String solution2(String string) {
        if (string == null || string.equalsIgnoreCase("")) {
            return null;
        }
        if (string.length() == 1) {
            return string;
        }
        // 这个思路是遍历buffer，如果不是，就换成要求的格式，然后返回buffer
        // 这两个思路都是大同小异的
        StringBuffer stringBuffer = new StringBuffer(string);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == ' ') {
                stringBuffer.replace(0, 1, "%20");
            }
        }

        return stringBuffer.toString();
    }

    // 这是书上的思路，假定在原有的字符串上来进行替换
    // 思路就是先遍历一遍字符串，记录出现空格的次数，计算出替换之后字符串的总长度，然后从后向前进行替换
    public void solution3(char[] str, int length) {
        if (str == null || length <= 0) {
            return;
        }
        // 初始字符串长度
        int originLength = 0;
        // 记录空格次数
        int numberOfBlank = 0;
        int i = 0;
        while (str[i] != '\0') {
            ++originLength;
            if (str[i] == ' ') {
                ++numberOfBlank;
            }
            ++i;
        }
        // 替换后的长度
        int afterReplaceLength = originLength + numberOfBlank * 2;
        if (afterReplaceLength > length) {
            return;
        }
        int indexOfOrigin = originLength;
        int indexOfAfter = afterReplaceLength;

        while (indexOfOrigin >= 0 && indexOfAfter > indexOfOrigin) {
            // 倒序的
            if (str[indexOfOrigin] == ' ') {
                str[indexOfAfter--] = '0';
                str[indexOfAfter--] = '2';
                str[indexOfAfter--] = '%';
            } else {
                str[indexOfAfter--] = str[indexOfOrigin];
            }
            --indexOfOrigin;
        }

        return;
    }
}
