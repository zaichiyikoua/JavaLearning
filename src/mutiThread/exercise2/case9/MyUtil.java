package mutiThread.exercise2.case9;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {
	// 工具类
	private List<String> list = new ArrayList<String>();

	synchronized public void addItem(String data) {
		list.add(data);
	}

	synchronized public int getSize() {
		return list.size();
	}
}
