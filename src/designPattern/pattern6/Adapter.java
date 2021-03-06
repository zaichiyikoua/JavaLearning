package designPattern.pattern6;

/*
*	设计模式   笔记7
*	@author  zaichiyikoua
*	@time  2020年1月7日
*	@description  { 适配器模式 }
*/

public class Adapter {
    // 适配器模式(Adapter pattern)，是使用频率很好的结构型设计模式
    // 如果在系统中存在不兼容的接口，可以通过引入一个适配器来使得原本因为接口不兼容而不能一起工作的类可以协同工作
    // 举个例子更加容易理解，就比如说SD卡和电脑，SD卡是不能直接在电脑上用的，需要一个转换器
    // 或者更加简单的例子，充电的数据线插头转换器。适配器模式就是类似转换器一样的。以及JDBC
    // 引入适配器之后不需要对原有的系统进行任何修改，并且更换适配器或增加都是很方便的

    // 结构：1.目标抽象类 2.适配器类 3.适配者类 4.客户类

    // 优点：
    // 1.可以让任何两个没有关联的类一起运行。
    // 2.提高了类的复用。
    // 3.增加了类的透明度。
    // 4.灵活性好。
    // 缺点：
    // 1.过多地使用适配器，会让系统非常零乱，不易整体进行把握。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。
    // 2..由于 JAVA 至多继承一个类，所以至多只能适配一个适配者类，而且目标类必须是抽象类。
}
