package algorithm.seek;

/*
*   顺序查找 java实现
*   顺序查找是最简单的查找，实现也很简单
*/

public class OrderSeek {
    public int solution(int[] arr, int keyValue) {
        // 顺序查找特别简单，直接遍历数组，找到需要的值，然后返回即可
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == keyValue) {
                return arr[i];
            }
        }
        return -1;
    }
}
