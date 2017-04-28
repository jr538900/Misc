/*CSCI 1101 – Assignment 2 – XO.java
This program defines an "XO" object, which defines whether a given tic-tac-toe square will hold an X or Y.    
<Jeremy Peters> <B00707976>  <Feb 27, 2017> */

public class XO
{
   //Attributes
   private String name; //This will either be "X" or "O".
   private static int turn; //This will determine whether an "X" or "O" is played on a given turn.
   
   //No-args constructor sets the name and updates the turn of this object
   public XO()
   {
      //If Turn is 1, then this object is called "X", and the turn switches to 0. 
      if(turn == 1)
      {
         name = "X";
         turn = 0;
      }
      //If Turn is 0, then this object is called "O", and the turn switches to 1.   
      else
      {
         name = "O";
         turn = 1;
      }
   }
   
   //This set method determines the name ("X" or "O"), based on the turn number.
   public void setName()
   {
      if(turn == 1)  //If the turn is 1, this object is "X".
      {
         name = "X";
         turn = 0;
      }
      else  //If the turn is 0, this object is "O".
      {
         name = "0";
         turn = 1;
      }      
   }
    
   //This set method will determine the turn number, at the beginning of the game.
   public static void setTurn()
   {
      turn = 1;
   }         
   
   //This get method will return the name ("X" or "O").
   public String getName()
   {
      return name;
   }
   //This get method will return the turn number (0 or 1).
   public static int getTurn()
   {
      return turn;
   }
   
   //This method will determine if this object has the same name as another object.
   public boolean equals (XO token)
   {
      return name == token.getName();
   }
   
   //This toString method will print out the name of this object
   public String toString()
   {
      return name;
   }
}         
                  
                  
   