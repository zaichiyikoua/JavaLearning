package designPattern.pattern9.case1;

//简单加密实现类
public class SimpleCipher implements Cipher {

    @Override
    public String encrypt(String plainText) {
        // TODO Auto-generated method stub
        String string = "";
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += 6;
                if (c > 'z') {
                    c -= 26;
                }
                if (c < 'a') {
                    c += 26;
                }
            }
            if (c >= 'A' && c <= 'Z') {
                c += 6;
                if (c > 'Z') {
                    c -= 26;
                }
                if (c < 'A') {
                    c += 26;
                }
            }
            string += c;
        }
        return string;
    }

}
