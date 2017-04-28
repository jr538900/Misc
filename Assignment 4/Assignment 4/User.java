
public class User {

	/**
	 * @param args
	 */
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
		return (name.equals(u.getName()));
	}
	
	
   //returns the number of friends the user has
   public int getNumFriends()
   {
      return friends.size();
   }
      
   //returns the name and location of the user
   public String toString()
   {
      return "Name: " + name + ", Location: " + location;
   }    
   
   
   //adds user u as a friend to their list and user u adds this user to their friend list   
	public void addFriend (User u)
   {      
      friends.addNodeToFront(new User(u.getName(), u.getLocation(), u.getBirthYear()));
      u.getFriends().addNodeToFront(new User(name, location, birthYear));       
   }  
    
   //removes user u as a friend from their list and user us removes this user from their friend list
   public void removeFriend(User u)
   {
      Node curr = friends.getFront();
      int index = 0;
      boolean done = false;
      if(!friends.isEmpty())
      {
         while(curr.getNext()!=null && !done)
         {
            //the input attributes match this object's attributes.
            if(curr.getUser().getName().equals(name) && curr.getUser().getLocation().equals(location) &&
               curr.getUser().getBirthYear() == birthYear)
            {
               friends.removeNode(index);
               done = true;
            }
            curr = curr.getNext();
            index++;
         }
      }
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
   
   //Test
   public static void main(String[] args)
   {
      User j = new User("Jeremy", "Halifax", 1997);
      User k = new User("Kristin", "Halifax", 1999);
      User b = new User("Brian", "Vancouver", 2014);
      j.addFriend(k);      
      b.addFriend(j);
      j.getFriends().enumerate();     
   }    
}
