package doublyLL;
/**
 * Write a description of class ListNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DListNode
{
    // instance variables - replace the example below with your own
    private Object value;
    private DListNode next;
    private DListNode previous;

    /**
     * Constructor for objects of class ListNode
     */
    public DListNode(Object initValue, DListNode initNext, DListNode initPrev)
    {
        value= initValue;
        next = initNext; 
        previous = initPrev;
    }


    public Object getValue()
    { 
        return value;
    }
    
    public DListNode getNext()
    {
        return next;
    }
    public DListNode getPrevious()
    {
        return previous;
    }
    public void setValue( Object theNewValue)
    {
        value=theNewValue;
    }
    
    public void setNext( DListNode theNewNext)
    {
       next=theNewNext;
    } 
    
    public void setPrevious( DListNode theNewPrev)
    {
      previous = theNewPrev;
    } 
    public String toString()
    {
    	return "" + value ;
    }
    public String toString2()
    {
    	if (previous == null || next == null )
    		return "" + value;
    		
    	return "," +previous.getValue() + " <-" +  
    				value  + " ->" + next.getValue();
    }
}