//Imports calendar class to determine current instance of time
//this is needed for the addUser method to ensure the user is the right age.
import java.util.Calendar;
import java.util.Scanner;
import java.io.*;
public class FriendList
{
   private LinkedList allUsers;
   
	//no args constructor creates a new empty	list   
   public FriendList()
   {
      allUsers = new LinkedList();
   }
   
	//adds a user after checking that they are at least 13 years old and do not already exist   
   public void addUser(User u)
   {
      //sets the current date to check the age of the user. 
      Calendar now = Calendar.getInstance();   
      int year = now.get(Calendar.YEAR);
      int age = year - u.getBirthYear();
      
      //The user's age must be at least 13 and
      //he/she must not already be in the friend list.
      final int minAge = 13;
      if(age >= minAge && allUsers.contains(u) == -1)
      {
         allUsers.addNodeToEnd(u);
         System.out.println(u + ", you have been added successfully.");
      }   
      //User is too young.
      else if(age < minAge)
         System.out.println(u + ", you are only " + age + ".  You must be at least " + minAge + " to join.");
      //User's name is already listed.
      else
         System.out.println("Please choose a different name.");   
   }
   
   //Removes user from FriendList and removes that user as a friend of any other users   
   public void removeUser(User u)
   {
      //Finds the user object to remove.
      int i = allUsers.contains(u);
      //The user to be removed is found in the list.
      if(i != -1)
      {
         allUsers.removeNode(i);
      
         //Searches through all users in FriendList
         //Removes the user in all lists of friends.
         Node curr = allUsers.getFront();
         while(curr != null)
         {   
            //Removes the user u from the current node.
            curr.getUser().removeFriend(u);
            curr = curr.getNext();
         }
         
         System.out.println(u + " removed successfully.");      
      }
      //The user to be removed is not found in the list.
      else
         System.out.println("Cannot remove specified user.");             
   }
   
   //returns the total number of users on FriendList
   public int totalUsers()
   {
      return allUsers.size();
   }
   
	//returns the list of all users
   public LinkedList getUsers()
   {
      return allUsers;
   }
   
	//returns the user who has the most friends. If two or more users have the 'most friends' (i.e., a tie for
   //most friends, return the first	User with that	number (similar to how ArrayLists handle this case)   
   public User mostFriends()
   {      
      //There exist users in the friendList.
      if(!allUsers.isEmpty())
      {
         Node curr = allUsers.getFront();
         User mostFriends = curr.getUser();
         
         //The current node has a User to compare.
         while(curr != null)
         {
            //The size of the current node's list of friends exceeds the size of the mostFriends' list of friends.
            if(curr.getUser().getFriends().size() > mostFriends.getFriends().size())
               mostFriends = curr.getUser();
            curr = curr.getNext();
         }         
         return mostFriends;
      }
      
      else
         return null;           
   }    
   
   //returns the user with	the oldest friend. If two or more users have 'the oldest' friend (i.e., same birthday	
   //return the first User (similar to how ArrayLists handle this case)
   //The following algorithm is analagous to the mostFriends() method.
   //Only a single user is returned.
   public User oldestFriend()
   {
      //There are users to compare.
      if(!allUsers.isEmpty())
      {
         Node curr = allUsers.getFront();
         User oldestFriend = curr.getUser();
         
         while(curr != null)
         {
            //The current user is older than the oldestFriend user. 
            if(curr.getUser().getBirthYear() < oldestFriend.getBirthYear())
               oldestFriend = curr.getUser();
            curr = curr.getNext();
         }
         
         return oldestFriend;
      }
      
      //There are no users to compare.
      else
         return null;      
   }
   
   //find common friends between users and returns new list
   public LinkedList commonFriends(User u1, User u2)
   {
      //Stores common friends.
      LinkedList common = new LinkedList();
               
      //The two users are defined.
      if(u1 != null && u2 != null)
      {
         //Stores friends of the first user.
         LinkedList uFr1 = u1.getFriends();
         //Stores friends of the second user.
         LinkedList uFr2 = u2.getFriends();
         //The current node will move through the first user.
         Node curr = uFr1.getFront();
         
         while(curr != null)
         {
            //The 2nd user has as a friend the sample first user's friend
            if(uFr2.contains(curr.getUser()) != -1)
               common.addNodeToFront(curr.getUser());
            curr = curr.getNext();
         }        
      }
      //This linkedList will be empty if the user objects are null, or no common users are found.
      return common;                             
   }
   
   //This method will provide a user with the given name.
   //This simplifies the code in the demo program.
   public User getUser(String name)
   {
      return allUsers.getUserWithName(name); 
   }
   
   //This method will update FriendList from specified files.
   public boolean readFromFiles(File users, File friends) throws IOException
   {
      //Determines whether the input file is valid.
      //if not, the program will not enter the friendlist menu. 
      boolean fileValid = true;      
      //reads in users and their attributes.
      Scanner reader1 = new Scanner(users);
      String name = "", location = "", byear = "";
      int birthYear = 0;
           
      //Scans through the users file
      
      while(reader1.hasNext() && fileValid)
      {
         //There is another line to be read, and the file is valid.
         name = reader1.next();
         location = reader1.next();
         byear = reader1.next();
                  
         //Makes sure the birth year is in the proper int format.
         try
         {
            birthYear = Integer.parseInt(byear);            
         }catch(Exception inputMisMatchException)
         {
            //There is no integer birth year found by the file reader.
            fileValid = false;                               
         }
         
         //adds the new user to the FriendList.
         //The addUser method is bypassed, because we assume 
         //the users on LinkedList are already established.
         allUsers.addNodeToEnd(new User(name, location, birthYear));         
      }
      
      //Scans through the friends file
      
      //Reades an entire line from users.txt.
      Scanner lineReader2 = new Scanner(friends);
      String line = "";
      //Reads the individual names from users.txt.
      Scanner tokenReader2 = new Scanner(line);
      String token = "";
      User u, v;
      
      //There are still input lines to read, and the input file is valid.                   
      while(lineReader2.hasNextLine() && fileValid)
      {
         line = lineReader2.nextLine();
         tokenReader2 = new Scanner(line);
         token = tokenReader2.next();
         
         //For each line being read, the first name will match to a user in LinkedList.
         //Note that the users should already be registered in allUsers.
         u = getUser(token);
         while(tokenReader2.hasNext())
         {
            token = tokenReader2.next();
            System.out.println(token);
            //All subsequent names read by the tokenReader will be added
            //to the particular user's friendlist.
            v = getUser(token);
            if(u != null && v != null)
               //Since users u and v are assumed to be friends,
               //The method addFriend will not be used here.
               u.getFriends().addNodeToEnd(v);               
            else
               fileValid = false;              
         }
      }      
      //Closes all readers and files.
      reader1.close();
      lineReader2.close();
      tokenReader2.close();
      if(!fileValid)
         System.out.println("Invalid input file.");            
      return fileValid;            
   }
   
   public void writeToFiles(File users, File friends) throws IOException
   {
      //u will store the users, and v will store each users' friends.
      User u, v;
      //Writes the users in allUsers to users file.
      PrintWriter writer1 = new PrintWriter(users);
      Node curr = allUsers.getFront();
      
      //Loops through each user in allUsers.
      while(curr!=null)
      {
         //Obtains the current node's user, and prints its attributes.
         u = curr.getUser();
         //printf formats printout to file.
         writer1.printf("%-10s%-15s%-10s\n", u.getName(), u.getLocation(), u.getBirthYear());
         writer1.println();
         curr = curr.getNext();
      }      
      
      //Writes each user's friends to friends file.
      PrintWriter writer2 = new PrintWriter(friends);
      LinkedList usersFriends;
      //Current node for users.
      curr = allUsers.getFront();
      //Current node for friends.
      Node curr2;
      
      //Loops through each user in allUsers.
      while(curr!=null)
      {
         //prints the user's name.
         u = curr.getUser();
         usersFriends = u.getFriends();
         writer2.printf("%-15s",u.getName());
         curr2 = usersFriends.getFront();
         
         //Loops through each user's friend.   
         while(curr2!=null)
         {
            //prints each friend of user.
            v = curr2.getUser();
            //printf formats printout to file.
            writer2.printf("%-10s", v.getName());
            curr2 = curr2.getNext();
         }
         writer2.println();
         curr = curr.getNext();
      }      
      writer1.close();
      writer2.close();
   }                                                                                                          
}
      
                