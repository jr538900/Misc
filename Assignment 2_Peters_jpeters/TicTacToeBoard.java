/*CSCI 1101 – Assignment 2 – TicTacToeBoard.java
This "TicTacToeBoard" object is aggregated from the "XO" class, and inheirits the "Board" class.
This object keeps track of all "XO" objects on a board, and keeps track of the number of turns taken.
This object provides the setting for a tic-tac-toe game.
<Jeremy Peters> <B00707976>  <Feb 27, 2017> */

public class TicTacToeBoard extends Board
{
   //Attributes
   private XO[][] board;  //Stores the tic-tac-toe board
   private int turnCnt; //Stores the number of Xs or Os placed on the tic-tac-toe board
   
   //This constructor sets up the dimensions of the board, makes every entry a blank string, and sets the turn count to 0.
   public TicTacToeBoard(int rows, int cols)
   {
      super(rows, cols);
      board = new XO[rows][cols];
      turnCnt = 0;
   }
      
   //This set method establishes the turn count.
   public void setTurnCnt(int count)
   {
      turnCnt = count;
   }
   //This set method establishes the tic-tac-toe board.
   public void setXOBoard(XO[][] bd)
   {
      for(int i=0; i<board.length; i++)   //Loops through each row of the board
         for(int j=0; j<board[i].length; j++)   //Loops through each row element of the board
            board[i][j] = bd[i][j]; //Each element in the object's board is updated by the input.
   }
   //This get method returns the turn count.
   public int getTurnCnt()
   {
      return turnCnt;
   }
   //This get method returns the tic-tac-toe board.
   public XO[][] getTicTacToeBoard()
   {
      return board;
   }
   
   //This method adds an "X" or "O" to the board.
   public boolean add(int row, int col)
   {
      //The input row and column position is beyond the current board dimensions.
      if(row<1 || row>getRows() || col<1 || col>getCols())
         return false;
      
      //The input row and column position is already occupied by another XO object
      else if(board[row-1][col-1] != null)
         return false;
      
      //The input row and column position is safe to use
      else
      {
         //The tic-tac-toe board is updated.
         board[row-1][col-1] = new XO();
         turnCnt++;
         return true;
      }
   }
   
   //This method will determine whether the board is full
   public boolean isFull()
   {
      if(turnCnt == super.getRows()*super.getCols())
         return true;
      else return false;
   }      
   
   //This method will determine if there is a winner
   public boolean winner()
   {
      return (checkRows() || checkCols() || checkDiags());
   }
   
   //This method will check for any rows that contain only Xs or only Os.
   public boolean checkRows()
   {
      boolean found = false; //This determines if 3 consecutive Xs or Os are found in a column
      int count;  //This will count the number of matches found between elements.
      for(int i=0; i<board.length; i++)   //Loops through rows
      {
         count = 0;
         for(int j=0; j<board[i].length; j++)   //Loops through columns
            if(board[i][j] != null && board[i][0] != null) //The elements need to be defined to update the counter.
               if(board[i][j].equals(board[i][0]))   //This row element matches the row's first element
                  count++; //updates counter
         
         //If all row elements match the first row element, the count will record the row length
         //This corresponds to 3 in a row, and the loop's job is done.
         if(count == board[i].length)  
         {
            found = true;
            i = board.length;
         }
      }
      return found;
   }
   
   //This method will check for any columns that contain only Xs or only Os.
   public boolean checkCols()
   {
      boolean found = false; //Determines if 3 consecutive Xs or Os are found in a column
      int count;  //Will count the number of matches found between elements.
      for(int j=0; j<board[0].length; j++)   //Loops through columns
      {
         count = 0;
         for(int i=0; i<board.length; i++)   //Loops through rows
            if(board[i][j] != null && board[0][j] != null) //The elements need to be defined to update the counter.
               if(board[i][j].equals(board[0][j]))   //This column element matches the column's first element
                  count++; //updates counter
         
         //If all column elements match the first column element, the count will record the column's length
         //This corresponds to 3 consecutive characters in a column, and the loop's job is done.
         if(count == board.length)  
         {
            found = true;
            j = board[0].length;
         }
      }
      return found;
   }
   
   //This method will determine whether the main diagonals contain only Xs or only Os.
   public boolean checkDiags()
   {
      boolean found = false;  //Determines if 3 consecutive Xs or Os are found in a column
      int count1, count2;  //Will count the number of matches found between elements.
      
      //This loop will search through the upper left to lower right diagonal.
      count1 = 0;
      for(int i=0; i<board.length; i++)
         if(board[i][i] != null && board[0][0] != null)  //The elements need to be defined to update the counter.
            if(board[i][i].equals(board[0][0]))   //All board elements must match the first element.
               count1++;
      
      //This loop will search through the upper right to lower left diagonal.      
      count2 = 0;
      for(int i=0; i<board.length; i++)
         if(board[i][board.length-1-i] != null && board[0][board.length-1] != null)   //The elements need to be defined to update the counter.
            if(board[i][board.length-1-i].equals(board[0][board.length-1]))   //All board elements must match the first element.
               count2++;
      
      //A "three in a row" can occur if either diagonal count finds enough matches.
      if(count1 == board.length || count2 == board.length)
         found = true;
      
      return found;
   }
   
   //This method prints out the Xs and Os on the board.
   public String toString()
   {
      String result = "\n   \t\t\tCol\n   \t\t\t1   \t2   \t3\n"; //Prints out the column headers
      
      //Prints out each row.
      for(int i=0; i<board.length; i++)
      {
         if(i == 0)  //The row header is printed in the first row.
            result += "Row";
         else  //Subsequent rows have spaces to align the text.
            result += "   ";
               
         result += "\t" + (i+1);  //Prints the column number
         for(int j=0; j<board[i].length; j++)
         {
            result += "\t\t";
            if(board[i][j] == null) //If the object in this element is undefined, a space is printed.
               result += " ";
            else  //If the object in this element is defined, the "X", or "O" is printed.
               result += board[i][j];               
         }      
         result += "\n\n"; //Prepares for the next row in the loop.
      }
      //result +="\n";      
      return result;
   }                                                                       
}   