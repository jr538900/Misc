/*CSCI 1100-Assignment 3 -"Question 1"
This program will find characters in two user-entered strings that
are unique to each string. 
<Jeremy Peters><B00707976> <Nov 6, 2016>*/

import java.util.Scanner;
public class A3Q1{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      String input1, input2, result = " ";
      //will store user inputs and final result
      System.out.print("Enter a word: ");//asks for first input
      input1 = keyboard.nextLine();//stores first input
      System.out.print("Enter a word: ");//asks for second input
      input2 = keyboard.nextLine();//stores second input
      result = uniqueCharacters(input1, input2, result);
      /*This method will take each character from the first string
      and determine if that character is unique to the first string.
      The result will store all such unique characters.*/
      result = uniqueCharacters(input2, input1, result);
      /*Since we want unique characters for both user inputs, 
      reversing the arguments for the method call will ensure the
      second string will have its characters searched.*/
      if (result.equals(" "))
      //tells user if no unique characters are found
         System.out.print("No unique characters");
      else   
      System.out.print("Unique character/s:" + result);
      //prints final result if there are unique characters.
   }
   public static String uniqueCharacters(String word1, String word2,
   String unique){/*This method will update the string "unique" with
   characters in the first string not found in the second string.*/          
      char ch1;//selects a character in word1
      int index2, indexUnique;
      /*This will determine whether a character from word1 is found
      in word2 or the string "unique."*/ 
      for(int i=0; i<word1.length(); i++){
      //i determines which character in 1st word is analyzed.
         ch1 = word1.charAt(i);//stores a character in 1st word
         index2 = word2.indexOf(ch1, 0);//finds 'ch1' in 2nd word
         indexUnique = unique.indexOf(ch1, 0);
         //finds 'ch1' in the string "unique"  
         if(index2==-1 && indexUnique==-1)
         /*if 'ch1' is not present in the second word, and it is not
         already recorded in the string "unique," ch1 is added to 
         the string "unique."*/ 
            unique+=ch1+" ";//updates "unique"
      }
      return unique;
      /*returns the string which contains the unique characters to
      the first string.*/
   }
}
                  
      