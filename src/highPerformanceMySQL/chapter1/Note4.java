package highPerformanceMySQL.chapterOne;

/*
*	MySQL性能优化   学习笔记4
*	@author  zaichiyikoua
*	@time  2020年1月1日
*	@description  { 事务之 隔离级别 }
*/

public class Note4 {
    // 在SQL标准中规定了四种隔离级别，每一种级别都规定了一个事务中所做的修改是否可见
    // 较低的隔离级别通常能执行更高的并发量，但是同样的安全性会降低
    // 所以要做选择，是要高并发还是要数据安全
    // 具体如下表：

    // ##########################################################
    // #  隔离级别  *  脏读  *  不可重复读  *  幻读  *  加锁读  #
    // ##########################################################
    // #  未提交读  #    Y   #      Y       #    Y   #    N     #
    // ##########################################################
    // #  已提交读  #    N   #      Y       #    Y   #    N     #  ***最常使用的级别***
    // ##########################################################
    // #  可重复读  #    N   #      N       #    Y   #    N     #
    // ##########################################################
    // #   序列化   #    N   #      N       #    N   #    Y     #
    // ##########################################################
}