package highPerformanceMySQL.chapter3;

/*
*	MySQL性能优化   学习笔记3
*	@author  zaichiyikoua
*	@time  2020年1月7日
*	@description  { 是否向数据库请求了不需要的数据 }
*/

public class Note3 {
    // 经典案例:
    // 1.查询了不需要的记录
    // 常见的错误是误以为MySQL会只返回需要的数据，实际上MySQL会返回全部的结果在进行计算。
    // 比如说，先使用select查询大量的结果，然后获取前面的N行后关闭结果集(比如从数据中取出100条，但是只显示10条)
    // 实际上是MySQL会查询出全部的结果集，客户端的应用程序会接受全部的结果集数据，然后抛弃其中的大部分数据。
    // 这种情况下，最简单有效的办法就是加上limit

    // 2.多表关联的时候返回全部的列
    // 比如说想要查询所有电影中出现的演员，特别不好的查询如下:
    // select * from xxx.actor
    // inner join xxx.film_actor using(actor_id)
    // inner join xxx.film using(film_id)
    // where xxx.film.title = "xxx";
    // 千万不要向上面的查询这样写
    // 正确可靠的查询如下:
    // select xxx.actor.* from xxx.actor...;

    // 3.总是取出全部的列
    // 如果取出全部的列，会让优化器无法完成索引覆盖扫描这种优化，还会给服务器带来额外的I/O消耗
    // 所以很多的DBA都会禁止select *这种写法

    // 4.重复查询相同的数据
    // 举个例子，比如在用户评论的地方需要查询头像的url，那么用户多次评论的时候可能会去重复的查询这个数据
    // 解决办法就是很常见的，初次查询之后将结果缓存起来，再次查询时先去缓存中找，没有再去查询
    // 具体实际应用比如说redis???
}
