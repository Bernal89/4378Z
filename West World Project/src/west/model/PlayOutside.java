package west.model;

public class PlayOutside extends State<MinersSon> {
	private volatile static PlayOutside singleton;
	 
	   private PlayOutside(){}
	 
	   // synchronized keyword has been removed from here
	   public static PlayOutside getSingleton(){
	     // needed because once there is singleton available no need to acquire
	     // monitor again & again as it is costly
	     if(singleton==null) {
	       synchronized(PlayOutside.class){
	          // this is needed if two threads are waiting at the monitor at the
	          // time when singleton was getting instantiated
	          if(singleton==null)
	          singleton = new PlayOutside();
	       }
	    }
	   return singleton;
	  }
	   
	  public void enter(MinersSon son){
		  //if the miner is not already located at the goldmine, he must
		  //change location to the gold mine
		  if (son.getLocation() != Location.backyard)
		  {
		    System.out.println(son.getName() + " LET'S PLAY SOME BALL!");
		    son.changeLocation(Location.backyard);
		  }
	  }
		  public void execute(MinersSon son){
			  
			  
			  son.increaseFun();

			  System.out.println(son.getName() + " Playin' outside!");
			  
			  if (son.fun())
			  {
				  son.getFSM().changeState(DoChores.getSingleton());
			  }
			  
		  }
		  public void exit(MinersSon son){
			  System.out.println(son.getName() + " Going back inside!");
		  }
}