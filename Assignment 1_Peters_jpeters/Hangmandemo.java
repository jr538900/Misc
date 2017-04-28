/*CSCI 1101 – Assignment 1 – Hangmandemo.java
This program uses a "Hangman" object to simulate the game of Hangman.   
<Jeremy Peters> <B00707976>  <Feb 6, 2017> */

import java.util.Scanner;
public class Hangmandemo
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      Hangman game = new Hangman(); //creates new hangman object
      game.generateSecretWord(); //generates the secret word and corresponding hidden word.
      char guess;    //Stores the user input.      
      int count = 0;  //Counts the number of guessed elements in the array.
      boolean alreadyEntered = false; //Determines whether the guess was already entered by the user.
      
      //An array storing the used answers is created and set to spaces.
      char[] usedAns = new char[26];   
      for(int i = 0; i<26; i++)
         usedAns[i] = ' ';
                
      //Introduces user to the game.
      System.out.println("Welcome to the hangman game.");
      System.out.println("I have a secret Pokemon character name. You have to guess it.");
      System.out.println("You are allowed only six incorrect guesses.");
                
      //The variable "keepPlaying" is now set up and used to determine whether the game continues.
      boolean keepPlaying = true;
      while (keepPlaying)
      {
         //prints out the hidden word, and prompts user for guess. 
         System.out.println("\nSecret word: " + new String(game.getDisguisedWord()));
         System.out.print("Enter the guess: ");
         guess = keyboard.next().charAt(0);
         
         //Checks whether the guess is already entered by the user in a previous turn.
         //This array will be filled with letters from lower to higher indices.
         for(int j = 0; j<26; j++)
         {
            //The guess was already entered by the user.
            if(usedAns[j] == guess)
            {
               alreadyEntered = true;
               j = 26;  //stops loop
            }
            
            //The guess was not in the array, and will now take the place of an "empty" element. 
            else if(usedAns[j] == ' ')
            {
               alreadyEntered = false;
               usedAns[j] = guess;
               j = 26;  //stops loop
            }
            
            //The guess was not in this element, but this element was not "empty".
            else
               alreadyEntered = false;
               //In this case, the loop continues.            
         }
         
         //This will process the user's guess if the guess was not already made.           
         if(alreadyEntered)
            System.out.println("You already guessed " + guess + ". Choose another letter.");
         else
            keepPlaying = game.makeGuess(guess);           
      }        
   }
}   
  