package leetcode.part11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记103
*	@author  zaichiyikoua
*	@time  2020年2月27日
*	@title  { 电话号码的字母组合 }
*/

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//示例:
//输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
public class LetterCombinationsOfAPhoneNumber {
    // 这道题本质还是全排列 像全排列这样的用回溯法
    // map记录映射
    @SuppressWarnings("serial")
    HashMap<Character, String> phone = new HashMap<Character, String>() {
        {
            put('0', "");
            put('1', "");
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> solution(String digits) {
        ArrayList<String> resList = new ArrayList<String>();
        // 入值检测
        if (digits == null || "".equals(digits)) {
            return resList;
        }
        StringBuilder track = new StringBuilder();
        backTrack(digits, resList, track, 0);
        return resList;
    }

    public void backTrack(String str, ArrayList<String> res, StringBuilder track, int j) {
        // 首先就是回溯结束条件
        if (track.length() == str.length()) {
            res.add(track.toString());
            return;
        }
        // 拿到当前的数字和对应的字符
        char phoneNumber = str.charAt(j);
        String letter = phone.get(phoneNumber);
        // 回溯
        for (int i = 0; i < letter.length(); i++) {
            track.append(letter.charAt(i));
            backTrack(str, res, track, j + 1);
            // 取消
            track.deleteCharAt(track.length() - 1);
        }
    }
}
