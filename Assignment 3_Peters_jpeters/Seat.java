/*CSCI 1101 – Assignment 3 – Seat.java
This program will code for an "Seat" object, that knows whether it is booked,
its row number, and its position in that given row. 
<Jeremy Peters> <B00707976>  <Mar 17, 2017> */

public class Seat
{
   //Determines whether the seat is taken.
   private boolean booked;
   //Determines the row number.
   private int row;
   //Determines the position in the row.
   private char pos;
   
   //Constructor creates the seat object with a row number (from 1), and position number (from 1).
   public Seat(int row, char pos)
   {
      //The row number is set.
      this.row = row;
      this.pos = pos;
      //The seat is initially not booked.
      booked = false;
   }
   
   //Get and set methods provide and update the necessary attributes, respectively.
   public boolean isBooked()
   {
      //Determines whether the seat is booked or not.
      return booked;
   }
   public int getRow()
   {
      return row;
   }
   public char getPos()
   {
      return pos;
   }
   public void book()
   {
      //Books a seat by updating "booked".
      booked = true;
   }
   //The seat's row and position numbers will not be updated, because once the seat is made, it cannot be moved.
   
   //Prints whether the seat is booked.
   public String toString()
   {
      String result;
      if(booked)
         result = "BOOKED";
      else
         result = "vacant";
      return result;
   }  
}                   
                 
                        