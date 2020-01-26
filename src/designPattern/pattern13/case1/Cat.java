package designPattern.pattern13.case1;

//具体目标类
public class Cat extends MySubject {

    @Override
    public void cry() {
        // TODO Auto-generated method stub
        System.out.println("cat show");
        for (Object obj : observers) {
            ((MyObserver) obj).response();
        }
    }

}
