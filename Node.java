

public class Node {
  protected Object element;
    protected Node next;
   
   public Node(Object s,Node n){
	   element = s;
	   next = n;
   }    
	  public Object getElement()
	  {return element;}
	   public void setElement(Object newElem)
       {element = newElem; }
	  public Node getnext()
	  {return next;}
	   public void setnext(Node newNext)
	   {next = newNext;}
	     
   
}
