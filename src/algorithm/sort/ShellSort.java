package algorithm.sort;

/*
*	希尔排序 java实现
*	加强版插排 与插入排序的不同之处在于，它会优先比较距离较远的元素
*	核心思路将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序
*/

public class ShellSort {
    public static int[] solution(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return null;
        }
        int length = arr.length;
        int temp;
        // 增量gap 并且逐步缩减增量
        for (int gap = (int) Math.floor(length / 2); gap > 0; gap /= 2) {
            // 分解之后 内部其实是一个插排
            for (int i = gap; i < length; i++) {
                int j = i;
                temp = arr[i];
                while (j - gap >= 0 && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 1, 4, 5, 7, 2, 9, 8 };
        int[] solution = solution(arr);
        for (int i : solution) {
            System.out.println(i);
        }
        // 输出结果符合预期
    }
}
