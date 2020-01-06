package designPattern.pattern4.case1;

//产品类
public class Meal {
    // 套餐类是一个复杂的对象
    // 包括两个成员属性
    private String food;// 食物
    private String drink;// 饮料

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

}
