package interview;

/*
 *	javaSE专项练习24
*	@author  zaichiyikoua
*	@time  2019年12月27日
*/

public class Coding24 {
	// list是一个ArrayList的对象，哪个选项的代码填到todo delete处，
	// 可以在Iterator遍历的过程中正确并安全的删除一个list中保存的对象？( )

//	Iterator it = list.iterator();
//	int index = 0;
//	while (it.hasNext())
//	{
//	    Object obj = it.next();
//	    if (needDelete(obj))  //needDelete返回boolean，决定是否要删除
//	    {
//	        //todo delete
//	    }
//	    index ++;
//	}

	// A.it.remove();
	// B.list.remove(obj);
	// C.list.remove(index);
	// D.list.remove(obj,index);

	
//	答案：A
//	如果在循环的过程中调用集合的remove()方法，就会导致循环出错，例如：
//	for(int i=0;i<list.size();i++){
//	    list.remove(...);
//	}
//	循环过程中list.size()的大小变化了，就导致了错误。
//	所以，如果你想在循环语句中删除集合中的某个元素，就要用迭代器iterator的remove()方法，
//	因为它的remove()方法不仅会删除元素，还会维护一个标志，用来记录目前是不是可删除状态，
//	例如，你不能连续两次调用它的remove()方法，调用之前至少有一次next()方法的调用。
}
