package cscd212classes.lab3.players;

public class FootballPlayer extends Player implements Cloneable {
	//Fields
	protected int td;
	protected int jerseyNumber;
	
	//Constructor
	public FootballPlayer(final String name, final String ssn, final int salary, final String position, final int td, final int jerseyNumber) {
		super(name, ssn, salary, position);
		
		if (td < 0 || jerseyNumber < 0) throw new IllegalArgumentException("Bad Params in FootballPlayer Constructor");
		
		this.td = td;
		this.jerseyNumber = jerseyNumber;
	}
	
	@Override
	public FootballPlayer clone() throws CloneNotSupportedException {
		return (FootballPlayer) super.clone();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t\t" + this.td + "\t\t" + this.jerseyNumber;
		//return name + "\t\t" + ssn + "\t\t" + salary + "\t\t" + position + "\t\t" + td + "\t\t" + jerseyNumber;
	}
}
