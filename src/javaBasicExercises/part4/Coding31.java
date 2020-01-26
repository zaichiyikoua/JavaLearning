package javaBasicExercises.part4;

/*
*	javaSE专项练习31
*	@author  zaichiyikoua
*	@time  2020年1月26日
*/

public class Coding31 {
    // 有关hashMap跟hashTable的区别，说法正确的是()？
    // A.HashMap和Hashtable都实现了Map接口
    // B.HashMap是非synchronized，而Hashtable是synchronized
    // C.HashTable使用Enumeration，HashMap使用Iterator
    // D.HashMap允许将 null 作为一个 entry 的 key 或者 value，而 Hashtable 不允许。

    // 这个C选项要注意一下
    // HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的。
    // 所以当有其它线程改变了HashMap的结构（增加或者移除元素），将会抛出ConcurrentModificationException，但迭代器本身的remove()方法移除元素则不会抛出
}
