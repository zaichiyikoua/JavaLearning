package highPerformanceMySQL.chapter3;

/*
*	MySQL性能优化   学习笔记8
*	@author  zaichiyikoua
*	@time  2020年1月9日
*	@description  { 查询的基本流程 }
*/

public class Note8 {
    // 1.客户端发送一条查询给服务器
    // 2.服务器先检查缓存中有没有，如果有就返回缓存中的数据，如果没有就进行第三步
    // 3.服务器进行SQL解析，预处理啊等等，生成执行计划
    // 4.MySQL根据执行计划来调用存储引擎的API来执行查询
    // 5.返回结果给客户端
}
