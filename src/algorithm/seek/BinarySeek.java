package algorithm.seek;

/*
*   二分查找 java实现
*   二分查找是用的比较多的查找算法，但是有前提条件，就是要求查找的数组必须有序(必须已经排过序了)
*   思路就是一直对半，找到中间值，用需要查找的值去比对中间值，然后缩小查找的范围
*/

public class BinarySeek {
    public int solution(int[] arr, int keyValue) {
        // 中间值
        int mid;
        // 初始的查找区间是[0,arr.length - 1]
        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            mid = (head + tail) / 2;
            // 和中间值比较，然后缩短区间的范围
            if (keyValue < mid) {
                tail = mid - 1;
            } else if (keyValue > mid) {
                head = mid + 1;
            } else {
                // 如果相等了，那就表明是要查找的值
                return mid;
            }
        }
        return -1;
    }
}
