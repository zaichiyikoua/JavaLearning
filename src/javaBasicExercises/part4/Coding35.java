package javaBasicExercises.part4;

/*
*	javaSE专项练习35
*	@author  zaichiyikoua
*	@time  2020年1月29日
*/

public class Coding35 {
    // 以下多线程对int型变量x的操作，哪几个不需要进行同步( )?
    // A.x=y;
    // B.x++;
    // C.++x;
    // D.x=1;

    // 答案D
    // 解析:
    // A中y未知，所以要加锁，B,C已经说过很多次了，D是赋值操作是原子性的
    // Java中的原子操作包括:1. long,double类型之外的赋值操作 2.Atomic包中的所有操作 3.所有引用reference的赋值操作

}
