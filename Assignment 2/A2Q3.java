/*CSCI 1100-Assignment 2-"Question 3"
This program will find the matching characters between two user-
entered words. 
<Jeremy Peters><B00707976> <Nov 6, 2016>*/

import java.util.Scanner;
public class A2Q3{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter two words: ");
      String word2 = keyboard.next(), word1 = keyboard.next();
      //Two inputted words are stored.
      int n1 = word1.length(), i, j=0;
      /*n1 is the length of word1, i and j are counters 
      (see future comments).*/
      for(i=n1-1;i>=0;i--){
      /*i corresponds to the character positions of the first
      entered word (word1).  Note that i starts at the last 
      character, and ends at the first character of word1.*/
         char ch1 = word1.charAt(i);
         /*The character in word1 at position i will be
         referred to the "character of interest."*/
         int index2 = word2.indexOf(ch1,0);
         /*This determines where (or if) the character of 
         interest occurs in word2, the second entered word.*/
         int index1 = word1.indexOf(ch1,i+1);
         /*This will determine if the character of interest 
         occurs after position i in word1.  If this is the case,
         then the program has encountered the character of
         interest, because the program is working backwards.*/  
         if(index2!=-1 && index1==-1){
         /*The character of interest is found in word2, and
         has not already been encountered in word1.*/
            if(j==n1-1-i)
               System.out.print("Common Letters are : ");
            /*j counts the number of characters in word1 that
            were encountered and not matched to any characters
            in word2.  When the program starts, i and j add up
            to n-1, until (and including) the finding of the 
            first match.  Since a match was found, and i+j=n1-1,
            this match is the first match, and the output is 
            justified.*/    
            System.out.print(ch1);//prints character of interst.
         }   
         else//Character of interest is not in word2
            j+=1;//Counter of non-matching letters updates by 1.
         }
         if(j==n1)
            System.out.print("No Common Letters!");
         /*Since j counts the number of non matching letters, 
         no matching characters were found if j is the length 
         of word1.*/
         System.out.println();                        
   }
}                
   
         
      
      
      

               
                        
            
                              
                  
              
      
                     
   
   
    