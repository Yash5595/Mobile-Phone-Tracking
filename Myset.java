
public class Myset {
   
	Llist l;
	public Myset(){
		l= new Llist();
	}
	
	public Object member(int a) throws Exception{
   	 Node x =l.head;
		if(a>=l.getsize()){
   	 throw new Exception("Index Out of Bound");}
   	 else{
   		 int i=0;
   		while(i<a){
   			x=x.getnext();
   			i++;
   		}
   		 }
   	   return (x.getElement());    
    }
	
	public int sizeM(){
		return l.getsize();}
	
	public boolean IsEmpty(){
		return (l.getsize()==0);
				}
		
	public boolean IsMember(Object o){
		Node h = l.head;
		for(int i=0;i<l.getsize();i++){
		  if(h.getElement().equals(o)){return true;}
		  else{
			  h=h.getnext();
			}}
		  return false;		
	}
	
     public void Insert(Object o){
    	Node v = new Node(o,l.head);
    	if(l.head==null){
    		l.head=v;
    		l.size++;
    	}
    	else{v.setnext(l.head);
    	l.head=v;
    	l.size++;
    	}
	  }
     
     public void Delete(Object o) {
         if(IsMember(o)==false)
         {
        	 try{
        		 throw new IllegalStateException("Object not found");}
         catch(IllegalStateException e){
        	 System.out.println("Object not found");
         }}
           int x=0;
           Node n = l.head;
           for(int i=0;i<(l.getsize()-1);i++){
        	   if(n.getElement().equals(o)){
        		    x=i;
        	   break;
        	   }
        	   n=n.getnext();
           }
           l.delete(x);
      }
         	           
     public Myset Union (Myset a) throws Exception{	
    	  	 Myset m = new Myset();   	
             for(int i=0;i<a.sizeM();i++){
            	m.Insert(a.member(i)); 
             }if(l==null){
            	 return a;}
             while(l.head!=null){
        	 if(m.IsMember(l.head.getElement())==false){
             	m.Insert(l.head.getElement());
             	l.head=l.head.getnext();}
             else{l.head=l.head.getnext();}}
             	return m;}
    	 
     public Myset Intersection (Myset a){
         	 Myset m = new Myset();
        for(int i=0;i<l.getsize();i++){
        		if(a.IsMember(l.head.getElement())==true){
        	m.Insert(l.head.getElement());
           l.head=l.head.getnext();  
         } 
        		else{l.head=l.head.getnext();}	
      }  
         return m;
         }      

     
}
    	 
       
     


	
