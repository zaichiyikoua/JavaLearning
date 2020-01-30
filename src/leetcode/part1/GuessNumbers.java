package leetcode.part1;

/*
*	leetCode算法刷题记录   笔记6
*	@author  zaichiyikoua
*	@time  2020年1月30日
*	@title  { 猜数字 }
*/

//小A和小B在玩猜数字。小B每次从 1,2,3中随机选择一个，小A每次也从 1,2,3中选择一个猜。他们一共进行三次这个游戏，请返回小A猜对了几次？
//输入的guess数组为小A每次的猜测，answer数组为小B每次的选择。guess和answer的长度都等于3。
//示例 1：
//输入：guess = [1,2,3], answer = [1,2,3]
//输出：3
//解释：小A 每次都猜对了。
//示例 2：
//输入：guess = [2,2,3], answer = [3,2,1]
//输出：1
//解释：小A 只猜对了第二次。
//限制：
//guess的长度 = 3
//answer的长度 = 3
//guess的元素取值为 {1, 2, 3} 之一。
//answer的元素取值为 {1, 2, 3} 之一。
public class GuessNumbers {
    // 这可能是所有leetCode中最简单的一道题
    // 思路也很简单，又限制了长度，所以直接依次比较两个数组对应的值是否相同即可
    public int solution(int[] guess, int[] answer) {
        if (guess == null || answer == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                result++;
            }
        }
        return result;
    }
}
