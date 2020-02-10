package leetcode.part4;

import java.util.HashMap;
import java.util.Random;

/*
*	leetCode算法刷题记录   笔记35
*	@author  zaichiyikoua
*	@time  2020年2月10日
*	@title  { tinyURL的加密与解密 }
*/

//TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
//要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
public class EncodeAndDecodeTinyURL {
    // 比较简单一点，生成随机数
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    Random random = new Random();
    int key = random.nextInt(Integer.MAX_VALUE);

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // 输入检测
        if (longUrl == null) {
            return null;
        }
        // 查看map中是否存在已有的随机值
        if (map.containsKey(key)) {
            // 已有就重置
            key = random.nextInt(Integer.MAX_VALUE);
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String replace = shortUrl.replace("http://tinyurl.com/", "");
        int parseInt = Integer.parseInt(replace);
        return map.get(parseInt);
    }
}
