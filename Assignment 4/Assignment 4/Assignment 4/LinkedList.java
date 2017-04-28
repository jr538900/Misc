//class LinkedList
public class LinkedList
{
	private Node front;
	private int count;
	
	//sets front to null and count to 0	
	public LinkedList()
	{
		front = null;
		count = 0;
	}
	
   //get the current size of the list
	public int size()
	{
		return count;
	}
   
   //check if the list is empty
	public boolean isEmpty()
	{
		if (front==null)
			return true;
		else
			return false;
	}
   
   //clears the list
	public void clear()
	{
		front = null;
		count=0;
	}
   
	//add a node to the front of the linked list
	public void addNodeToFront(User d)
	{
		Node n;
		n = new Node(d, front);
		front = n;
		count++;
	}
   
   //new method added - get the first node
	public Node getFront()
	{
		return front;
	}
   
	//get the content of the first node
	public User getFrontData()
	{
		if (front==null)
			return null;
		else
			return front.getUser();
	}
	  
	//scan the list and print contents
	public void enumerate()
	{
		Node curr = front;
		while (curr!=null)
		{
			System.out.print(curr);
			curr = curr.getNext();
		}
		if(front == null)
         System.out.print("Empty list");
      System.out.println(".");
	}
	
	//remove front node
	public void removeFront()
	{
		if (front==null)
		{
			System.out.println("Empty list");
		}
		else
		{
			front = front.getNext();
			count--;
		}
	}
   
   //remove last node
	public void removeLast()
	{
		if (front==null)
		{
			System.out.println("Empty list");
		}
		else if (front.getNext()==null)
		{
			front = null;
			count--;
		}
		else
		{
			Node curr = front;
			while (curr.getNext().getNext()!=null)
				curr = curr.getNext();
			curr.setNext(null);
			count--;
		}
			
	}
   
	//add a node to the end
	public void addNodeToEnd(User d)
	{
		Node n = new Node(d, null);
		Node curr = front;
		if (front==null)
			front = n;
		else
		{
			while (curr.getNext()!=null)
				curr = curr.getNext();
			curr.setNext(n);
		}
		count++;		
	}

	//search for a given data and return the index of the node (first occurrence)
	//return -1 if not found
	public int contains(User d)
	{
		Node curr = front;
		boolean found = false;
		int index = -1;
      
		while (curr!=null&&!found)
		{
			index++;
			if (curr.getUser().isEqual(d))
				found=true;
			curr = curr.getNext();        
		}
      //If the user is not found, the index is overwritten.
      if(!found)
         index = -1;
      return index;      		
	}
	
   //remove a node at a given index
	public void removeNode(int index)
	{
		if (index<0 || index>=size())
			System.out.println("Can't remove. Index out of bounds");
		else if (index==0)
			removeFront();
		else if (index==size()-1)
			removeLast();
		else
		{
			Node curr = front;
			for(int i=0;i<index-1;i++)
				curr = curr.getNext();
			curr.setNext(curr.getNext().getNext());
			count--;
		}
	}
      
	//add a node at a given index
	public void add(int index, User d)
	{
		if (index>=0 && index<=size())
		{
			if (index==0)
				addNodeToFront(d);
			else
			{
				Node curr = front;
				for(int i=0; i<index-1; i++)
					curr = curr.getNext();
				Node n = new Node(d,curr.getNext());
				curr.setNext(n);
				count++;
			}
		}	
	}
	
	//get a node data given an index
	public User getUserAt(int index)
	{
	   Node curr = front;
		int i=0;
		
      //This will search through the linkedList, until a user has been found.
      //Note:  If the index is invalid, then the current will eventually become null
      //and the loop will stop.
      while (curr!=null && i!=index)
		{
		   curr=curr.getNext();
		   i++;		   
      }
          
      //The user is found.
      if(curr!=null)
		   return(curr.getUser());
		else
         return null;
	}                   
   
   //Prints the nodes of this LinkedList
   public String toString()
   {
      String result = "";
      if(!isEmpty())
      {
         Node curr = front;
         while(curr!=null)
         {
            result += curr;
            curr = curr.getNext();
         }
         return result;
      }
      else
         return "Empty list.";
   }
   
   //This will find a user with a specified name.
   //This method takes in a string, makes a user object from that string
   //and can now call the methods that require user objects as arguments.
   public User getUserWithName(String name)
   {
      //Locates the index of the user of interest in this linkedList.
      int index = contains(new User(name, "", 0));
      //The user was found.
      if(index != -1)
         return getUserAt(index);
      //The user was not found.
      else
         return null;         
   }           
}
		
	