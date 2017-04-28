//Imports calendar class to determine current instance of time
//this is needed for the addUser method to ensure the user is the right age.
import java.util.Calendar;
public class FriendList
{
   private LinkedList allUsers;
   
	//no args constructor creates a new empty	list   
   public FriendList()
   {
      allUsers = new LinkedList();
   }
   
	//adds	a	user	after	checking	that	they	are	at	least	13	years	old	and	do	not	already	exist   
   public void addUser(User u)
   {
      //sets the current date to check the age of the user. 
      Calendar now = Calendar.getInstance();   
      int year = now.get(Calendar.YEAR);
      int age = year - u.getBirthYear();
      
      //The user's age must be at least 13 and
      //he/she must not already be in the friend list.
      if(age >= 13 && allUsers.contains(u) == -1)
         allUsers.addNodeToFront(u);
      else
         System.out.println("Cannot add user:" + u);
   }
   
   //removes user from FriendList and remove that user as a friend of any other users   
   public void removeUser(User u)
   {
      //Removes user from allUsers.
      int i = allUsers.contains(u);
      if(i != -1)
      {
         allUsers.removeNode(i);
      
         //Searches through all users to remove the user in the friends linkedList.
         Node curr = allUsers.getFront();
         while(curr != null)
         {
            LinkedList friends = curr.getUser().getFriends();
            int j = friends.contains(u);
            if(j!=-1)
               friends.removeNode(j);
            curr = curr.getNext();
         }      
      }
      else
         System.out.println("Cannot remove user: " + u);             
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
      {
         System.out.println("Empty list.");
         return null;
      }      
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
      {
         System.out.println("Empty list.");
         return null;
      }
   }
   
   //find	common	friends	between	users	and	returns	new	list
   public LinkedList commonFriends(User u1, User u2)
   {
      if(u1 != null && u2 != null)
      {
         //Stores common friends.
         LinkedList common = new LinkedList();
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
         return common;
      }
      else
      {
         System.out.println("Invalid users.");
         return null;
      }                 
   }                                              
}
      
                