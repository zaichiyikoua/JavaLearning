package designPattern.pattern8.case1;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 因为种种原因，不能直接地使用实现类
        // 所以使用代理，来间接的使用
        AbstractPermission permission = new ProxyPermission();

        permission.modifyUserInfo();
        permission.modifyNote();
        permission.viewNote();
        permission.publishNote();
        System.out.println("#####");
        permission.setLevel(1);
        permission.modifyUserInfo();
        permission.modifyNote();
        permission.viewNote();
        permission.publishNote();

//        没有权限
//        没有权限
//        查看帖子
//        没有权限
//        #####
//        修改权限信息
//        修改帖子的内容
//        查看帖子
//        发布新的帖子
    }

}
