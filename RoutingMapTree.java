

    public class RoutingMapTree {
	ExchangeList c = new ExchangeList();
	public Exchange root;
	public RoutingMapTree(){
		root= new Exchange(0);
		root.setParent(null);
	}

	
    public void setroot(Exchange e){
	root = e;
	root.setParent(null);
	root.setid(0);	
   }

    public boolean isRoot(Exchange a){
	return (root .equals(a));
   }
  
    
    public boolean check(int a) throws Exception{
	  //checks if mobile with identifier a exists
 	    for(int i=0;i<root.ResidentSet().sizeMPS();i++){
    	    if(root.ResidentSet().member(i).number()==a){
    		    return true;
		    }
	    }
	    return false;
    }  
    
   	public boolean containsnode(Exchange a) throws Exception {
	   //checks if Exchange a exists
    	boolean temp=false;
    	if(root.getid()==a.getid()){return true;}
    	else{
   			for (int i=0;i<root.children.getsize();i++){
   				temp=  root.subtree(i).containsnode(a);
   				if (temp==true)  {return temp;} 
				}
			}
		return temp;
	}
       
 	public boolean containsId(int a) throws Exception{
	   //checks if Exchange with id a exists
		boolean temp=false;
       	if(root.getid()==a){return true;}
       	else{
      		for (int i=0;i<root.children.getsize();i++){
       			temp=  root.subtree(i).containsId(a);
       			if (temp==true)  {return temp;} 
      		}
        }
    	return temp;
    }
       

   	public Exchange node(int a) throws Exception{
	   //gives the exchange with id a
	   	Exchange x = new Exchange(a);
	   	if (root.getid()==a)
	   		{return root;}
	    else{
	    	for(int i=0;i<root.numChildren();i++){
			x= root.subtree(i).node(a);
			if(x!=null)
		  		{return x;}
	   		}
	  	}   
	  	return null;
   	}
       
   	public MobilePhone exist(int a) throws Exception{
    	   //gives the mobile phone having id a
	   	for(int i=0;i<root.ResidentSet().sizeMPS();i++){
	   	if(root.ResidentSet().member(i).number()==a){
		   	return root.ResidentSet().member(i);
		   	}
 	   	}
 	    return null;
   	}
       
	public void switchOn(MobilePhone a,Exchange b)throws Exception{
		if(containsnode(b)==true){ 
		Exchange z=a.location();
		  while(z!=null){
		  z.ResidentSet().Delete(a);
		 z=z.parent();
		  }
		  a.seton();
		a.setlocation(b);
	        while(b!=null){
	        	b.ResidentSet().Insert(a);
	        	b=b.parent();        	                  	 
	         }
	     }
		else{throw new Exception("Exchange does not exist!");}
	 }
		  	
	
	
	public void addExchange(int a,int b) throws Exception{
	    Exchange e =new Exchange(b);
		if(this.containsnode(node(a))==true){		
		(node(a).children).addl(e);
		e.setParent(node(a));}
		else{
			try
		      {
			throw new Exception("Exchange does not exist!");}
		catch(Exception e1){
			System.out.println("Exchange does not exist!");
		}
	  }
	}

	
	public void switchOnMobile (int a,int b) throws Exception{
	// Switches on Mobile a at exchange b and if 'a' does not exist then creates a new mobile object.
	    if(containsId(b)==true){
		    if(check(a)==true){
			    switchOn(exist(a),node(b));
		    }
		    else{
			  MobilePhone x = new MobilePhone(a);
		        x.setlocation(node(b));
		        Exchange ex = node(b);
                   while(ex!=null){		       
		        	ex.ResidentSet().Insert(x);
		              	   ex=ex.parent();     	                  	   
		              	             
                   } 
           }
		  
		}
		else{throw new Exception ("Exchange b does not exist");} 
	}
	
	
	public void switchOffMobile(int a) throws Exception{

		if(check(a)){
			exist(a).state=false;}
		else{
			try{
				throw new Exception("Mobile phone does not exist!");}
	    	catch(Exception e){
	    		System.out.println("Mobile phone does not exist!");
	    	}
		}
	}
		
						
	public void queryNthChild (int a, int b) throws Exception{
	// gives the bth child of exchange with identifier a.
	 	System.out.println(node(a).child(b).getid());
	}

	
	public void queryMobilePhoneSet(int a) throws Exception{
	// prints all the mobile phones in the resident set of Exchange with identifier a
		if (containsId(a)){
			for(int i=0;i<node(a).ResidentSet().sizeMPS();i++){
				if(node(a).ResidentSet().member(i).status()==true){
					System.out.print(node(a).ResidentSet().member(i).number()+", ");
				}
		    }
		}
		else{
			throw new Exception("Exchange does not exist!");	
		}
		System.out.println("");
	}
	
	
	public Exchange findPhone(MobilePhone m) throws Exception{
	//gives the location of mobile phone m in the Tree
		if(root.ResidentSet().IsMember(m)==true){
			if(m.status()==true){
		    return  m.location();				
			}
			else{
				throw new Exception ("Mobile Phone Switched OFf");
			}
		}
		else throw new Exception ("Mobile Phone does not exists");
	}
	
	
	
	int x;
	public Exchange lowestRouter(Exchange a,Exchange b) throws Exception{
	// returns the common parent of Exchanges a and b.
		Exchange abc;
		boolean temp =false;
		if(a.equals(b)){return a;} 
        else{ 
        	for(int i=0;i<a.numChildren();i++){
        		temp =a.subtree(i).containsnode(b);
        		if(temp==true){return a;}
        	}
         abc=lowestRouter(a.parent(),b);
        }  return abc;
	}
	
	public ExchangeList routeCall(MobilePhone a,MobilePhone b) throws Exception{
	// return the path of the lowest Router between Mobile a and Mobile b..
		ExchangeList el1 = new ExchangeList();
		ExchangeList el2 = new ExchangeList();
		Exchange a1= a.location();
		Exchange b1 =b.location();
		while(a1!=lowestRouter(a1,b1)){
			el1.addl(a1);
			a1=a1.parent();
		}
	 	el1.add(lowestRouter(a1,b1));
	 	while(b1!=lowestRouter(a1,b1)){
			el2.add(b1);
			b1=b1.parent();}
		for(int i=0;i<el2.getsize();i++){
	 	el1.addl(el2.data(i));
		}
		return el1;
	}
	    	
		
		
	public void movePhone(MobilePhone a,Exchange b)throws Exception{
	//moves phone from its current exchange to Exchange b
		if(containsnode(b)==true){
			if(a.status()==true){
				Exchange z=a.location();
			  	while(z!=null){
				  	z.ResidentSet().Delete(a);
					z=z.parent();
			  	}
			  	a.setlocation(b);
		        while(b!=null){
		        	b.ResidentSet().Insert(a);
		        	b=b.parent();   
	   		    }
			}
			else{
				throw new Exception ("Mobile Phone is not switched on");
			}
		}
		else{
			throw new Exception("Exchange does not exist");
		}
	}
	
	
	public void performAction(String actionMessage){
	
		String s = "";
		switch(actionMessage.substring(0,8)){
			case "addExcha":
			int x =12;
			while(actionMessage.charAt(x)!=' '){
					s = s + actionMessage.charAt(x);
					x++;
			}
		
			try {
				this.addExchange(Integer.parseInt(s),Integer.parseInt(actionMessage.substring(x+1,actionMessage.length())));
			}
			catch (Exception e1) {
				System.out.println("Error");
			}
	 break;
			
			case "switchOn":
			   int b =15;
			while(actionMessage.charAt(b)!=' '){
			s = s + actionMessage.charAt(b);
			b++;
			}
			try {
				this.switchOnMobile(Integer.parseInt(s),Integer.parseInt(actionMessage.substring(b+1,actionMessage.length())));
			} 
			catch (Exception e) {
				System.out.println("Error");
			}
		 break;	
		
		case "switchOf":			
			try {
				this.switchOffMobile(Integer.parseInt(actionMessage.substring(16,actionMessage.length())));
			} 
			catch (Exception e) {
				System.out.println("Error");
			}
	   break;
		
		case "queryNth":
			int d =14;
			while(actionMessage.charAt(d)!=' '){
				s = s + actionMessage.charAt(d);
				d++;
		}
			try {
				this.queryNthChild(Integer.parseInt(s),Integer.parseInt(actionMessage.substring(d+1,actionMessage.length())));
			} 
			catch (Exception e) {
				System.out.println("Error");
			}
	   break;
			
		case "queryMob":
			try {
				this.queryMobilePhoneSet(Integer.parseInt(actionMessage.substring(20,actionMessage.length())));
			} 
			catch (Exception e) {
				System.out.println("Error");
			}
       break;
		
		case "findPhon":
			try {
				Exchange xyz= findPhone(exist(Integer.parseInt(actionMessage.substring(10,actionMessage.length()))));
				System.out.println(xyz.getid());
			} 
			catch (Exception e3) {
				System.out.println("Error");
			}
		   break;
		   
		   
		case "lowestRo":
			//System.out.println("i");
			int l =13;
			while(actionMessage.charAt(l)!=' '){
				s = s + actionMessage.charAt(l);
				l++;
			}			
			try {
				Exchange xy=lowestRouter(node(Integer.parseInt(s)),node(Integer.parseInt(actionMessage.substring(l+1,actionMessage.length()))));
			System.out.println(xy.getid());
			} 
			catch (Exception e2) {
				System.out.println("Error");
			}
			break;
			
			
		case "routeCal":
			int r =10;
			while(actionMessage.charAt(r)!=' '){
				s = s + actionMessage.charAt(r);
				r++;
			}			
			try {
				ExchangeList x1=this.routeCall(exist(Integer.parseInt(s)),exist(Integer.parseInt(actionMessage.substring(r+1,actionMessage.length()))));
				//System.out.println(x1);
			} 
			catch (Exception e1) {
				System.out.println("Error");
			}
			break;
			
		case "movePhon":
			int m =9;
			while(actionMessage.charAt(m)!=' '){
				s = s + actionMessage.charAt(m);
				m++;
			}	
			try {
				this.movePhone(exist(Integer.parseInt(s)),node(Integer.parseInt(actionMessage.substring(m+1,actionMessage.length()))));
			} 
			catch (Exception e) {
				System.out.println("Error");
			}
			break;
		}	
	}
	
	
}	
	

