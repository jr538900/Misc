/*CSCI 1100-Assignment 2-"Question 1"
This program will list all positive factors of a user-entered
number.
<Jeremy Peters><B00707976> <Nov 6, 2016>*/

import java.util.Scanner;
public class A2Q1{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter a number: ");
      int n = keyboard.nextInt(), i=1;
      System.out.print("Factors: ");
      //n is the entered number, and i is a counter.
      while(i<=n){//Counter ranges from 1 to n.
         if(n%i==0)//n is divisible by the counter. 
            System.out.print(i+" ");
         /*If n is divisible by the counter, the counter is a
         factor, and will be outputted.*/   
         i++;//Updates counter.
      }
   }
}
         
      
      
      

               
                        
            
                              
                  
              
      
                     
   
   
    