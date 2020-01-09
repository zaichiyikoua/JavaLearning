package designPattern.pattern9.case1;

//抽象装饰类
public class CipherDecorator implements Cipher {
    private Cipher cipher;

    public CipherDecorator(Cipher cipher) {
        super();
        this.cipher = cipher;
    }

    @Override
    public String encrypt(String plainText) {
        // TODO Auto-generated method stub
        return cipher.encrypt(plainText);
    }

}
