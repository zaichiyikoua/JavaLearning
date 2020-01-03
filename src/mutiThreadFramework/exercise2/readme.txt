第二章节《并发容器》
1.非阻塞队列，就是队列中没有数据的时候，操作队列出现异常或者返回null
不具有等待/阻塞的特点
1.1 ConcurrentHashMap的使用  (1,2,3)
1.2 ConcurrentSkipListMap和ConcurrentSkipListSet  (4)
1.3 ConcurrentLinkedQueue的使用  (5)
1.4 CopyOnWriteArrayList和CopyOnWriteArraySet  (6)
2.阻塞队列，就是如果队列是空的，从队列中取东西将会被阻塞进入等待状态
直到队列中被添加了元素才会被唤醒。同样，如果队列是满的，放里面放东西会被阻塞
也被称为免锁容器
2.1 ArrayBlockingQueue  (7)
2.2 LinkedBlockingQueue  (8)