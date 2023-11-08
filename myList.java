package doublyLL;

	public interface myList<E> {
		 public boolean add(Object o);
		 public void addLast(Object o);
		 public void addFirst(Object o);
		 public void clear();
		 public Object getFirst();
		 public Object getLast();
		 public Object removeFirst ();
		 public Object removeLast ();
		 public String toString();
		 public int size();
		 public boolean isEmpty();
		 public boolean remove(Object o);
		}