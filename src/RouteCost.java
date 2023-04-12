import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RouteCost {


  public static void main(String [] args) {
    Scanner inp = new Scanner(System.in);
    TreeSet<Link> links = new TreeSet<Link>();

    //Taking first string input
    String inputs=inp.nextLine();
    //Taking input as long as the input is not done
    while(!inputs.equals("done")){
      //Splitting the strings on the basis of white space and putting them into an array
      String[] index=inputs.split(" ");

      //If the entry is smaller than 3 entries print error message since the tokens are few
      if(index.length<3){

        System.out.println("Invalid line: " +inputs);
        //Exit the code
        System.exit(0);

      }
      //If the entry is greater than 4 entries then print error message since too many tokens
      else if (index.length>4) {
        System.out.println("Invalid line: " +inputs);
        //Exit the code
        System.exit(0);

      }
      //If the entry is within and 3 and 4 entries
      else {
        //Declaring variables
        City c1=null;
        int length=0;
        City c2=null;

        //Trying to see if the user gives any wrong input
        try {
          c1 = City.find(index[0]);
          length = Integer.parseInt(index[1]);
           c2 = City.find(index[2]);
        }
        //If the user gives any wrong input the exceptions are caught here
        catch (Exception e){
          System.out.println("Invalid line: " + inputs);
          System.exit(0);
        }
        //If the  length of the entries is 3 then initialize a LinkTwoWay objects since if the user does not describe one or two then it should be a LinkTwoWay object
        if (index.length == 3) {

            LinkTwoWay link = new LinkTwoWay(c1, c2, length);


        }
        //If the entry length is 4 then the program creates a LinkOneWay or LinkTwoWay objects if the fourth entry is one or two respectively
        else if (index.length == 4) {
          if (index[3].equals("one")) {
            LinkOneWay link = new LinkOneWay(c1, c2, length);


          } else if (index[3].equals("two")) {
            LinkTwoWay link = new LinkTwoWay(c1, c2, length);
          }
          //Else there is an error in the input and error message is printed and exits the code
          else{
            System.out.println("Invalid line: " + inputs);
            System.exit(0);
          }

        }


      }
      //Taking the input
      inputs=inp.nextLine();
    }

    //Taking Input till the input is "done"
    String input= inp.nextLine();
    while(!input.equals("done")){
      //Splitting the strings on the basis of white space and putting them into an array
      String[] index=input.split(" ");
      //If the entry size is not 2 then there is an error
      if(index.length!=2){
        System.out.println("Invalid line: "+input);
        System.exit(0);
      }
      //Else the program tries to get the links between the first city and second city which were given as inputs
      else{
       City city=City.find(index[0]);
       city.makeTree();
       if(!city.getLinksTo(City.find(index[1]),links)){
         System.out.println("Error: Route not found! " +index[0]);
         return;
       }

      }
      //Taking input again
      input=inp.nextLine();
    }
    //Printing the links and the total cost
    int total = 0;
    System.out.println("The rail network consists of:");
    for (Link l : links) {
      System.out.println("  " + l);
      total += l.getLength();
    }
    System.out.println("The total cost is: " + total);

  }
}
