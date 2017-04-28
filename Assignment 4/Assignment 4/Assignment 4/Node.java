public class Node
{
   //Attributes stores User object and next node.
	private User user;
	private Node next;
   
   //sets attributes to input values.
	public Node(User ud, Node n)
	{
		user = ud;
		next = n;
	}
   
   //sets User object
   public void setUserData(User ud)
	{
		user = ud;
	}
   
   //sets next Node.
   public void setNext(Node n)
	{
		next = n;
	}
   
   //returns User object
	public User getUser()
	{
		return user;
	}
   
   //returns next node object.
	public Node getNext()
	{
		return next;
	}
	
   //prints contents of the data in this node.
	public String toString()
	{
		return user + " --> ";
	}
}