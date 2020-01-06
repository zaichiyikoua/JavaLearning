package designPattern.pattern5.case1;

public class Demo {

    public static void main(String[] args) throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        Email email, copyEmail;
        email = new Email();
        copyEmail = (Email) email.clone();

        System.out.println(email == copyEmail);// false
        System.out.println(email.getAttachment() == copyEmail.getAttachment());// true

        // 拷贝之后，两个对象的地址是不同的，所以不是同一个对象
        // 但是这是浅拷贝，所以对象的引用变量还是一样的
    }

}
