package codingInterviewByJava;

//面试题23：链表中环的入口结点
//题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
//环的入口结点是结点3。

public class EntryNodeInListLoop {

    // 思路
    // 要找到链表中的环的入口 首先要链表中存在环
    // 怎样判断是否存在环？
    // 方法 快慢指针 如果有环 快指针会追上慢指针 如果快指针到了链尾都没有追到 则无

    // 如果有环 怎样找到入口？
    // 方法 使用快慢指针 找到环中有n个节点
    // 让快指针先移动n步 然后快慢指针同时移动 快指针追上慢指针时 就是环的入口

    // 怎样找出环中的节点数？
    // 因为有环 两个指针相遇一定是在环内 可以从这个节点出发
    // 再次回到该节点时，就可以得到环的节点数
    public int solution(ListNode header) {
        if (header == null) {
            return -1;
        }

        // 初始化快慢指针 初始时都指向头节点
        ListNode quickNode = header;
        ListNode slowNode = header;
        boolean flag = false;

        // 判断是否存在环
        while (quickNode != null && slowNode != null) {
            if (quickNode == slowNode) {
                flag = true;
            } else {
                quickNode = quickNode.nextNode;
                slowNode = slowNode.nextNode;
                // 这里如果不进行操作的话 快慢指针会保持距离
                // 达不到快慢的效果 所以要让快指针多移动一步
                if (quickNode.nextNode != null) {
                    quickNode = quickNode.nextNode;
                }
            }
        }

        // 找出环中的节点数
        int countingNode = 0;
        // 注意 此时的快慢指针相等 获取此时的节点来找节点数
        ListNode node = quickNode;
        if (flag) {
            // 再次回到该节点时，统计完成
            while (node.nextNode != node) {
                node = node.nextNode;
                ++countingNode;
            }
        } else {
            // 表示没有环
            return -2;
        }
        // 现在有了节点数n 相同状态的快慢指针
        if (countingNode > 0) {
            // 让快指针先移动n步
            for (int i = 0; i < countingNode; i++) {
                quickNode = quickNode.nextNode;
            }
            // 然后一起移动 直到快指针追上慢指针
            while (quickNode != slowNode) {
                quickNode = quickNode.nextNode;
                slowNode = slowNode.nextNode;
            }
            // 返回快慢都可以
            return quickNode.value;
        }
        return -2;
    }
}
