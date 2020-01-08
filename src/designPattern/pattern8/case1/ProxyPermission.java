package designPattern.pattern8.case1;

//权限代理类
public class ProxyPermission implements AbstractPermission {
    private RealPermission permission = new RealPermission();
    private int level;

    @Override
    public void modifyUserInfo() {
        // TODO Auto-generated method stub
        if (level == 0) {
            System.out.println("没有权限");
        } else if (level == 1) {
            permission.modifyUserInfo();
        }
    }

    @Override
    public void viewNote() {
        // TODO Auto-generated method stub
        System.out.println("查看帖子");
    }

    @Override
    public void publishNote() {
        // TODO Auto-generated method stub
        if (level == 0) {
            System.out.println("没有权限");
        } else if (level == 1) {
            permission.publishNote();
        }
    }

    @Override
    public void modifyNote() {
        // TODO Auto-generated method stub
        if (level == 0) {
            System.out.println("没有权限");
        } else if (level == 1) {
            permission.modifyNote();
        }
    }

    @Override
    public void setLevel(int level) {
        // TODO Auto-generated method stub
        this.level = level;
    }

}
