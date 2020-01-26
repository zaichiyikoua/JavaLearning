package javaBasicExercises.part4;

import java.net.URL;

/*
*	javaSE专项练习32
*	@author  zaichiyikoua
*	@time  2020年1月26日
*/

public class Coding32 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            URL url = new URL("http://www.123.com");
            System.out.println(url);
            URL url2 = new URL("http://www.baidu.com");
            System.out.println(url2);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // URL u =new URL("http://www.123.com");。如果www.123.com不存在，则返回______。
    // URL u =new URL("http://www.123.com");这句话的时候确实要抛出异常
    // 但是这个异常属于IOException，不管网址是否存在，最后都会返回该网址的一个连接，打印出来就是该网址。
}
