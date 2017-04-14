
public class MobilePhone {
	public int iden;
    public boolean state;
	public Exchange loc;
	
	public MobilePhone(int a){
    	iden = a;
    	state = true;}	

    public int number(){
    	return iden;}
    
    public boolean status(){
    	return state;}
    
       
    public void seton(){
    	state=true;}  
    
    public boolean eq(MobilePhone b){
    	return (b.number()==iden);
    }
    
    
    public void setoff(){
        state= false;}
    
    public Exchange location(){
    	if(state==false){
    		{
    	   	try{
    	   		throw new Exception ("Switched Off");}
            catch(Exception e){
            	System.out.println("Switched Off");
            	return null;
    }
       }
    	  }
    	else{return loc;}
    }
    public void setlocation(Exchange a){
    	a = loc;}
 

	}

