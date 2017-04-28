/*CSCI 1100-Assignment 1-"Question 6"
This program will sort three numbers from largest to smallest and
sum them.  These three numbers are entered by the user.
<Jeremy Peters><B00707976> <Oct 23, 2016>*/

import java.util.Scanner;
public class A1Q6{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      int a, b, c, max, med, min, sum;
      /*All variables are declared.
      a, b, c will store the user input, max, med, min could each
      be any one of a, b, or c depending on the relative values 
      of a, b, and c.  sum is the sum of a, b, and c.*/
      System.out.println("Enter three different numbers: ");
      System.out.print("First number: ");
      a = keyboard.nextInt();
      System.out.print("Second number: ");
      b = keyboard.nextInt();
      System.out.print("Third number: ");
      c = keyboard.nextInt();
      /*The following statements will compare each number to each
      other number and store the largest number as the variable
      "max," the second largest number as the variable "med," and
      the smallest number as the variable "min."*/
      if (a>b && a>c){//Checks if a is the largest number. 
         max = a;
         if (b>c){//Compares the lower two numbers b and c.
            med = b;
            min = c;
         }
         else{//c<b.
            med = c;
            min = b;
         }
      }   
      else if (b>a && b>c){//Checks if b is the largest number.
         max = b;
         if (a>c){//Compares the lower two numbers a and c.
            med = a;
            min = c;
         }
         else{//c<a.
            med = c;
            min = a;
         }
      }   
      else{//The final possibility: c is the largest number.
         max = c;
         if (a>b){//Compares the lower two numbers a and b.
            med = a;
            min = b;
         }
         else{//b<a
            med = b;
            min = a;
         }
      }
      sum = a + b + c;
      /*The results of comparison are now printed.*/
      System.out.println("The sum of "+a+", "+b+", and " + 
                         +c+" is "+sum);
      System.out.println("The largest number is "+max);
      System.out.println("The smallest number is "+min);
      System.out.print("The numbers from largest to smallest "+  
                       "are: "+max+", "+med+", "+min+".");   
   }
}               
                        
            
                              
                  
              
      
                     
   
   
    