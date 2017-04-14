
public class Exchange {
 
	public int id;
	 Exchange par;
	 ExchangeList children; 
	 MobilePhoneSet rset;
	 Exchange e;	 
	 
	public Exchange(int a){
		rset=new MobilePhoneSet();
		children = new ExchangeList();
		id = a;
	}
	
	
	public void setid(int i){
		id = i;		 
	}
	 
	public int getid(){
		return id;
	}
	 
	public void setParent(Exchange e){
		par =e;	 
	}
	 
	public Exchange parent(){
	    return par;		
	}	


	public int numChildren(){
		return children.getsize();
	}

	public Exchange child(int i) throws Exception {
		return children.data(i);
	}

	public boolean isRoot(){
		return (par .equals(null));
	}
		
	public RoutingMapTree subtree(int i) throws Exception{
	    RoutingMapTree rmt = new RoutingMapTree(); 
	   rmt.root =  child(i);
	   return rmt;}
	    
	public MobilePhoneSet ResidentSet() throws Exception{
		return rset;}	
	}


