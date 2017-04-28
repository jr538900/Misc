/*CSCI 1101 – Assignment 3 – Airline.java
This program will code for an airline object, whose name has fewer than 6 alphanumeric characters. 
<Jeremy Peters> <B00707976>  <Mar 17, 2017> */

public class Airline
{
   //Stores the name of the airline.
   private String name;
   
   //Constructor creates the Airline object if the input name is valid (i.e. length less than 6)
   public Airline(String name)
   {
      this.name = name;
   }
   
   //Get and set methods provide the name and update the name, respectively.
   public String getName()
   {
      return name;
   }
   public void setName(String name)
   {
      this.name = name;
   }
   
   //This method prints the name of the airline.             
   public String toString()
   {
      return name;
   }
}             