package west.model;

public class MinersSon extends BaseGameEntity {
	public static final int BoredLevel = 5;
	public static final int FunLevel = 5;
	private StateMachine<MinersSon> pStateMachine;
	private Location location;
	private int bored;
	private int fun;
	public MinersSon(int ID, String name){
		super(ID, name);
		location = Location.shack;
		pStateMachine = new StateMachine<MinersSon>(this);
		pStateMachine.setCurrentState(DoChores.getSingleton());
		bored = 0;
		fun = 0;
}
	public void update(){
		pStateMachine.update();
	}
	public StateMachine<MinersSon> getFSM(){return pStateMachine;}
	public Location getLocation() {return location;}
	public void changeLocation(Location loc) {location = loc;}
	public void increaseFun(){fun += 1; bored -= 1;}
	public void increaseBored(){bored += 1; fun -= 1;}


	public boolean bored() {
		if(bored >= BoredLevel){return true;}
		return false;
	}
	
	public boolean fun() {
		if(fun >= FunLevel){return true;}
		return false;
	}
}