package leetcode.part9;

import java.util.ArrayList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记90
*	@author  zaichiyikoua
*	@time  2020年2月24日
*	@title  { 括号生成 }
*/

//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//例如，给出 n = 3，生成结果为：
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
public class GenerateParentheses {
    public List<String> solution(int n) {
        ArrayList<String> resultList = new ArrayList<String>();
        detail(n, resultList, "", 0, 0);
        return resultList;
    }

    public void detail(int n, ArrayList<String> list, String cur, int open, int close) {
        // 结束条件
        if (cur.length() == 2 * n) {
            list.add(cur);
            return;
        }
        if (open < n) {
            detail(n, list, cur + "(", open + 1, close);
        }
        if (close < open) {
            detail(n, list, cur + ")", open, close + 1);
        }
    }
}
