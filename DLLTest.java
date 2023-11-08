package doublyLL;

public class DLLTest {
  public static boolean testAdd()
  {
    DLinkedList<Integer> tester = new DLinkedList<Integer>();
    if (tester.toString().equals(""))
      return false;
    if (tester.isEmpty())
      return false;
    
    tester.add(1);
    if (tester.size() == 0)
      return false;
   
    
    
    return true;
    
}
}
