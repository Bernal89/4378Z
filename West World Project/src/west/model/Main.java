package west.model;


public class Main {
	public static void main(String[] args) {
		Miner miner = new Miner(458, "Bob");
		MinersWife wife = new MinersWife(82, "Elsa");
		MinersSon son = new MinersSon(50, "Billy");
		try {
			for(int i=0; i<40; ++i){
				miner.update();
				wife.update();
				son.update();
				Thread.sleep(800);
			}
			// System.err.println is used only so that the text is red
			System.err.println(miner.getName() + ", " + wife.getName() + " and their son " + son.getName() + " have stopped");
		}
		catch(InterruptedException ex){System.out.println("Main thread interrupted");}
	}
}
