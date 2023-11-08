package doublyLL;
import java.util.NoSuchElementException;

import myLinkedList.ListNode;


public class DLinkedList<E> implements myList<E>{
	private DListNode firstNode;
	private DListNode lastNode;
	
	
	//constructs an empty list
	public DLinkedList()
	{
	firstNode = null;
	lastNode = null;
	}
	
	public void addFirst(Object o)
	{
		if (firstNode == null)
		{
			firstNode = new DListNode(o, null, null);
			lastNode = firstNode;
		}
		//create the new node
		//set the previous link of firstNode to new node
		//rename firstNode
		else
		{
			DListNode temp = new DListNode(o, firstNode, null);
			firstNode.setPrevious(temp);
			firstNode = temp;
		}
	}


	@Override
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		DListNode end = new DListNode(o, null, lastNode);
		if (isEmpty())
		{
			addFirst(end);
		}
		else
		{
			lastNode.setNext(end);
			lastNode = end;		
		}
		return true;
		
	}

	@Override
	//not working
	public void addLast(Object o) {
		DListNode end = new DListNode(o, null, lastNode);
		// TODO Auto-generated method stub
		if (isEmpty())
		{
			addFirst(end);
		}
		else
		{
			lastNode.setNext(end);
			lastNode = end;			
//			end = lastNode;
		}
	}

	@Override
	
	public void clear() {
		// TODO Auto-generated method stub
		firstNode = lastNode = null;
		
	}

	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		return firstNode;
	}

	@Override
	public Object getLast() {
		// TODO Auto-generated method stub
		return lastNode;
	}

	@Override
	public Object removeFirst() {
		// TODO Auto-generated method stub
		if (isEmpty())
		{
			throw new NoSuchElementException("Can't remove from an empty list");
		}
		DListNode temp = firstNode;
		firstNode = firstNode.getNext();
		firstNode.setPrevious(null);
		return temp;
	}

	@Override
	public Object removeLast() {
		// TODO Auto-generated method stub
		if (isEmpty())
		{
			throw new NoSuchElementException("Can't remove from an empty list");
		}
		else if (firstNode == lastNode)
		{
			Object item = firstNode.getValue();
			firstNode = lastNode = null;
			return item;
		}
		else
		{
			DListNode temp = lastNode;
			lastNode = lastNode.getPrevious();
			lastNode.setNext(null);
			return temp.getValue();
		}
	}
	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		DListNode current = firstNode;
		DListNode follow = null;
		if (isEmpty())
			throw new NoSuchElementException("Cant remove from empty list");
		
		if (firstNode.getValue() == o)
		{
			removeFirst();
			return true;
		}		
		if (lastNode.getValue() == o)
		{
			removeLast();
			return true;
		}
		while (current.getValue() != o)
		{
			follow = current;
			current = current.getNext();
			current.setPrevious(follow);
			if (current.getNext() == null)
			{
				return false;
			}
		}
		
		follow.setNext(current.getNext());
		current.setNext(null);
		return true;
	}
	private void printBackwards()
	{
		DListNode current = lastNode;
		System.out.print("Backwards: [");
		while (current != null)
		{
			
			System.out.print(current);
			if (current != firstNode)
			{
				System.out.print(", ");
			}
			current = current.getPrevious();
		}
		System.out.println("]");
		System.out.println();
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		DListNode current = firstNode;
		int counter = 0;
		while (current != null)
		{
			counter++;
			current = current.getNext();
		}
		return counter;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (firstNode == null && lastNode == null)
		{
			return true;
		}
		return false;
	}

	
	public String toString()
	{
		
		String s = "[";
		DListNode current = firstNode;
		while (current != null)
		{
			
			if (current != firstNode)
			{
				s += " ";
			}
			
			s+=current.getValue();
			if (current != getLast())
			{
				s += ", ";
			}
			current = current.getNext();
		}
		return s + "]";
	}
	public static void main(String[] args) {
		DLinkedList<String> bowl = new DLinkedList<String>();
//		System.out.println(bowl.remove("banana"));
		bowl.addFirst("three");
		bowl.addLast("four");
		bowl.addLast("five");
		bowl.addLast("six");
		bowl.addLast("seven");
		bowl.addLast("eight");
		bowl.add("nine");
		bowl.add("ten");
		bowl.addFirst("two");
		bowl.addFirst("one");
		System.out.println(bowl);
		bowl.printBackwards();
		System.out.println();
		System.out.println("Testing removeFirst() and removeLast() methods");
		System.out.println("First? " + bowl.removeFirst());
		System.out.println("Last? " + bowl.removeLast());
		System.out.println(bowl);
		bowl.printBackwards();
		System.out.println ("Testing remove object");
		System.out.println("two? " + bowl.remove("two"));
		System.out.println("nine? " +  bowl.remove("nine"));
		System.out.println("five? " + bowl.remove("five"));
		System.out.println("eleven? " +bowl.remove("eleven"));
		System.out.println(bowl);
		System.out.println("Testing size()");
		System.out.println(bowl.size());
		bowl.printBackwards();
		
	}
	

}
