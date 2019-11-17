package codingInterviewByJava;

//单链表节点类
public class ListNode {

	int value;
	ListNode nextNode;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ListNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(ListNode nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nextNode == null) ? 0 : nextNode.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListNode other = (ListNode) obj;
		if (nextNode == null) {
			if (other.nextNode != null)
				return false;
		} else if (!nextNode.equals(other.nextNode))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

}
