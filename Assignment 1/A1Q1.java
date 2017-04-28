/*CSCI 1100-Assignment 1-"Question 1"
This program will print a triangular formation of a series of two
different digits in alternating rows.  These digits will be 
inputted by the user.
<Jeremy Peters><B00707976> <Oct 23, 2016>*/
import java.util.Scanner;
public class A1Q1{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      int x1, x2;
      System.out.print("Input a number between 0-4: ");
      x1 = keyboard.nextInt(); 
      System.out.print("Input a number between 5-9: ");
      x2 = keyboard.nextInt();
      /*The scanner object reads the user input and stores that 
      input as x1.*/
      System.out.println("   " + x1);
      System.out.println("  " + x2 + " " + x2); 
      System.out.println(" " + x1 + " " + x1 + " " + x1);
      System.out.println(x2 + " " + x2 + " " + x2 + " " + x2);
      /*Each line of the System.out.print command prints a row
      of the triangle. The spaces align the digits.*/
   }
}      