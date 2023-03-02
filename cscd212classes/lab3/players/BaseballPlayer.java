package cscd212classes.lab3.players;

public class BaseballPlayer extends Player implements Cloneable {
	//Fields
	protected double batAvg;
	
	public BaseballPlayer(final String name, final String ssn, final int salary, final String position, final double batAvg) {
		super(name, ssn, salary, position);
		
		if (batAvg < 0) throw new IllegalArgumentException("Bad Params in BaseballPlayer Constructor");
		
		this.batAvg = batAvg;
	}
	
	@Override
	public BaseballPlayer clone() throws CloneNotSupportedException {
		//How to call the clone() from Player?
		return (BaseballPlayer) super.clone();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t\t" + this.batAvg;
		//return this.name + "\t\t" + this.ssn + "\t\t" + this.salary + "\t\t" + this.position + "\t\t" + this.batAvg; //call parent toString() append batAvg
	}
}
