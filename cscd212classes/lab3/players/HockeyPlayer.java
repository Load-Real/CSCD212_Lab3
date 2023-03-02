package cscd212classes.lab3.players;

public class HockeyPlayer extends Player implements Cloneable {
	//Field Detail
	protected int jerseyNumber;
	
	//Constructor
	public HockeyPlayer(final String name, final String ssn, final int salary, final String position, final int jerseyNumber) {
		super(name, ssn, salary, position);
		
		if (jerseyNumber < 0) throw new IllegalArgumentException("Bad Params in HockeyPlayer Constructor");
		
		this.jerseyNumber = jerseyNumber;
	}
	
	@Override
	public HockeyPlayer clone() throws CloneNotSupportedException {
		return (HockeyPlayer) super.clone();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t\t" + this.jerseyNumber;
		//return name + "\t\t" + ssn + "\t\t" + salary + "\t\t" + position + "\t\t" + jerseyNumber;
	}
}
