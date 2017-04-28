/*CSCI 1101 – Assignment 2 – Play.java
This class uses a "TicTacToeBoard" object, which uses an "XO" object, and a "Board" object
to interact with two users, carry out the actual tic-tac-toe simulation.
<Jeremy Peters> <B00707976>  <Feb 27, 2017> */

import java.util.Scanner;
public class Play
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      //The two players' names are taken in, and the tic-tac-toe board object is created, named "game".
      System.out.print("Player 1 name: ");
      String name1 = keyboard.nextLine();
      System.out.print("Player 2 name: ");
      String name2 = keyboard.nextLine();
      System.out.println();
      
      //The turns start and the tic-tac-toe board is created.
      XO.setTurn();
      TicTacToeBoard game = new TicTacToeBoard(3, 3);
            
      //The tic-tac-toe board is printed out and the first player takes his/her turn.
      System.out.println(name1 + " - you are Xs and you go first."); 
      System.out.print(game);
      System.out.print(name1 + " - please input a row# between 1-3 and column# between 1-3: ");
      //This will update the board and be used for error-checking.
      boolean legal = game.add(keyboard.nextInt(), keyboard.nextInt()); 
      
      //This error-checks the user input. (It is assumed the user only enters coordinates).
      if(!legal)
            System.out.println("Please make sure your move is legal.");
      
      //The game proceeds if there is no winner and the board is not full.
      while(!game.winner() && !game.isFull())
      {
         //Prints the game board.
         System.out.print(game);
         
         //The User is determined based on the turn number, and that user enters his/her next move.
         if(XO.getTurn() == 1)
            System.out.print(name1);   //name1's turn
         else
            System.out.print(name2);   //name2's turn
         System.out.print(" please input a row# between 1-3 and column# between 1-3: ");
         
         //Determines whether the move was legal.
         legal = game.add(keyboard.nextInt(), keyboard.nextInt());
         if(!legal)
            System.out.println("Please make sure your move is legal.");        
      }
      System.out.print(game);
      
      //The game is over.
      
      //There is a winner.
      if(game.winner())
      {
         if(XO.getTurn() == 1)   //name1's turn, so name2 has already won.
            System.out.print(name2);
         else                    //name2's turn, so name1 has already won.
            System.out.print(name1);
         System.out.println(" you win!!");
      }
      
      //The game is tied
      else
         System.out.println("Tie game.");                     
   }
}   