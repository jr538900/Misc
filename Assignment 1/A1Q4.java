/*CSCI 1100-Assignment 1-"Question 4"
This program will tell the user one of two different stories.
This program will calculate the final cost of an airline 
ticket after applying a discount (which depends on whether 
the user is a student, senior, or neither), and then applying
tax.
<Jeremy Peters><B00707976> <Oct 23, 2016>*/

import java.util.Scanner;
public class A1Q4{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      int num;
      double regPrice, taxRate, discountRate, discountPrice, 
             priceAfterDiscount, tax, total;
      System.out.print("Enter the price of the flight: $");
      regPrice = keyboard.nextDouble();
      /*The user enters the initial price of the ticket.*/
      System.out.print("Enter the tax rate (as a %): ");
      taxRate = (keyboard.nextDouble())/100;
      /*The user enters the tax rate as a percentage, and 
      the computer comverts this percentage to a decimal,
      and stores the resulting value.*/
      System.out.print("Enter 1 for student, 2 for senior, " +
                       "or 3 for neither: ");
      num = keyboard.nextInt();
      if (num == 1){
      /*For 20% student discount rate*/
         discountRate = 0.2;
      }
      else if (num == 2){
      /*For 10% senior discount rate.*/
         discountRate = 0.1;
      }   
      else{
      /*For all others to whom the discount doesn't apply*/
         discountRate = 0;
      }
      discountPrice = discountRate * regPrice;
      /*Applies the relevant discount rate to the original
      price to get the discount on the ticket price.*/
      System.out.println("Discount on price of ticket: $" + 
                         discountPrice);
      priceAfterDiscount = regPrice - discountPrice;
      /*Subtracts the discount on the ticket price from the 
      original price.*/           
      System.out.println("Price of ticket (after discount): " +
                         "$" + priceAfterDiscount);
      tax = taxRate * priceAfterDiscount;
      /*Applies the tax rate the user entered to the price
      after the discount was applied.*/
      System.out.println("Tax: $" + tax);
      total = priceAfterDiscount + tax;
      /*Calculates the total after discount and tax.*/ 
      System.out.println("Total: $" + total);                 
   }
}                     
   
   
    