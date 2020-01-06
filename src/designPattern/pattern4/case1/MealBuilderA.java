package designPattern.pattern4.case1;

//具体建造者，用于创建A种套餐
public class MealBuilderA extends MealBuilder {

    @Override
    public void buildFood() {
        // TODO Auto-generated method stub
        meal.setFood("汉堡");
    }

    @Override
    public void buildDrink() {
        // TODO Auto-generated method stub
        meal.setDrink("百事可乐");
    }

}
