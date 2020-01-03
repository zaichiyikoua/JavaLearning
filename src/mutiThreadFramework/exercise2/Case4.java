package mutiThreadFramework.exercise2;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题4
*	@author  zaichiyikoua
*	@time  2020年1月3日
*	@description  { ConcurrentSkipListMap() }
*/

public class Case4 {
    // ConcurrentHashMap缺点是不支持排序，如果使用LinkedHashMap，又不支持并发
    // 所以如果出现这种又要支持并发，又要支持排序的要求，就可以使用ConcurrentSkipListMap
    // ***********************************************
    // 如果还想要去重，可以使用ConcurrentSkipListSet，用法是一样的，这里就不再重复练习了
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyService service = new MyService();

        Runnable runnable = new Runnable() {
            @SuppressWarnings("rawtypes")
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    while (!service.map.isEmpty()) {
                        Entry entry = service.map.pollFirstEntry();
                        UserInfo userInfo = (UserInfo) entry.getKey();
                        System.out.println(userInfo.getId() + " " + userInfo.getUserName() + " " + entry.getValue());
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread.start();
        thread2.start();

        // 有序，又支持并发的集合容器
//        1 userName1 value1
//        2 userName2 value2
//        4 userName4 value4
//        3 userName3 value3
//        5 userName5 value5
    }

}

//用户类
class UserInfo implements Comparable<UserInfo> {
    private int id;
    private String userName;

    public UserInfo() {
        super();
    }

    public UserInfo(int id, String userName) {
        super();
        this.id = id;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int compareTo(UserInfo o) {
        // TODO Auto-generated method stub
        if (this.getId() < o.getId()) {
            return -1;
        }
        if (this.getId() > o.getId()) {
            return 1;
        }
        return 0;
    }
}

//服务类
class MyService {
    @SuppressWarnings("rawtypes")
    public ConcurrentSkipListMap map = new ConcurrentSkipListMap();

    @SuppressWarnings("unchecked")
    public MyService() {
        UserInfo userInfo = new UserInfo(1, "userName1");
        UserInfo userInfo3 = new UserInfo(3, "userName3");
        UserInfo userInfo5 = new UserInfo(5, "userName5");
        UserInfo userInfo4 = new UserInfo(4, "userName4");
        UserInfo userInfo2 = new UserInfo(2, "userName2");
        map.put(userInfo, "value1");
        map.put(userInfo3, "value3");
        map.put(userInfo5, "value5");
        map.put(userInfo4, "value4");
        map.put(userInfo2, "value2");
    }

}