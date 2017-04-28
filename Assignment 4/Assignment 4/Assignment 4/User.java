public class User {
   
	private String	name;          //this is user's name
	private String	location;		//this is where they currently live (city or town)
	private int birthYear;	      //this is the year of birth
	private LinkedList friends;	//this is a LinkedList that holds Nodes of Users who are their friends
	
   //sets name, location and birthYear, initializes the LinkedList
   public User	(String name, String location, int birthYear)
   {	
	   this.name = name;
	   this.location = location;
	   this.birthYear = birthYear;
	   friends = new LinkedList();
	}      
   //returns name
	public String getName()
   {
		return name;
	}
   
	//sets the name
	public void setName(String name) 
   {
		this.name = name;
	}
   
	//returns the location
	public String getLocation() 
   {
		return location;
	}
   
	//sets the location
	public void setLocation(String location) 
   {
		this.location = location;
	}
	
   //returns the birthyear
	public int getBirthYear() 
   {
		return birthYear;
	}
	
   
   //sets the birthYear.
	public void setBirthYear(int birthYear) 
   {
		this.birthYear = birthYear;
	}
	
   //returns friends
	public LinkedList getFriends() 
   {
		return friends;
	}
	
   //sets the friends
	public void setFriends(LinkedList friends) 
   {
		this.friends = friends;
	}
   
   //determines whether the users have the same name.
   public boolean isEqual(User u)
   {
		if(u != null)
         return (name.equals(u.getName()));
      else
         return false;   
	}
	
	
   //returns the number of friends the user has
   public int getNumFriends()
   {
      return friends.size();
   }
      
   //returns the name and location of the user
   public String toString()
   {
      return name + " from " + location;
   }    
   
   
   //adds user u as a friend to their list and user u adds this user to their friend list   
	public void addFriend (User u)
   {      
      if(u != null)
      {
         //this user's list of friends does not already contain User u.
         //and the other user's list of friends does not already contain this User object.
         if(friends.contains(u)==-1 && u.getFriends().contains(this)==-1)
         {
            friends.addNodeToEnd(u);
            u.getFriends().addNodeToEnd(this);
            System.out.println(this + " and " + u + " have been successfully added as friends."); 
         }
         //the two users are already friends.
         else
            System.out.println(this + " and " + u + " were already friends.");           
      }
      else
         System.out.println("User is undefined.  Cannot add.");          
   }  
    
   //removes user u as a friend from their list and user u removes this user from their friend list
   public void removeFriend(User u)
   {
      //Searches through this user's friend list for user.
      int index = 0;
      boolean done1 = false;
      //Searches through this list for u.
      Node curr = friends.getFront();
      if(!friends.isEmpty())
      {
         //The list of friends is nonempty, so safe to remove.
         while(curr != null && !done1)
         {
            //The input user's name matches the current friend's name.
            //Note that all users have a unique name. 
            if(u.isEqual(curr.getUser()))
            {
               friends.removeNode(index);
               done1 = true;
            }
            curr = curr.getNext();
            index++;
         }
      }
      //Searches through u's friend list for this user.
      Boolean done2 = false;
      index = 0;
      if(!u.getFriends().isEmpty())
      {
         //u's friend list is nonempty.
         curr = u.getFriends().getFront();
         while(curr!=null && !done2)
         {
            //this user is equal to the user node in u's friend list.
            if(this.isEqual(curr.getUser()))
            {
               //removes a node from the user's node.
               u.getFriends().removeNode(index);
               done2 = true;
            }
            curr = curr.getNext();
            index++;
         }
      }
      if(done1 && done2)
         //This user is no longer friends with the input user.
         System.out.println(toString() + " and " + u + " are no longer friends.");                        
   }               
	
   //returns the	friend who is the oldest (e.g., 30 years old). If there is tie (i.e., same birthday) return the first	
	//friend with that birthdate.
   public User oldestFriend()
   {
      if(!friends.isEmpty())
      {
         Node curr = friends.getFront();
         User oldest = friends.getFront().getUser();
         
         while(curr != null)
         {
            //the current node is strictly older than the previously oldest user's node.
            if(curr.getUser().getBirthYear()<oldest.getBirthYear())
               oldest = curr.getUser();
            curr = curr.getNext();            
         }        
         return oldest;
      }
      else
      {
         System.out.println("Empty list");
         return null;
      }          
   }     
}
