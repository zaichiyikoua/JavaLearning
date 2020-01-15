package codingInterviewByJava.past;

//面试题5
//替换空格
//题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
//则输出“We%20are%20happy.”
public class ReplaceSpaces {
    // 思路 遍历字符串 利用辅助的buffer 遍历原串 到空格的时候 更换为对应的字符
    // 顺序 从前往后
    public String solution(String string) {
        if (string.length() <= 0 || string == null) {
            return new String("数组不能为空");
        }
        if (string.length() == 1) {
            return string;
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                buffer.append("%20");
            } else {
                buffer.append(string.charAt(i));
            }
        }

        return buffer.toString();
    }

    // 书上的思路 遍历原串 记录空格的数量 算出一个有空格的长度
    // 然后从后向前遍历赋值
    public String solutionSecond(String string) {
        if (string.length() <= 0 || string == null) {
            return new String("数组不能为空");
        }
        if (string.length() == 1) {
            return string;
        }
        char[] charArray = string.toCharArray();

        int originLength = 0;// 原串长度
        int blank = 0;// 空格数量
        int nowLength = 0;// 新串的长度

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                blank++;
            }
            ++originLength;
        }

        // 优化 如果没有空格
        if (blank == 0) {
            return string;
        }

        nowLength = originLength + blank * 2;// 多一个空格 要多出两个字符

        // 两个指针,都指向串尾
        int originIndex = originLength;
        int nowIndex = nowLength;
        StringBuffer stringBuffer = new StringBuffer();

        while (originIndex >= 0 && nowIndex > originIndex) {
            // 从后向前遍历
            if (string.charAt(originIndex) == ' ') {// 如果为空格
                charArray[nowIndex--] = '0';
                charArray[nowIndex--] = '2';
                charArray[nowIndex--] = '/';
            } else {
                charArray[nowIndex--] = charArray[originIndex];
            }
            --originIndex;
        }
        return stringBuffer.toString();
    }
}
