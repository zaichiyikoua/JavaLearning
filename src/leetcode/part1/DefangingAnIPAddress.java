package leetcode.part1;

/*
*	leetCode算法刷题记录   笔记7
*	@author  zaichiyikoua
*	@time  2020年1月30日
*	@title  { IP地址无效化 }
*/

//给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
//所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
//示例 1：
//输入：address = "1.1.1.1"
//输出："1[.]1[.]1[.]1"
//示例 2：
//输入：address = "255.100.50.0"
//输出："255[.]100[.]50[.]0"
//提示：
//给出的 address 是一个有效的 IPv4 地址
public class DefangingAnIPAddress {
    // 最简单的方式是replace去替换掉原来的字符
    // 但是这就是典型的1分解答，肯定不合格
    public String solution(String address) {
        return address.replaceAll(".", "[.]");
    }

    // 这种是我处理字符串最喜欢用的，也是最实用的
    // 使用stringBuffer去操作
    public String solution2(String address) {
        if (address == null || "".equals(address)) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        // 只要为.，就替换成[.]
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                buffer.append("[.]");
            }
            buffer.append(address.charAt(i));
        }
        return buffer.toString();
    }
}
