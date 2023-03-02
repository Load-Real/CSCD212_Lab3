package cscd212comparators.lab3;

import java.util.Comparator;
import cscd212classes.lab3.*;
//import cscd212classes.lab3.players.*;

public class TeamPayrollComparator implements Comparator<Team> {
	//Constructor
	public TeamPayrollComparator() {}
	
	//@Override <- API never asks for an one here, so I'm leaving it out for that reason
	public int compare(final Team t1, final Team t2) {
		if (t1 == null || t2 == null) throw new IllegalArgumentException("Bad Params in compare");
		
		return t1.getPayroll() - t2.getPayroll();
	}
}
