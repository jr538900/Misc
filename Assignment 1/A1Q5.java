/*CSCI 1100-Assignment 1-"Question 5"
This program will identify the number of pairs of numbers 
that the user enters.
<Jeremy Peters><B00707976> <Oct 23, 2016>*/

import java.util.Scanner;
public class A1Q5{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      int a, b, c, d, n;
      /*a, b, c, d are the user entered numbers,
      and n is the number of pairs.*/
      System.out.println("Enter 4 numbers all from 0 and 9");
      System.out.print("1st number: ");
      a = keyboard.nextInt();
      System.out.print("2nd number: ");
      b = keyboard.nextInt();
      System.out.print("3rd number: ");
      c = keyboard.nextInt();
      System.out.print("4th number: ");
      d = keyboard.nextInt();
      /*The following statements tell the computer to determine 
      whether every possible pair of numbers are equal.
      This determines the value of n, the number of pairs.*/
      if (a == b){
         if (c == d){
            n = 2; //Two pair: (a,b) and (c,d)
         }
         else{
            n = 1; //One pair: (a,b)
         }
      }   
      else if (a == c){
         if (b == d){
            n = 2; //Two pair: (a,c) and (b,d)
         }
         else{
            n = 1; //One pair: (a,c)
         }
      }
      else if (a == d){
         if (b == c){
            n = 2; //Two pair: (a,d) and (b,c)
         }
         else{
            n = 1; //Two pair: (a,b) and (c,d)
         }
      }            
      /*At this point, "a" cannot be paired.
      There can be at most one pair.*/
      else if (b == c){
         n = 1;    //One pair: (b,c)
      }
      else if (b == d){
         n = 1;    //One pair: (b,d)
      }
      /*At this point, "b" cannot be paired.*/
      else if (c == d){
         n = 1;    //One pair: (c,d)
      }
      else{
         n = 0;    /*No pairs can be found.
      "a," "b," "c," and "d" are all unique.*/
      }
      System.out.print("There are " + n + " pair.");               
   }
}                     
                  
              
      
                     
   
   
    