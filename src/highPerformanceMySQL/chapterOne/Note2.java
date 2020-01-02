package highPerformanceMySQL.chapterOne;

/*
*	MySQL性能优化   学习笔记2
*	@author  zaichiyikoua
*	@time  2020年1月1日
*	@description  { 并发控制之 锁粒度 }
*/

public class Note2 {
    // 一种能提高共享资源并发性的方式就是让锁定对象更加有选择性
    // 就像是Java中使用同步代码块的时候，尽量在关键的地方使用而不是全部都锁定
    // 在给定的资源上，锁定的数据量越少，系统的并发程度越高

    // 加锁是需要消耗性能的，以性能为代价来保证数据的安全
    // 如果数据库花费大量的时间来管理锁，而不是存取数据，那么系统的性能可能会受到影响

    // MySQL提供了多种选择，不同的引擎都可以实现自己的锁策略和锁粒度
    // 比较重要的两种锁策略如下

    // ********************************************************
    // 1.表锁(table lock)
    // ********************************************************
    // 这是MySQL中最基本的锁策略，并且是"开支最小"的策略
    // 它会锁定整张表，一个用户在对表进行"写"操作的时候(插入，修改，删除)前，需要先获得锁
    // 这会阻塞其他用户对该表进行所有的读写操作。只有在没有写锁的时候，其他用户才能获得读锁
    // 读锁是不会阻塞的
    // *********************************************************

    // ********************************************************
    // 2.行级锁(row lock)
    // ********************************************************
    // 这是可以最大程度的支持并发处理的锁(同样也是最大的开销)
    // 行级锁只在存储引擎层实现，在服务层没有实现
}