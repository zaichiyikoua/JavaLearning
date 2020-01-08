package designPattern.pattern8.case1;

//抽象权限类,是真实权限类和代理主题的公共接口
public interface AbstractPermission {
    public void modifyUserInfo();

    public void viewNote();

    public void publishNote();

    public void modifyNote();

    public void setLevel(int level);
}
