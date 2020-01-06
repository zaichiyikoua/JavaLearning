package designPattern.pattern4.case1;

//指挥者
//在套餐的制作过程中，它就是KFC的服务员
//具体的建造者由客户决定
public class KFCWaiter {
    private MealBuilder builder;

    public void setBuilder(MealBuilder builder) {
        this.builder = builder;
    }

    public Meal construct() {
        builder.buildDrink();
        builder.buildFood();
        return builder.getMeal();
    }
}
