package designPattern.pattern8.case1;

//真实权限类
public class RealPermission implements AbstractPermission {

    @Override
    public void modifyUserInfo() {
        // TODO Auto-generated method stub
        System.out.println("修改权限信息");
    }

    // 空实现
    @Override
    public void viewNote() {
        // TODO Auto-generated method stub

    }

    @Override
    public void publishNote() {
        // TODO Auto-generated method stub
        System.out.println("发布新的帖子");
    }

    @Override
    public void modifyNote() {
        // TODO Auto-generated method stub
        System.out.println("修改帖子的内容");
    }

    // 空实现
    @Override
    public void setLevel(int level) {
        // TODO Auto-generated method stub

    }

}
