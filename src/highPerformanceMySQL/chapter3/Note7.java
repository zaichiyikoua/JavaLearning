package highPerformanceMySQL.chapter3;

/*
*	MySQL性能优化   学习笔记7
*	@author  zaichiyikoua
*	@time  2020年1月9日
*	@description  { 分解关联查询 }
*/

public class Note7 {
    // 很多高性能的应用都会对关联查询进行分解。
    // 可以对每一个表进行一次单表查询，然后将结果再应用程序中进行关联

    // 举个例子:
//    select * from tag
//        join tag_post on tag_post.tag_id = tag.id
//        join post on tag_post.post_id = post_id
//    where tag.tag = 'mysql';
    // 就可以优化成下面这种
//    select * from tag where tag = 'mysql';
//    select * from tag_post where tag_id = 1234;
//    select * from post where post.id in (123,456);

    // 这样做的好处有以下优势:
    // 1.缓存的效率更高。如果是关联查询，关联中的某个表发生了变化，那么就无法使用查询缓存了，拆分之后
    // 如果某个表很少变化，那么基于表的查询就可以重复使用查询缓存
    // 2.将查询分解之后，执行单个查询可以减少锁的竞争
    // 3.更容易对数据库进行拆分，更容易做到高性能和高扩展性
    // 4.查询本身的效率会提高
    // 5.可以减少
}
