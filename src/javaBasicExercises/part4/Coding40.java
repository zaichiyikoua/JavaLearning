package javaBasicExercises.part4;

/*
*	javaSE专项练习40
*	@author  zaichiyikoua
*	@time  2020年1月30日
*/

public class Coding40 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Coding40 coding40 = new Coding40();
        Byte a = 127;
        Byte b = 127;
        coding40.add(++a);
        System.out.print(a + " ");
        coding40.add(b);
        System.out.print(b + "");

//       -128 
//        127

        // 这道题的知识点只有一个---->>>>包装类是和stirng一样是不可变的类
    }

    public void add(Byte b) {
        b = b++;
    }
}
