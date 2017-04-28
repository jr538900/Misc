/*CSCI 1101 – Assignment 2 – Board.java
This program defines a "Board" object with arbitrary dimensions.
<Jeremy Peters> <B00707976>  <Feb 27, 2017> */

public class Board
{
   //Attributes
   private int rows; //Stores the number of rows the board contains.
   private int cols; //Stores the number of columns the board contains.
   
   //Constructor creates a board with specified dimensions
   public Board(int rows, int cols)
   {
      this.rows = rows;
      this.cols = cols;
   }
   
   //This get method provides the number of rows
   public int getRows()
   {
      return rows;
   }
   
   //This get method provides the number of columns
   public int getCols()
   {
      return cols;
   }
   
   //Note: there are no set methods to modify the number of rows and columns.
   //This is to ensure that any given board object has consistent dimensions.    
}   