package javaBasicExercises.part3;

/*
*	javaSE专项练习27
*	@author  zaichiyikoua
*	@time  2020年1月1日
*/

public class Coding27 {
    // Java是一门支持反射的语言,基于反射为Java提供了丰富的动态性支持
    // 下面关于Java反射的描述，哪些是错误的:( )

    // A.Java反射主要涉及的类如Class, Method, Filed,等，他们都在java.lang.reflet包下
    // B.通过反射可以动态的实现一个接口，形成一个新的类，并可以用这个类创建对象，调用对象方法
    // C.通过反射，可以突破Java语言提供的对象成员、类成员的保护机制，访问一般方式不能访问的成员
    // D.Java反射机制提供了字节码修改的技术，可以动态的修剪一个类
    // E.Java的反射机制会给内存带来额外的开销。例如对永生堆的要求比不通过反射要求的更多
    // F.Java反射机制一般会带来效率问题，效率问题主要发生在查找类的方法和字段对象，因此通过缓存需要反射类的字段和方法就能达到与之间调用类的方法和访问类的字段一样的效率

    // 答案ADF
    // A中Class是在lang包中，Method,Filed,Constructor等在java.lang.reflet包中
    // BC没有什么问题，反射就是这么用的
    // E反射的确给内存带来额外的开销。这点要记住，书上是这么写的

}
