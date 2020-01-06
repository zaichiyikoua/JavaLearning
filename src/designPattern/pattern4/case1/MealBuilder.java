package designPattern.pattern4.case1;

//抽象建造者，声明抽象的内部组成方法
public abstract class MealBuilder {
    protected Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
