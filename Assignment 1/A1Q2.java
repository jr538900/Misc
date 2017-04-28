/*CSCI 1100-Assignment 1-"Question 2"
This program will print a triangular formation of characters. 
These characters are asterisks if the user inputs an odd number,
or dollar signs if the user inputs an even number.
<Jeremy Peters><B00707976> <Oct 23, 2016>*/
import java.util.Scanner;
public class A1Q2{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      int x1;
      char symbol;
      System.out.print("Input a number between 1-10: ");
      x1 = (keyboard.nextInt())%2; 
      /*The scanner object reads the user input, computes that
      input mod 2, and stores that result as x1.*/
      if (x1 == 1){/*If the user entered an odd number.*/
         symbol = '*';
      }
      else{/*If the user entered an even number*/
         symbol = '$';
      }
      System.out.println(symbol + " " + symbol + " " + symbol +
                         " " + symbol);
      System.out.println(" " + symbol + " " + symbol + " " +
                         symbol);
      System.out.println("  " + symbol + " " + symbol);
      System.out.println("   " + symbol);    
      /*Each line of the System.out.print command prints a row
      of the triangle. The spaces align the digits.*/
   }
}      