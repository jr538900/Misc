/*CSCI 1100-Assignment 2-"Question 2"
This program will determine whether a user-entered word is a 
palindrome (reads the same forwards and backwards).
<Jeremy Peters><B00707976> <Nov 6, 2016>*/

import java.util.Scanner;
public class A2Q2{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter a word: ");
      String word = keyboard.next();//Stores entered word.
      String lwrWord = word.toLowerCase();
      int n=word.length(); 
      /*Changes word to lowercase. The definition of a 
      palindrome ignores cases.*/
      System.out.print(word+" is");
      /*The final output is split up so that the program can
      inject the word "not" into the phrase "is a palindrome,"
      if necessary.*/
      for(int i=0; i<=n/2; i++){
         if(lwrWord.charAt(i)!=lwrWord.charAt(n-1-i)){
            System.out.print(" NOT");
            i=(n/2)+1;//Exits the loop by making the test false.
         }   
      }/*This for loop will match the first character with 
      the last character, the second character with the second 
      last character, and so on, until the middle of the word.
      If, at any point, the corresponding characters don't 
      match, the word is not a palindrome, the program will 
      change the output accordingly, and prematurely exit the 
      loop.*/   
      System.out.print(" a Palindrome!");
   }
}      
   
         
      
      
      

               
                        
            
                              
                  
              
      
                     
   
   
    