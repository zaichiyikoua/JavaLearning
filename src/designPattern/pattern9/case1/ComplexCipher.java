package designPattern.pattern9.case1;

//具体实现装饰类
public class ComplexCipher extends CipherDecorator {

    public ComplexCipher(Cipher cipher) {
        super(cipher);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String encrypt(String plainText) {
        // TODO Auto-generated method stub
        String encrypt = super.encrypt(plainText);
        String reverse = reverse(encrypt);
        return reverse;
    }

    // 装饰器新增的功能
    public String reverse(String text) {
        String string = "";
        for (int i = text.length(); i > 0; i++) {
            string += text.substring(i - 1, i);
        }
        return string;
    }
}
