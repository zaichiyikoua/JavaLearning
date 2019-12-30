package interview;

/*
*	javaSE专项练习25
*	@author  zaichiyikoua
*	@time  2019年12月27日
*/

public class Coding25 {
    public static void main(String[] args) {
        System.out.println(Math.round(11.5));// 12
        System.out.println(Math.round(-11.5));// -11
        System.out.println("/n");

        System.out.println(Math.floor(11.5));// 11.0
        System.out.println(Math.floor(-11.5));// -12.0
        System.out.println("/n");

        System.out.println(Math.ceil(11.5));// 12.0
        System.out.println(Math.ceil(-11.5));// -11.0

        // 这种题注意一下api的方法即可，四舍五入(round)，向上取整(ceil)，向下取整(floor)
    }
}
