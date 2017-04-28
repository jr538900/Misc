/*CSCI 1101 – Assignment 3 – Airport.java
This program will code for an airport object with a specified 3-character name. 
<Jeremy Peters> <B00707976>  <Mar 17, 2017> */

public class Airport
{
   //Stores the name of the airport
   private String name;
   
   //Constructor sets the airport's name if this name is 3 characters long.
   public Airport(String name)
   {
      this.name = name;
   }
   
   //Get and set methods provide and update the Airport name, respectively.
   public String getName()
   {
      return name;
   }
   public void setName(String name)
   {
      this.name = name;
   }
   
   //toString method will print the name of the airport.
   public String toString()
   {
      return name;
   }
   
   //This method will check the input Airport name.
   public static boolean hasGoodChars(String name)
   {
      boolean valid = true;
      //The name is not the correct length.
      if(name.length()!=3)
         valid = false;
      //The name is the correct length.
      else
         //This loop will update valid to false 
         for(int i=0; i<3; i++)
            //Each character in the name must have an ascii value between 65 (for 'A') and 90 (for 'Z')
            if(name.charAt(i)<65 || name.charAt(i)>90)
               valid = false;
      
      return valid;
   }                                      
}              