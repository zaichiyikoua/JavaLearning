package mutiThread.exercise3.case1;

import java.util.ArrayList;
import java.util.List;

public class Service {

	// 线程可见
	volatile private List<String> list = new ArrayList<String>();

	public void add() {
		list.add("****");
	}

	public int size() {
		return list.size();
	}
}
