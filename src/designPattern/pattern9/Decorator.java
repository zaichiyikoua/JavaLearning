package designPattern.pattern9;

/*
*	设计模式   笔记10
*	@author  zaichiyikoua
*	@time  2020年1月9日
*	@description  { 装饰器模式 }
*/

public class Decorator {
    // 装饰器模式(Decorator pattern),是一种替代继承机制的模式，可以动态的给一个对象增加一些额外的功能
    // 这种方式比继承更加的灵活，将一个类的对象嵌入到另一个新对象中，这个新的对象就是装饰器
    // 设计模式的原则上也说了，建议多使用组合而不是继承
    // 举个例子更容易理解，比如说一张照片，可以在不修改原来的照片的基础上添加相框啊玻璃啊等等额外的功能

    // 如果使用继承的话，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀
    // 结构:1.抽象构件 2.具体构件 3.抽象装饰类 4.具体装饰类
    // 核心就是抽象装饰类的设计
    // case1就是多重加密的例子
    // case2

    // 优点:
    // 1.比继承更加灵活
    // 2.可以通过一种动态的方式来扩展一个对象的功能
    // 3.通过使用不同的具体装饰类以及这些装饰类的排列组合，可以创造出不同行为的组合
    // 缺点:
    // 多重装饰比较复杂
}