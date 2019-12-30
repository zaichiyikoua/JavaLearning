package interview;

/*
*	javaSE专项练习6
*	2019年12月11日
*/

public class Coding6 {
    public static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin";
    }

    public static void main(String[] args) {
        System.out.println(isAdmin("ADmin"));
        // 这里还是为false
        // 要注意上面的那个方法用的是== 不是equals
        // 在源码中 toLowerCase()是重新new String()
    }
}
