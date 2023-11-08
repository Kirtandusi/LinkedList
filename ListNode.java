package myLinkedList;

public class ListNode {
	private Object value;
	private ListNode next;
	
	public ListNode(Object initValue, ListNode initNext)
	{
		value = initValue;
		next = initNext;
	}
	public Object getValue()
	{
		return value;
	}
	public ListNode getNext()
	{
		return next;
	}
	public void setValue(Object newValue)
	{
		value = newValue;
	}
	public void setNext(ListNode newNext)
	{
		next = newNext;
	}
	public String toString()
	{
		return value + " ";
	}
	
}
