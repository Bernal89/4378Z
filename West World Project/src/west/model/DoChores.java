package west.model;

public class DoChores extends State<MinersSon> {
	private volatile static DoChores singleton;
	 
	   private DoChores(){}
	 
	   // synchronized keyword has been removed from here
	   public static DoChores getSingleton(){
	     // needed because once there is singleton available no need to acquire
	     // monitor again & again as it is costly
	     if(singleton==null) {
	       synchronized(DoChores.class){
	          // this is needed if two threads are waiting at the monitor at the
	          // time when singleton was getting instantiated
	          if(singleton==null)
	          singleton = new DoChores();
	       }
	    }
	   return singleton;
	  }
	   
	  public void enter(MinersSon son){
		  //if the miner is not already located at the goldmine, he must
		  //change location to the gold mine
		  if (son.getLocation() != Location.shack)
		  {
		    System.out.println(son.getName() + " AHH MAN. I hate doing Chores....");
		    son.changeLocation(Location.shack);
		  }
	  }
		  public void execute(MinersSon son){
			  //if the miner is at the goldmine he digs for gold until he
			  
			  son.increaseBored();
			  
			  System.out.println(son.getName() + " DOING CHORES SUCKS!");
			  
			  if (son.bored())
			  {
				  son.getFSM().changeState(PlayOutside.getSingleton());
			  }

			  //if enough gold mined, go and put it in the bank
	
		  }
		  public void exit(MinersSon son){
			  System.out.println(son.getName() + " leaving the house!");
		  }
}