package algorithm;

import java.util.ArrayList;

//简单的排序算法 Java实现
public class NormalSort<E> {
    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        if (list.size() == 0 || list == null) {
            System.out.println("");
        }
        // 定义三部分来进行分类
        ArrayList<Integer> smaller = new ArrayList<Integer>();
        ArrayList<Integer> same = new ArrayList<Integer>();
        ArrayList<Integer> larger = new ArrayList<Integer>();
        // 二分 获取二分点的值 也可以是其他随机数
        Integer flag = list.get(list.size() / 2);
        // 遍历list 将list中的数据根据大小分类
        for (Integer integer : list) {
            if (integer < flag) {
                smaller.add(integer);
            } else if (integer > flag) {
                larger.add(integer);
            } else {
                same.add(integer);
            }
        }
        // 然后递归 继续分
        sort(larger);
        sort(smaller);

        list.clear();
        list.addAll(smaller);
        list.addAll(same);
        list.addAll(larger);

        return list;

    }
}
