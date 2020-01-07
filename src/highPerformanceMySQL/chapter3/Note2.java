package highPerformanceMySQL.chapter3;

/*
*	MySQL性能优化   学习笔记2
*	@author  zaichiyikoua
*	@time  2020年1月7日
*	@description  { 基础 }
*/

public class Note2 {
    // 查询性能低下最基本的原因是访问的数据太多。某些查询可能不可避免的需要筛选大量数据，但这并不常见
    // 大部分性能低下的查询都可以通过“减少访问的数据量”来进行优化
    // 总是很有效的两个方法：
    // 1.确认应用程序是否在检索大量超过需要的数据。这通常意味着访问了行数太多了
    // 2.确认MySQL服务器层是否在分析大量超过需要的数据行
}
