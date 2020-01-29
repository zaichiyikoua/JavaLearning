package javaBasicExercises.part4;

/*
*	javaSE专项练习36
*	@author  zaichiyikoua
*	@time  2020年1月29日
*/

public class Coding36 {
    // 下面有关JDBC statement的说法错误的是?

    // A.JDBC提供了Statement、PreparedStatement 和
    // CallableStatement三种方式来执行查询语句，其中Statement 用于通用查询，PreparedStatement 用于执行参数化查询，而
    // CallableStatement则是用于存储过程

    // B.对于PreparedStatement来说，数据库可以使用已经编译过及定义好的执行计划，由于 PreparedStatement
    // 对象已预编译过，所以其执行速度要快于 Statement 对象”

    // C.PreparedStatement中，“?” 叫做占位符，一个占位符可以有一个或者多个值

    // D.PreparedStatement可以阻止常见的SQL注入式攻击

    // 答案C
    // 虽然现在早就不会用原始的JDBC去操作数据库了，但是面试有可能还是会问
    // 这道题也没什么好说的，?占位符只能有一个值，不能有多个值
}
