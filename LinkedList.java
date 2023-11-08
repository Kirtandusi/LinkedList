package myLinkedList;

import java.util.NoSuchElementException;

public class LinkedList<E> implements MyList<E>{
	private ListNode firstNode;

	public LinkedList()
	{
		firstNode = null;

	}
	public ListIterator<E> iterator()
	{
		return new ListIterator<E>(this);
	}
	public void addFirst(Object o)
	{
		firstNode = new ListNode(o, firstNode); //points to previous firstNode
	}

	public void addLast(Object o)
	{
		if (isEmpty())
		{
			firstNode = new ListNode(o, null);
		}
		else
		{
			ListNode current = firstNode;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(new ListNode(o, null));
		}
	}
	public boolean add(Object o)
	{
		addLast(o);
		return true;
	}

	public void clear()
	{
		firstNode = null;
	}
	public Object getFirst()
	{
		return firstNode;
	}
	public Object getLast()
	{
		ListNode current = firstNode;
		while (current.getNext() != null)
		{
			current = current.getNext();
		}
		return current;
	}
	public Object removeFirst()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException("cannot remove from an empty list");
		}
		Object returning = firstNode;
		//set second element to be the first
		firstNode = firstNode.getNext(); 
		return returning;
	}
	public Object removeLast()
	{
		//point second to last element to null
		if (isEmpty())
		{
			throw new NoSuchElementException("cannot remove from an empty list");
		}
		ListNode current = firstNode;
		ListNode follow = null;
		while (current.getNext() != null)
		{
			follow = current;
			current = current.getNext();
		}
		if (follow == null)
			firstNode = null;
		else
			follow.setNext(null);
		
		
		return current.getValue();
	}
	public int size()
	{
		int counter = 0;
		ListNode current = firstNode;
		
		while (current != null)
		{
			current = current.getNext();
			counter++;
			
		}
		return counter;
	}
	public ListNode getFirstNode()
	{
		return firstNode;
	}
	public boolean isEmpty()
	{
		if (firstNode == null)
			return true;
		return false;
	}
	public boolean remove(Object o)
	{
		ListNode current = firstNode;
		ListNode follow = null;
		
		if (isEmpty())
			throw new NoSuchElementException("Cant remove from empty list");
		
		if (firstNode.getValue() == o)
		{
			removeFirst();
			return true;
		}		
		if (getLast() == o)
		{
			removeLast();
			return true;
		}
			
		while (current.getNext() != null)
		{
			if (current.getValue() == o)
			{
				follow.setNext(current.getNext());
				return true;
			}
			follow = current;
			current = current.getNext();
			
			
		}
		if (current.getNext() == o)
		{
			follow.setNext(null);
			return true;
		}
		return false;
		
		
//		1-2-3-4
//		remove by the object
//		return true/false
//		keep track
//		1.setNext(2)
//		follow is the one behind the value that you want
//		follow.setNext(current.getNext()); //skips over the value

		
	}
	public String toString()
	{
		
		String s = "[";
		ListNode current = firstNode;
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
	public static void main(String args[])
	{
		LinkedList<String> bowl = new LinkedList<String>();

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

		System.out.println("Testing addFirst(),addLast() methods");
		System.out.println(bowl);
		System.out.println();
		System.out.println("Testing removeFirst() and removeLast() methods");
		System.out.println("First? " + bowl.removeFirst());
		System.out.println("Last? " + bowl.removeLast());
		System.out.println(bowl);
		System.out.println ("Testing remove object");
		System.out.println("two? " + bowl.remove("two"));
		System.out.println("nine? " +  bowl.remove("nine"));
		System.out.println("five? " + bowl.remove("five"));
		System.out.println("eleven? " +bowl.remove("eleven"));
		System.out.println(bowl);
		System.out.println("Testing size()");
		System.out.println(bowl.size());


		
		
////		
	}
	
}
