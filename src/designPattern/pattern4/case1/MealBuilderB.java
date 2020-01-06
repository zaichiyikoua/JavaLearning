package designPattern.pattern4.case1;

//具体建造者，用于创建B种套餐
public class MealBuilderB extends MealBuilder {

    @Override
    public void buildFood() {
        // TODO Auto-generated method stub
        meal.setFood("鸡肉卷");
    }

    @Override
    public void buildDrink() {
        // TODO Auto-generated method stub
        meal.setDrink("可口可乐");
    }

}
