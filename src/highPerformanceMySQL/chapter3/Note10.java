package highPerformanceMySQL.chapter3;

/*
*	MySQL性能优化   学习笔记10
*	@author  zaichiyikoua
*	@time  2020年1月10日
*	@description  { 优化count()查询 }
*/

public class Note10 {
    // count()是一个聚合函数，有两种不同的作用，可以统计某个列值的数量，也可以统计行数。
    // 比较常见的错误就是:在括号内制定了一个列却希望统计结果集的行数
    // 如果希望得到结果集的行数，那么最好使用count(*)

    // 1.简单的优化
    // count()函数执行很快是要求有前提条件的。即只有没有任何where条件的count(*)才会非常快
    // 举个例子：
    // 使用标准库world快速查询所有ID大于5的城市
    // 那么可以写成这样: select count(*) from world.city where ID > 5;
    // 结果需要扫描4097行数据
    // 如果将条件反转，先查找ID<=5的城市数，然后用总的城市数减去就能得到同样的结果，这样扫描的行数可以减少到5行内
    // select (select count(*) from world.city) - count(*) from world.city where id <= 5;

    // 2.使用近似值
    // 有时候某些业务场景并不需要完全精确的count值，那么此时就可以使用近似值代替
}
