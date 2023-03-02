package cscd212classes.lab3;

import cscd212interfaces.lab3.Payroll;
import cscd212interfaces.lab3.Taxable;
import cscd212classes.lab3.players.Player;
import java.util.*;
import java.text.DecimalFormat;

public class Team implements Taxable, Payroll, Comparable<Team> {
	//Fields
	protected String city;
	protected String teamName;
	protected int payroll;
	protected ArrayList<Player> players;
	
	//Constructor
	//Note: Create a new ArrayList and then clone each player before adding the player to the list
	public Team(final String city, final String teamName, final Player[] players) throws CloneNotSupportedException {
		if (city == null || city.isEmpty() || teamName == null || teamName.isEmpty() || players == null || players.length <= 0) {
			throw new IllegalArgumentException("Bad Params in Team Constructor");
		}
		
		this.city = city;
		this.teamName = teamName;
		
		this.players = new ArrayList<Player>();
		for (int x = 0; x < players.length; x++) {
			this.players.add(players[x].clone());
		}
		
		//Set after the ArrayList values are passed in from above
		this.payroll= this.calculatePayroll();
	}
	
	public String getTeamName() {
		return this.teamName;
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public String getCity() {
		return this.city;
	}
	
	
	public int getPayroll() {
		return this.payroll;
	}
	
	public double calculateTaxes() {
		double taxes = 0.0;
		for (Player p : players) {
			if (p.getSalary() > 250000) {
				taxes += p.getSalary() * BASE_TAX_RATE;
			}
			/*else {
				taxes += p.getSalary() * (BASE_TAX_RATE - .1);
			}*/
			if (p.getSalary() <= 250000) {
				taxes += p.getSalary() * (BASE_TAX_RATE - .1);
			}
		}
		return taxes; //Math.round()
	}
	//@Override
	public int calculatePayroll() {
		//sums the player salary to create the payroll by walking through the ArrayList
		//includes base_payroll from the interface
		for (Player p : players) {
			this.payroll += p.getSalary();
		}
		return this.payroll + BASE_PAYROLL;
	}
	
	@Override
	public String toString() {
			DecimalFormat fmt = new DecimalFormat("$#,###,###,###.00");
			
			String output = this.city + " - " + this.teamName + "\n" + "Payroll: " + fmt.format(this.payroll) + "\n"
			+ "Taxes: " + fmt.format(this.calculateTaxes()) + "\n"
			+ "PLAYER NAME\t\tSSN\t\tSALARY\t\tPOSITION\t\tSTATS\t\tJERSEY NUMBER" + "\n"
			+ "----------------------------------------------------------------------------" + "\n";
			
			//iterate through to do each player stats by accessing their class' toStrings
			for (Player p : players) {
				output = output + p.toString() + "\n";
			}
			output = output + "\n";
			
			return output;
	}
	
	//@Override <- API never asks for an one here, so I'm leaving it out for that reason
	public int compareTo(final Team pi) {
		if (pi == null) throw new IllegalArgumentException("Bad Params in compareTo");
		
		if (this.city.equals(pi.city)) {
			if (this.teamName.equals(pi.teamName)) {
				return 0;
			}
			else {
				return this.teamName.compareTo(pi.teamName);
			}
		}
		else {
			return this.city.compareTo(pi.city);
		}
	}
}
