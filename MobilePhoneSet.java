


public class MobilePhoneSet {
	
	Myset m;
	public MobilePhoneSet(){
		m= new Myset();}

	public MobilePhone member(int a) throws Exception{
		return (MobilePhone)(m.member(a));
	}
	
	public int sizeMPS(){
		return m.sizeM();
	}  	

	public boolean IsEmpty(){
		return (m.IsEmpty());
	}


	public boolean IsMember(MobilePhone o){
		Node h = m.l.head;
		for(int i=0;i<m.l.getsize();i++){
		  if(((MobilePhone)(h.getElement())).eq(o)){return true;}
		  else{
			  h=h.getnext();
			}}
		  return false;}	

	public void Insert(MobilePhone o){
		m.Insert(o);}

	public void Delete(MobilePhone o)  {
		 m.Delete(o);
	}
		
		
	 public MobilePhoneSet Union (MobilePhoneSet a) throws Exception {	
		 MobilePhoneSet n = new MobilePhoneSet();   	
	       n.m=m.Union(a.m);
	       return n;}

	public MobilePhoneSet Intersection(MobilePhoneSet a){
		MobilePhoneSet n = new MobilePhoneSet();
	    n.m=m.Intersection(a.m);
	    return n;}


	 
}
			
		
