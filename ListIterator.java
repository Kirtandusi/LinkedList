package myLinkedList;

import  java.util.NoSuchElementException;

public class ListIterator<E> implements MyIterator<E> {

	private ListNode current;
	private ListNode previous;
	private LinkedList<E> myList;
	private boolean canRemove; // for remove() method. true if OK to call
								// remove()

	public ListIterator(LinkedList<E> list) {
		myList = list;
		current = null;
		previous = null;
		canRemove = false;
	}
	

	public boolean hasNext() {
		if (myList.isEmpty())
			return false;
		else if (current == null) // at beginning
			return true;
		else
			return current.getNext() != null;

	}

	public Object next() {
		if (myList.isEmpty())
			throw new NoSuchElementException("List is empty");
		if (current == null)//beginning of list
			current = myList.getFirstNode();
		else {
			previous = current;
			current = current.getNext();
		}
		if (current == null) // end of list
			throw new NoSuchElementException(("No more elements in list"));
		canRemove = true;
		// System.out.println(previous + "  " + current);
		return current.getValue();
	}
	public void add(Object o)
	{
		
		canRemove = false;
		if (current == null)
		{
			myList.addFirst(o);
			current = myList.getFirstNode();
		}
		else if (current.getNext() == null)
		{
			ListNode newNode = new ListNode(o, null);
			current.setNext(newNode);
			previous = current;
			current = newNode;
		}
		else
		{
			ListNode newNode = new ListNode(o, current.getNext());
			current.setNext(newNode);
			previous = current;
			current = newNode;
		}
		
	}
	public void remove()
	{
		if (!canRemove)
		{
			throw new IllegalStateException();
		}
		else
			canRemove = false;
		if (previous == null)
		{
			myList.removeFirst();
		}
		else
			previous.setNext(current.getNext());
		current = previous;
	}
	public void set(Object o)
	{
		if (!canRemove)
		{
			throw new IllegalStateException();
		}
		
		if (current == null)
		{
			throw new NoSuchElementException();
		}
		else
			current.setValue(o);
	}


	public static void main(String[] args) {
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
	
		System.out.println("Testing MyLinkedList Iterator");
		ListIterator<String> iter1 = (ListIterator<String>) bowl.iterator();
		int x = 1;
		while (iter1.hasNext()){
			System.out.println(x++);
		
			System.out.print(iter1.next() + " ");
}
		System.out.println();
		System.out.println("Testing add() at beginning and end and middle");
		ListIterator<String> iter2 = (ListIterator<String>) bowl.iterator();
		iter2.add("1");
		iter2.next();
		iter2.next();
		iter2.add("2");
		while (iter2.hasNext())
			iter2.next();
		iter2.add("3");
		System.out.println(bowl);
		// Testing remove() from beginning , middle, end
		System.out.println("Testing remove() from beginning, middle, end");
		ListIterator<String> iter3 = (ListIterator<String>) bowl.iterator();
		iter3.next();
		iter3.remove();
		System.out.println("from front: " + bowl);
		iter3.next();
		iter3.next();
		iter3.next();
		iter3.remove();
		System.out.println("from middle: " + bowl);
		while (iter3.hasNext())
			iter3.next();
		iter3.remove();
		System.out.println("from end: " + bowl);
		System.out.println("Testing set() from beginning, middle, end");
		ListIterator<String> iter4 = (ListIterator<String>) bowl.iterator();
		iter4.next();
		iter4.set("TWO");
		System.out.println("at front front: " + bowl);
		iter4.next();
		iter4.next();
		iter4.set("FOUR");
		iter4.next();
		System.out.println("in middle middle: " + bowl);
		while (iter4.hasNext())
			iter4.next();
		iter4.set("NINE");
		System.out.println("at end: " + bowl);

	}



}