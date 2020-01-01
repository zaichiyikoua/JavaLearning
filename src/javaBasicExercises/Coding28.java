package javaBasicExercises;

/*
*	javaSE专项练习28
*	@author  zaichiyikoua
*	@time  2020年1月1日
*/

public class Coding28 {
    // 下面的对象创建方法中哪些会调用构造方法:( )?
    // A.new语句创建对象
    // B.调用Java.io.ObjectInputStream的readObject方法
    // C.java反射机制使用java.lang.Class或java.lang.reflect.Constructor的newInstance()方法
    // D.调用对象的clone()方法

    // 答案AC

    // A是构造方法New，B是序列化，C是反射，D是克隆
    // 只有AC会调用构造方法
}
