import java.util.Scanner;
import java.io.*;
public class FriendListDemo
{
   public static void main(String[] args) throws IOException
   {
      FriendList flist = new FriendList();
      int input;
      
      while(true)
      {
         input = displayMenu();
                  
         //Although a series of if-else-if statements would do the job here,
         //I thought it amusing to try a new decision structure here.      
         switch(input)
         {
            case 1:
               printUsers(flist);
               break;
            case 2:
               printNumOfUsers(flist);
               break;
            case 3:
               printAllUserFriends(flist);
               break;
            case 4:
               addNewUser(flist);
               break;
            case 5:
               removeUser(flist);
               break;
            case 6:
               addFriend(flist);
               break;
            case 7:
               removeFriend(flist);
               break;
            case 8:
               printMostFriends(flist);
               break;
            case 9:
               findCommonFriends(flist);
               break;
            case 10:
               findOldestFriendForUser(flist);
               break;
            case 11:
               findUserWithOldestFriend(flist);
               break;
            default:
               quit(flist);
               break;
         }
      }                                              
   }
   
   public static int displayMenu()
   {
      Scanner keyboard = new Scanner(System.in);
      String choice;
      int input = -1, tries = 12;
      System.out.println("Welcome to FriendList! What would you like to do (press a number)?");
      System.out.println("1. Print out all the users.");
      System.out.println("2. Print the total number of users.");
      System.out.println("3. Print out all the friends of a user.");
      System.out.println("4. Add a new user.");
      System.out.println("5. Remove a user.");
      System.out.println("6. Add a friend.");
      System.out.println("7. Remove a friend.");
      System.out.println("8. Print the user with most friends.");
      System.out.println("9. Find common friends between two friends.");
      System.out.println("10. Find the oldest friend for a user.");
      System.out.println("11. Find the user with the oldest friend on FriendList.");
      System.out.println("12. Quit.");
      System.out.print("Selection: ");
      
      //A while loop here was also considered, but I have to attempt this.
      do
      {
         if(tries == 1)
            System.out.println("\nLAST TRY!!\n");
         if(tries < 12)
            System.out.print("Selection (from 1 to 12): ");                    

         choice = keyboard.next();   
         try
         {
            input = Integer.parseInt(choice);      
         }catch (Exception InputMismatchException)
         {
            keyboard.nextLine();                    
         }
         
         tries--;
         if(tries == 0)
            System.out.println("Sorry. Out of tries.");
            
      }while((input<0 || input>12) && tries>0);
      
      return input;    
   }       
      
   public static void printUsers(FriendList flist)
   {System.out.println("ONE");}
   
   public static void printNumOfUsers(FriendList flist)
   {System.out.println("TWO");}
   
   public static void printAllUserFriends(FriendList flist)
   {System.out.println("THREE");}
   
   public static void addNewUser(FriendList flist)
   {System.out.println("FOUR");}
   
   public static void removeUser(FriendList flist)
   {System.out.println("FIVE");}
   
   public static void addFriend(FriendList flist)
   {System.out.println("SIX");}
   
   public static void removeFriend(FriendList flist)
   {System.out.println("SEVEN");}
   
   public static void printMostFriends(FriendList flist)
   {System.out.println("EIGHT");}
   
   public static void findCommonFriends(FriendList flist)
   {System.out.println("NINE");}
   
   public static void findOldestFriendForUser(FriendList flist)
   {System.out.println("TEN");}
   
   public static void findUserWithOldestFriend(FriendList flist)
   {System.out.println("ELEVEN");}
   
   public static void quit(FriendList flist)
   {System.exit(0);}
}         