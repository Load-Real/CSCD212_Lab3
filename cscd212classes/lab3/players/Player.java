package cscd212classes.lab3.players;

import java.text.DecimalFormat;

public abstract class Player implements Cloneable {
	//Fields
	protected String name;
	protected String ssn;
	protected String position;
	protected int salary;
	
	//Constructors
	protected Player(final String name, final String ssn, final int salary, final String position) {
		//if (name == null || name.isEmpty()) throw new IllegalArgumentException("Bad Params in Player Constructor");
		//if (ssn == null || ssn.isEmpty()) throw new IllegalArgumentException("Bad Params in Player Constructor");
		//if (position == null || position.isEmpty()) throw new IllegalArgumentException("Bad Params in Player Constructor");
		if (name == null || name.isEmpty() || ssn == null || ssn.isEmpty() || position == null || position.isEmpty()) {
			throw new IllegalArgumentException("Bad Params in Player Constructor");
		}
		
		this.name = name;
		this.ssn = ssn;
		this.salary = salary;
		this.position = position;
	}
	
	@Override
	public Player clone() throws CloneNotSupportedException {
		return (Player) super.clone();
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public String getPostion() {
		return this.position;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSSN() {
		return this.ssn;
	}
	
	//What is DecimalFormat?
	@Override
	public String toString() {
		DecimalFormat fmt = new DecimalFormat("$#,###,###,###.00");
		return this.name + "\t\t" + this.ssn + "\t\t" + fmt.format(this.salary) + "\t\t" + position;
	}
}
