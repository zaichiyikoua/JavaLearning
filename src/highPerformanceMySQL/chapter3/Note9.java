package highPerformanceMySQL.chapter3;

/*
*	MySQL性能优化   学习笔记9
*	@author  zaichiyikoua
*	@time  2020年1月10日
*	@description  { MySQL是如何执行关联查询的 }
*/

public class Note9 {
    // MySQL中的“关联”，MySQL认为每一次查询都是一次关联，并不是一个查询需要两张表的匹配才叫关联
    // 在MySQL中，每一次的查询，每一个片段都是关联

    // 举个例子，对于union查询，MySQL会把一系列的查询结果放在一张临时表中，然后在重新读出临时表中的内容来完成union查询
    // 关联执行的策略很简单:对于任何关联都执行嵌套循环关联操作
    // 简单点说，就是现在一张表中循环出单条数据，然后再嵌套循环到下一个表中寻找匹配的行，依次下去，直到找到所有表中匹配的行为止
    // 然后根据各个表匹配的行，返回查询中需要的各个列
}
