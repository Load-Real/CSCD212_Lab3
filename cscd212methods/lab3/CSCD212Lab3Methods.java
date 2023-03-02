package cscd212methods.lab3;

import java.util.*;
import cscd212classes.lab3.*;
import cscd212classes.lab3.players.*;

/**
 * I have provided the menu method for you.  You must write the fill method. Please look at the file teamlist.txt
 * <br>
 * The file format is City\n Number of teams\n Type, Team Name\n Number of Players\n <br>
 * player name, ssn, salary, position, specific info based on type <br>
 * if football then # of touch downs, jersey number <br>
 * if baseball then batting average <br>
 * if hockey then jersey number <br>
 *
 * @NOTE All parameters passed must be final
 */
public class CSCD212Lab3Methods
{	
   /**
    * reads from the file and creates the appropriate player for the array and 
    * creates the appropriate team
    *
    * @param fin Scanner object
    * @param myTeam ArrayList of type Team
    *
    * @throws IllegalArgumentException for fin or myTeam being null
    * @throws CloneNotSupportedException to propagate the clone method
    *
    * @NOTE To add to MyArrayList it is an addLast method call myTeam.addLast(team stuff)
    */
   public static void fillArrayList(final Scanner fin, final ArrayList<Team>myTeam) throws CloneNotSupportedException
   {
	   if (fin == null || myTeam == null) throw new IllegalArgumentException("Bad Params in fillArrayList");
	   
	   while (fin.hasNextLine()) {
		   //myTeam.add(fin.next());
		   String line = fin.nextLine();
		   //Begins with city in .txt file, so this was placed at front of loop
		   String city = line.trim();
		   int numOfTeams = Integer.parseInt(fin.nextLine());
		   for (int x = 0; x < numOfTeams; x++) {
			   String innerLine = fin.nextLine();
			   String array[] = innerLine.split(", ");
			   String sport = array[0];
			   String teamName = array[1];
			   //line = fin.nextLine();
			   int numOfPlayers = Integer.parseInt(fin.nextLine());
			   Player[] playerArray = new Player[numOfPlayers];
			   for (int y = 0; y < numOfPlayers; y++) {
				   String innerInnerLine = fin.nextLine();
				   String arrayTwo[] = innerInnerLine.split(", ");
				   //If statements that check value of sport var to decide which Player type is being built
				   if (sport.equals("Football")) {
					   String name = arrayTwo[0];
					   String ss = arrayTwo[1];
					   int salary = Integer.parseInt(arrayTwo[2]);
					   String position = arrayTwo[3];
					   int td = Integer.parseInt(arrayTwo[4]);
					   int jerseyNumber = Integer.parseInt(arrayTwo[5]);
					   
					   FootballPlayer fp = new FootballPlayer(name, ss, salary, position, td, jerseyNumber);
					   playerArray[y] = fp;
					   
					   //myTeam.add(new Team(city, teamName, new Player[] {fp}));
				   }
				   if (sport.equals("Baseball")) {
					   String name = arrayTwo[0];
					   String ss = arrayTwo[1];
					   int salary = Integer.parseInt(arrayTwo[2]);
					   String position = arrayTwo[3];
					   double batAvg = Double.parseDouble(arrayTwo[4]);
					   
					   BaseballPlayer bp = new BaseballPlayer(name, ss, salary, position, batAvg);
					   playerArray[y] = bp;
					   //myTeam.add(new Team(city, teamName, new Player[] {bp}));
				   }
				   if (sport.equals("Hockey")) {
					   String name = arrayTwo[0];
					   String ss = arrayTwo[1];
					   int salary = Integer.parseInt(arrayTwo[2]);
					   String position = arrayTwo[3];
					   int jerseyNumber = Integer.parseInt(arrayTwo[4]);
					   
					   HockeyPlayer hp = new HockeyPlayer(name, ss, salary, position, jerseyNumber);
					   playerArray[y] = hp;
					   //myTeam.add(new Team(city, teamName, new Player[] {hp}));
				   }
			   }
			   myTeam.add(new Team(city, teamName, playerArray));
			   //myTeam.add(new Team(city, teamName, idk));
		   }
		   
	   }
   }// end createAndFill
   
   /**
    * The menu method ensures a valid choice is entered and returns that value
    * <br> 1 Print all Teams
    * <br> 2 Sort all Teams by city and team name
    * <br> 3 Sort all Teams by Payroll
    * <br> 4 Exit program
    *
    * @param kb Representing a valid Scanner object
    * @return int Representing the menu choice
    *
    * @throws IllegalArgumentException If Scanner is null
    */
   public static int menu(final Scanner kb)
   {
      if (kb == null)
         throw new IllegalArgumentException("Error Precond: Scanner cannot be null - menu");
         
      int choice;
      
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print all Teams");
         System.out.println("2) Sort all Teams by city and team name");
         System.out.println("3) Sort all Teams by Payroll");
         System.out.println("4) Exit program");
         System.out.print("Choice --> ");
         choice = kb.nextInt();
         kb.nextLine();
      } while (choice < 1 || choice > 4);
      
      return choice;  
   }// end menu
   
   /**
    * Method Provided by me for printing the teams -- call the toString of Team
    * @param theTeams Representing the ArrayList of Team Objects
    * @throws IllegalArgumentException if theTeams is null
    */
   public static void printTeams(final ArrayList<Team> theTeams)
   {
      if(theTeams == null)
         throw new IllegalArgumentException("Bad Params printTeams");
         
      for(Team t: theTeams)
         System.out.println(t);
 
   }// end printTeams

   
}// end class