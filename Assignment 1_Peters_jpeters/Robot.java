/*CSCI 1101 – Assignment 1 – Robot.java
This program creates a robot object, with attributes name, x and y position, direction and points collected.   
<Jeremy Peters> <B00707976>  <Feb 6, 2017> */

public class Robot
{
   //Attributes
   private String name; //Stores the name of the robot
   private int x;       //Stores the current x position of the robot
   private int y;       //Stores the current y position of the robot
   private int dir;     //Stores the direction the robot faces (a number)
   private int pts;     //Stores the total number of points earned by the robot
   
   //Constructor method makes a robot object with a specified name and initial direction
   //The initial position is automatically set to (1, 1) and the initial points collected set to 1+1 = 2.
   public Robot(String name, String direction)
   {
      this.name = name;
      setDir(direction); 
      x = 1;
      y = 1;
      pts = x+y;
   }
   
   //This constructor makes a robot object, but takes in no arguments.
   public Robot(){}
   
   //Set methods set the name, x and y position, direction, and points collected 
   public void setName(String name)
   {
      this.name = name;
   }
   public void setX(int x)
   {
      this.x = x;
   }
   public void setY(int y)
   {
      this.y = y;
   }
   public void setDir(int dir)
   {
      this.dir = dir;                  
   }
   //This "set" method will convert a verbal direction to a corresponding integer.
   //The direction up means 1, the direction right means 2, and the direction diagonal means 3.
   public void setDir(String word)
   {
      if(word.equalsIgnoreCase("Up"))
         dir = 1;
      else if(word.equalsIgnoreCase("Right"))
         dir = 2;
      else if(word.equalsIgnoreCase("Diagonal") || word.equalsIgnoreCase("Diag"))
         dir = 3;
      else
         dir = 0;                 
   }    
   public void setPts(int pts)
   {
      this.pts = pts;
   }
   
   //Get methods provide the name, x and y position, direction, and points collected
   public String getName()
   {
      return name;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public int getDir()
   {
      return dir;
   }
   public int getPts()
   {
      return pts;
   }     
   
   //Move method moves the robot a specified number of steps in the direction he is facing.
   //This method also updates the points collected based on the robot's new x and y position.
   public void move(int steps)
   {
      //Robot moves up if he faces up.
      //In this direction, the y position increases.
      if(dir == 1)
         y+=steps;
      
      //Robot moves right if he faces right.
      //In this direction, the x position increases.
      else if(dir == 2)
         x+=steps;
                
      //Robot moves diagonally if he faces diagonally.
      //In this direction, the x and y position both increase.
      else if(dir == 3)
      {
         x+=steps;
         y+=steps;      
      }
      
      //Robot cannot move with an invalid direction (error checking).
      else
         System.out.println("\nCannot move.");
      
      //The points will increase based on the robot's new position.
      pts+=(x+y);      
   }
          
   //ToString method prints the name, x and y position, direction of the robot, and total points collected.
   //The direction name is also formatted.
   public String toString()
   {
      String result = name + "\t(" + x + "," + y + ")\t";
      
      //Formats the direction name.
      if(dir == 1) //direction is up.
         result += "Up   ";
      else if(dir == 2)  //direction is right
         result += "Right";
      else if(dir == 3) //direction is diagonal               
         result += "Diag ";
      else
         result += "(N/A)";  
      result += "\t" + pts + "  points";  
      return result;  
   }
   
   //Compares the positions of this robot with that of another robot.
   public boolean amIAhead(Robot robot)
   {
      //Algorithm:  Check the sum of the x and y values of this robot and the other robot.
      //If this robot's sum is strictly larger than that of the other robot, this robot is ahead.
      //Otherwise, the other robot is ahead.
      if((x+y)>(robot.getX()+robot.getY()))
         return true;
      else
         return false;
   }
   
   
   //Extra methods not explicitly given in the instructions for Robot.java are below.
   
   //This method will verify that the robot stays on the board after moving the specified number of steps.
   //This method is designed for this obot to plan its next position before actually making its move. 
   public boolean staysOnBoardAfterMoving(int steps)
   {
      //This variable will be false if the robot falls off the board and true otherwise.
      boolean onboard;
      
      //The robot is about to move up by some number of steps and leaves the board
      if(dir == 1 && (y+steps)>8)
         onboard = false;
      //The robot is about to move right by some number of steps and leaves the board
      else if(dir == 2 && (x+steps)>8)
         onboard = false;
      //The robot is about to move diagonal by some number of steps and leaves the board (in the x or y direction)
      else if(dir == 3 && ((x+steps)>8 || (y+steps)>8))
         onboard = false;
      //The robot stays on the board
      else
         onboard = true;
      return onboard;
   }
   
   //This method will check if this robot will move into another square occupied by another (input) robot object.
   //This method is designed for this robot to plan its next position before actually making its move.
   //If the robot ends up bumping into another robot, its points will be deducted by the sum of the coordinates of the occupied square.
   public boolean bumpsInto(Robot rob, int steps)
   {
      //This variable will be true if this robot can avoid the input robot.
      boolean runsInto;
      
      //This robot is about to move up and share a square with the input robot.
      if(dir==1 && x==rob.getX() && (y+steps)==rob.getY())
      {
         runsInto = true;
         pts-=(x+(y+steps));
      }   
      //This robot is about to move right and share a square with the input robot.    
      else if(dir==2 && (x+steps)==rob.getX() && y==rob.getY())
      {
         runsInto = true;
         pts-=((x+steps)+y);
      }   
      //This robot is about to move diagonally and share a square with the input robot.
      else if(dir==3 && (x+steps)==rob.getX() && (y+steps)==rob.getY())
      {
         runsInto = true;
         pts-=((x+steps)+(y+steps));
      }   
      
      //The robot does not share a square with the input robot.
      else
         runsInto = false;      
           
      return runsInto;
   }
   
   //This method will determine if the robot is ready to continue playing the game.
   //This method will check that all attributes are set to proper values, and each robot is not finished.
   public boolean isReady()
   {
      //The direction must be from 1 to 3, and the x and y position must still be on the board, and the robot  must not be finished yet.
      if(!hasFinished() && (dir == 1 || dir == 2 || dir == 3) && staysOnBoardAfterMoving(0))
         return true;
      else
         return false;   
   }       
      
   //This method will determine if the robot has reached the end square (which is 8, 8).
   public boolean hasFinished()
   {
      if(x == 8 && y == 8)
         return true;
      else
         return false;
   }                                                                                           
}
