package codingInterviewByJava;

//面试题58（一）：翻转单词顺序
//题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
//为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//则输出"student. a am I"。

public class ReverseWordsInSentence {
    // 思路
    // 先反转整个字符串 然后将字符串中的每个单词反转
    public String solution(String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        char[] charArray = string.toCharArray();
        // 先将整个字符串反转
        String reverseString = reverse(charArray, 0, charArray.length - 1).toString();
        // 然后转成String再分割成单词
        String[] split = reverseString.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历整个反转的字符串
        for (String stringSplit : split) {
            // 将单词反转后放入builder
            stringBuilder.append(reverse(stringSplit.toCharArray(), 0, stringSplit.toCharArray().length - 1));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public char[] reverse(char[] array, int start, int end) {
        if (array == null || array.length == 0) {
            return null;
        }
        if (start > end) {
            return null;
        }
        // 前后指针向中间移动 交换首尾的字符
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
        return array;
    }
}
