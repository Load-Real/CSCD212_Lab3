package cscd212lab3;

import java.io.*;
import java.util.*;
import cscd212utils.fileutils.*;
import cscd212classes.lab3.*;
import cscd212methods.lab3.*;
import cscd212interfaces.lab3.*;
import cscd212comparators.lab3.*;

/**
 * The class that tests all the code for this lab.
 *
 * @NOTE All Parameters will be passed as final and all preconditons will be enforced
 * <br>@NOTE If a precondition is not met then the message will be "Bad Params in MethodName"
 * <br>@NOTE MethodName will be replaced with the actual method name
 */
public class CSCD212Lab3
{
   public static void main(String [] args)throws Exception
   {
      File inf = null;
      int choice;
      ArrayList<Team> theTeams = new ArrayList<Team>();
      Scanner fin = null, kb = new Scanner(System.in);
      
      inf = FileUtils.openInputFile(kb);
      fin = new Scanner(inf);
      CSCD212Lab3Methods.fillArrayList(fin, theTeams);
      System.out.println("The number of teams is: " + theTeams.size());
      System.out.println();
      fin.close();
      
      do
      {
          choice = CSCD212Lab3Methods.menu(kb);
          switch(choice)
          {
            case 1:  System.out.println();
                     CSCD212Lab3Methods.printTeams(theTeams);
            		   break;
                     
            case 2:  Collections.sort(theTeams);
                     System.out.println();
            		   CSCD212Lab3Methods.printTeams(theTeams);
                     break;
                     
            case 3:  Collections.sort(theTeams, new TeamPayrollComparator());
                     System.out.println();
            		   CSCD212Lab3Methods.printTeams(theTeams);
                     break;
                     
            default: System.out.println("Exiting");
                     
          }// end switch
          
      }while(choice != 4); 
      
      kb.close();

   }// end main
   
}// end class