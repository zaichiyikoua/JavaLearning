package mutiThread.exercise2.case9;

import java.util.concurrent.TimeUnit;

public class MyService {
	public MyUtil addServiceMethod(MyUtil list, String data) {
		try {
			// synchronized锁可以是任意对象
			synchronized (list) {
				if (list.getSize() < 1) {
					// 模拟数据获取
					TimeUnit.SECONDS.sleep(2);
					list.addItem(data);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
