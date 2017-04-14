

public class ExchangeList {

	Llist l;
	public ExchangeList(){
		l = new Llist();
	}

	public boolean isEmpty(){
		return l.isEmpty();
	}
	
   public void add(Exchange e){
	   l.add(e);
   } 

   public void delete(int e){
	   l.delete(e);
  }
   public int getsize(){
	  return l.getsize();
   }
   public Exchange data(int i) throws Exception{
	  return (Exchange)(l.data(i));
   }
   public void addl(Exchange e){
      l.addl(e);}
  
  
}
	