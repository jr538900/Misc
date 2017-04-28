import java.util.Scanner;
import java.io.*;

public class FriendListDemo
{
   public static void main(String[] args) throws IOException
   {
      //Creates a new friendList used throughout the program.
      FriendList flist = new FriendList();
      //Stores the user input, and necessary files.
      int input;
      File users = new File("users.txt");
      File friends = new File("friends.txt");      
      //This will update the friendList, and if the update is successful,
      //the loop will proceed.
      
      boolean ready = flist.readFromFiles(users, friends);
      
      while(ready)
      {
         input = displayMenu();
         System.out.println();
                  
         //A series of if-else-if statements would also do the job here.
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
               quit(flist, users, friends);
               break;
         }
         
         System.out.println();
      }                                              
   }  
      
   //This displays the options for anyone using friendlist.
   public static int displayMenu()
   {
      Scanner keyboard = new Scanner(System.in);
      //choice and input store user input
      //The user has "tries" attempts left to enter input.
      //the program if the user can't enter the correct input. 
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
      
      //A while loop here would also be valid, but the loop should proceed at least once.
      do
      {
         if(tries == 1)
            System.out.println("\nLAST TRY!!\n");
         if(tries < 12)
            System.out.print("Selection (from 1 to 12): ");                    
         //choice stores the raw input, and input will be parsed from this.
         choice = keyboard.next();
         //user input error checking.           
         try
         {
            input = Integer.parseInt(choice);      
         }catch (Exception InputMismatchException)
         {
            //enables smooth iterations of subsequent loops.
            keyboard.nextLine();                    
         }
         
         tries--;
         if(tries == 0)
            System.out.println("Sorry. Out of tries.");
      //incorrect input results in the variable being -1.
      //there must be more than 0 tries left      
      }while((input<0 || input>12) && tries>0);
      
      return input;    
   }       
   
   //Selection 1:  This method prints all users of FriendList.   
   public static void printUsers(FriendList flist)
   {
      System.out.println("Users of FriendList:\n" + flist.getUsers());            
   }
   
   //Selection 2:  This method prints the number of Friendlist users. 
   public static void printNumOfUsers(FriendList flist)
   {
      System.out.println("Total users of Friendlist: " + flist.totalUsers());
   }
   
   //Selection 3:  This method prints all friends of a given Friendlist user.   
   public static void printAllUserFriends(FriendList flist)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter a user name: ");
      //The name is assumed to have no spaces in it.
      String name = keyboard.next();
      System.out.println("Friends of " + name + ":");
      //Provides the user with the input name.
      User user = flist.getUser(name);
      //If the input name is found, the user returned by 
      //the friendList LinkedList will not be null.
      if(user!=null)
         user.getFriends().enumerate();
      //Otherwise, an error message will be printed.
      else
         System.out.println("The user, " + name + " cannot be found.");      
   }
   
   //Selection 4:  This method adds a new user to FriendList.
   public static void addNewUser(FriendList flist)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter the user's name, hometown, and year of birth: ");
      //Once again, the name is assumed to have no spaces in it.
      String name = keyboard.next();
      String location = keyboard.next();
      String yob = keyboard.next();
      int yearOfBirth = -1;
      //Checks that the input year of birth is actually an integer.
      try
      {
         yearOfBirth = Integer.parseInt(yob);      
      }catch(Exception inputMismatchException)
      {
         System.out.println("Invalid input. Cannot add user.");
      }      
      //The user is added.
      if(yearOfBirth!=-1)
         flist.addUser(new User(name, location, yearOfBirth));        
   }
   
   //Selection 5:  This method removes a user from FriendList.
   public static void removeUser(FriendList flist)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter the name of the user you would like to remove: ");
      flist.removeUser(flist.getUser(keyboard.next()));
   }
   
   //Selection 6:  This method adds a friend to a user from FriendList.
   public static void addFriend(FriendList flist)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("To create a friend, you need to create two user names.");
      System.out.print("Enter the name of the first user: ");
      String name1 = keyboard.next();
      User u1 = flist.getUser(name1);
      System.out.print("Enter the name of the second user: ");
      String name2 = keyboard.next();
      User u2 = flist.getUser(name2);
      //The user at name1's index in allUsers will have name2 added as a friend,
      //if u1 is defined.
      if(u1 != null && u2 != null)
         u1.addFriend(u2);
      else 
         System.out.println("Could not add friend.  " + u1 + " or " + u2 + " is not on FriendList.");           
   }
   
   //Selection 7:  This method removes a friend from FriendList.
   public static void removeFriend(FriendList flist)   
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("In order to remove two friends, you need to enter two user names");
      System.out.print("Enter the name of the first user: ");
      User u1 = flist.getUser(keyboard.next()); 
      System.out.print("Enter the name of the second user: ");
      User u2 = flist.getUser(keyboard.next());
      u1.removeFriend(u2);      
   }
   
   //Selection 8:  This method prints the user with the most friends.
   public static void printMostFriends(FriendList flist)
   {
      User u = flist.mostFriends();
      if(u!=null)
      {
         System.out.println("The user with the most friends is " + u);
         System.out.print("Friends of " + u + ":");
         u.getFriends().enumerate();
      }   
      else
         System.out.println("There are currently no users with the most friends.");          
   }
   
   //Selection 9:  This method prints common friends between users.
   public static void findCommonFriends(FriendList flist)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter the name of the first user: ");
      User u1 = flist.getUser(keyboard.next());
      System.out.print("Enter the name of the second user: ");
      User u2 = flist.getUser(keyboard.next());
      LinkedList ll = flist.commonFriends(u1, u2);
      //Common friends between the two users exist.
      if(!ll.isEmpty())
      {
         System.out.println("Common friends between " + u1 + " and " + u2 + " are ");
         ll.enumerate();
      }   
      //There are no common friends between the two specified users.
      else if(u1 != null && u2 != null)
         System.out.println("The users " + u1 + " and " + u2 + " share no common friends.");
      //The input users are not found on LinkedList.
      else
         System.out.println("At least one of the users are not found on FriendList.");        
   }
   
   //Selection 10:  This method finds the oldest friend on FriendList for a user.
   public static void findOldestFriendForUser(FriendList flist)
   {
      User u = flist.oldestFriend();
      //The oldest friend is defined.
      if(u != null)
         System.out.println("Oldest friend on FriendList: " + flist.oldestFriend());
      //This would occur if the list of users on FriendList was empty.
      else
         System.out.println("There are no users on FriendList to compare.");   
   }
   
   //Selection 11:  This method finds the users with the oldest friend
   //and also prints the oldest friend.
   public static void findUserWithOldestFriend(FriendList flist)
   {
      //Stores the oldest friend.
      User u = flist.oldestFriend();
      //The user list is empty.
      if(u!=null)
      {
         System.out.println("User(s) have the oldest friend: ");
         u.getFriends().enumerate();
         System.out.println("Their oldest friend is " + u + " who was born in " + u.getBirthYear());
      }
      else
         System.out.println("There are no users on FriendList to compare.");   
   }
   
   //Selection 12:  This method updates the files and quits the program.
   public static void quit(FriendList flist, File users, File friends) throws IOException
   {
      //This updates the files for flist.
      flist.writeToFiles(users, friends);         
      //This quits the program.
      System.exit(0);
   }
}         