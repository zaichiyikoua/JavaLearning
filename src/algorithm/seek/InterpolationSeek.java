package algorithm.seek;

/*
*   插值查找 java实现
*   插值查找是基于二分查找的算法，二分是找中间值，插值插值是自适应的，根据关键字在数组中的大概位置，让mid值更接近Key
*   这样更有效的减少了比较次数，思路和二分基本一直，只是将查找点改为自适应
*/

public class InterpolationSeek {
    public int solution(int[] arr, int keyValue) {
        int mid;
        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            // 自适应查找点
            mid = head + (keyValue - arr[head]) / (arr[tail] - arr[head]);
            if (mid < arr[mid]) {
                mid = tail - 1;
            } else if (mid > arr[mid]) {
                mid = head + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
