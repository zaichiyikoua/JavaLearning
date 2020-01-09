package designPattern.pattern9.case1;

//具体实现高级加密类
public class AdvancedCipher extends CipherDecorator {

    public AdvancedCipher(Cipher cipher) {
        super(cipher);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String encrypt(String plainText) {
        // TODO Auto-generated method stub
        String encrypt = super.encrypt(plainText);
        String mod = mod(encrypt);
        return mod;

    }

    public String mod(String text) {
        String string = "";
        for (int i = 0; i < text.length(); i++) {
            String valueOf = String.valueOf(text.charAt(i) % 6);
            string += valueOf;
        }

        return string;
    }
}
