/*CSCI 1100-Assignment 1-"Question 3"
This program will tell the user one of two different stories.
Both stories use personal information that the user enters.
The story the computer chooses will depend on the number that 
the user enters.
<Jeremy Peters><B00707976> <Oct 23, 2016>*/

import java.util.Scanner;/*Imports scanner object.*/
public class A1Q3{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      /*This sets up the scanner object.*/
      int number;
      String name, sport, hometown, movie, animal;
      /*The variables are ready to store values.*/
      System.out.println("Please enter the following: ");
      System.out.print("One number between 1 and 10: ");
      number = keyboard.nextInt();
      /*This number affects what story is told*/
      keyboard.nextLine();
      /*This command is necessary to remove the newline 
      character that the nextInt method left behind in the 
      keyboard buffer.  Once this character is removed, the 
      nextLine method can read the keyboard input without 
      stopping prematurely at a newline character.*/
      System.out.print("Your name: ");
      name = keyboard.nextLine();
      System.out.print("Your favourite sport: ");
      sport = keyboard.nextLine();
      System.out.print("Your hometown: ");
      hometown = keyboard.nextLine();
      System.out.print("Your favourite movie: ");
      movie = keyboard.nextLine();
      System.out.print("Your favourite animal: ");
      animal = keyboard.nextLine();
      /*The user has now entered his information.*/
      if (number < 5){
      /*One story will be told if the user entered a number
      less than 5.*/
         System.out.println("\nTHIS IS THE BEST STORY EVER");
         System.out.println("My name is " + name + 
                            ". And I'm from " + hometown + ".");
         System.out.println("My favorite sport is " + sport + 
                            ". I have a pet " + animal);
         System.out.println("who I take to watch my favorite" + 
                            " movie " + movie + ".");
         System.out.println("The End!");
      }
      else {
      /*A different story is told if the user enters a number
      greater than or equal to 5.*/
         System.out.println("\nTHIS IS THE BEST STORY EVER");
         System.out.println("My name is " + name + 
                            " and I am a " + animal + ".");
         System.out.println("I live in " + hometown + 
                            " and love to watch " + movie +
                            " while ");
         System.out.println("trying to play " + sport + ".");
         System.out.println("It does not work out so well " +
                            "though.");
         System.out.println("The End!");
      }                                                                                  
   }
}      
      