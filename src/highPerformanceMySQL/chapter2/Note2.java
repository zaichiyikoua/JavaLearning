package highPerformanceMySQL.chapter2;

/*
*	MySQL性能优化   学习笔记2
*	@author  zaichiyikoua
*	@time  2020年1月6日
*	@description  { 索引的类型 }
*/

public class Note2 {
    // ********************************************************
    // 1.普通索引
    // ********************************************************
    // 是最基本的索引，它没有任何限制。它有以下几种创建方式：
    // 1.1直接创建索引
    // CREATE INDEX index_name ON table(column(length))
    // 1.2修改表结构的方式添加索引
    // ALTER TABLE table_name ADD UNIQUE indexName ON (column(length))

    // ********************************************************
    // 2.唯一索引
    // ********************************************************
    // 与前面的普通索引类似，不同的就是：索引列的值必须唯一，但允许有空值，不允许其中任何两行具有相同索引值的索引
    // 如果是组合索引，则列值的组合必须唯一。它有以下几种创建方式：
    // 2.1创建唯一索引
    // CREATE UNIQUE INDEX indexName ON table(column(length))
    // 2.2创建表的时候直接指定
//    CREATE TABLE `table` (
//            `id` int(11) NOT NULL AUTO_INCREMENT ,
//            `title` char(255) CHARACTER NOT NULL ,
//            `content` text CHARACTER NULL ,
//            `time` int(10) NULL DEFAULT NULL ,
//            UNIQUE indexName (title(length))
//        );

    // ********************************************************
    // 3.主键索引
    // ********************************************************
    // 数据库表经常有一列或列组合，其值唯一标识表中的每一行。该列称为表的主键。
    // 该索引是一种特殊的唯一索引，一个表只能有一个主键，不允许有空值。
    // 一般是在建表的时候同时创建主键索引：
//    CREATE TABLE `table` (
//            `id` int(11) NOT NULL AUTO_INCREMENT ,
//            `title` char(255) NOT NULL ,
//            PRIMARY KEY (`id`)
//        );

    // ********************************************************
    // 4.空间索引
    // ********************************************************
    // 是指依据空间对象的位置和形状或空间对象之间的某种空间关系按一定的顺序排列的一种数据结构

    // ********************************************************
    // 5.全文索引
    // ********************************************************
    // 主要用来查找文本中的关键字，而不是直接与索引中的值相比较。搜索引擎就是用的全文索引来快速查找
    // fulltext索引配合match against操作使用，而不是一般的where语句加like。
    // 在数据量较大时候，现将数据放入一个没有全局索引的表中，然后再用CREATE
    // index创建fulltext索引，要比先为一张表建立fulltext然后再将数据写入的速度快很多。
    // 5.1创建表的适合添加全文索引
//    CREATE TABLE `table` (
//            `id` int(11) NOT NULL AUTO_INCREMENT ,
//            `title` char(255) CHARACTER NOT NULL ,
//            `content` text CHARACTER NULL ,
//            `time` int(10) NULL DEFAULT NULL ,
//            PRIMARY KEY (`id`),
//            FULLTEXT (content)
//        );
    // 5.2直接创建索引
    // CREATE FULLTEXT INDEX index_content ON article(content)
}
