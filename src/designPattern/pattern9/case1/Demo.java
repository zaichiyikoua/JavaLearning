package designPattern.pattern9.case1;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String password = "hello";
        String cipherPassword;

        SimpleCipher simpleCipher = new SimpleCipher();
        cipherPassword = simpleCipher.encrypt(password);
        System.out.println(cipherPassword);
        System.out.println("######");

        ComplexCipher complexCipher = new ComplexCipher(simpleCipher);
        cipherPassword = complexCipher.encrypt(password);
        System.out.println(cipherPassword);
        System.out.println("######");

        AdvancedCipher advancedCipher = new AdvancedCipher(complexCipher);
        cipherPassword = advancedCipher.encrypt(password);
        System.out.println(cipherPassword);
    }

}
