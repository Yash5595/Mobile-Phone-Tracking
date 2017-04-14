
class Llist
{
    protected Node head;
    protected Node end ;
    public int size ;
    
    /*  Constructor  */
    public Llist()
    {
        head = null;
        end = null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return head == null;
    }
    /*  Function to get size of list  */
    public int getsize()
    {
        return size;
    }
    /*  Function to insert an element at begining  */
    public void add(Object val)
    {
        Node nptr = new Node(val, null);
        size++ ;
        if(head == null)
        {
            head = nptr;
            end = head;
        }
        else
        {
            nptr.setnext(head);
            head = nptr;
        }
    }
    /*  Function to insert an element at end  */
    public void addl(Object val)
    {
        Node nptr = new Node(val,null);
        size++ ;
        if(head == null)
        {
            head = nptr;
            end = head;
        }
        else
        {
            end.setnext(nptr);
            end = nptr;
        }
    }
    /*  Function to insert an element at position  */
    public void insertAtPos(Object val , int pos)
    {
        Node nptr = new Node(val, null);
        Node ptr = head;
        if(pos==0)
            add (val);
        else if(pos == size)
           addl(val);
        else
        {
            pos=pos-1;
            for (int i = 0; i < size-1; i++)
            {
                if (i == pos)
                {
                    Node tmp = ptr.getnext() ;
                    ptr.setnext(nptr);
                    nptr.setnext(tmp);
                    break;
                }
                ptr = ptr.getnext();
            }
            size++ ;
        }
    }
    /*  Function to delete an element at position  */
    public void delete(int pos)
    {
        if (pos == 0)
        {
            head = head.getnext();
            size--;
            return ;
        }
        if (pos == size-1)
        {
            Node s = head;
            Node t = head;
            while (s != end)
            {
                t = s;
                s = s.getnext();
            }
            end = t;
            end.setnext(null);
            size --;
            return;
        }
        Node ptr = head;
        pos = pos - 1 ;
        for (int i = 0; i < size - 2; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getnext();
                tmp = tmp.getnext();
                ptr.setnext(tmp);
                break;
            }
            ptr = ptr.getnext();
        }
        size-- ;
    }
    
	 public Object data(int i) throws Exception{
		if(getsize()<=i){throw new Exception ("number of children is less than asked");}
		else{
			Node x =head;
			int c=0;
			while(c<i){
				x=x.getnext();
				c++;
			}
			return x.getElement();
		}
		
}

    /*  Function to display elements  */
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0)
        {
            System.out.print("empty\n");
            return;
        }
        if (head.getnext() == null)
        {
            System.out.println(head.getElement() );
            return;
        }
        Node ptr = head;
        System.out.print(head.getElement()+ "->");
        ptr = head.getnext();
        while (ptr.getnext() != null)
        {
            System.out.print(ptr.getElement()+ "->");
            ptr = ptr.getnext();
        }
        System.out.print(ptr.getElement()+ "\n");
    }
}


 