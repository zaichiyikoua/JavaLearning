package designPattern.pattern5.case2;

import java.io.IOException;

import designPattern.pattern5.case2.Email;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Email email, copyEmail = null;
        email = new Email();
        try {
            copyEmail = (Email) email.deepClone();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(email == copyEmail);// false
        System.out.println(email.getAttachment() == copyEmail.getAttachment());// false

        // 深拷贝之后，对象的地址和引用成员变量都发生了改变
    }

}
