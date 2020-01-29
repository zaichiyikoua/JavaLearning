package mutiThreadFramework.exercise3;

/*
*	多线程API和框架   练习题5
*	@author  zaichiyikoua
*	@time  2020年1月29日
*	@description  { ThreadPoolExecutor的使用之 构造方法参数详解 }
*/

public class Case5 {
    // 虽然使用工厂可以快速方便的去创建线程对象，不需要程序员设计大量的new实例化Thread相关的代码
    // 但是，在阿里的代码规范中严格声明
    // 第一条.所有的线程资源必须由线程池提供，不允许在应用中自行显示创建线程
    // 第二条.线程池不允许使用Executor去创建，而是通过ThreadPoolExecutor的方式
    // 这样的方式让写的同学更加明确线程池的运行规则，避免资源耗尽的风险

//        new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)
    // 这是最常用的构造方法⬆
    // 参数详解如下:
    // corePoolSize:线程池中保存的线程数，包括空闲线程，也就是核心池的大小
    // maximumPoolSize:池中允许的最大线程数
    // KeepAliveTime:当线程数量大于corePoolSize的时候，在没有超过指定时间内是不从线程池中将空闲线程删除，超过则删除
    // unit:keepAliveTime的时间单位
    // workQueue:执行前用于保持任务的队列。此队列仅保持execute方法提交的Runnable任务
}
