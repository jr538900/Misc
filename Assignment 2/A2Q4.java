/*CSCI 1100-Assignment 2-"Question 4"
This program will calculate the shipping cost for a shoe order.
<Jeremy Peters><B00707976> <Nov 6, 2016>*/

import java.util.Scanner;
public class A2Q4{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter the number of pairs of shoes: ");
      int n = keyboard.nextInt();//records number of shoes.
      double sumOfPrices, costShippingFee, p, locShippingFee;
      String shippingLocation;
      /*sumOfPrices is the subtotal of each user-entered price.
      costShippingFee is the shipping fee based on the subtotal.
      p is the percentage of the total cost that determines the
      shipping fee based on cost.
      locShippingFee is the shipping fee based on the destination.
      Shipping location is the destination itself.*/ 
      sumOfPrices = 0;
      for(int i=1;i<=n;i++){
      /*Reads the price of each shoe pair, and updates the total*/
         System.out.print("Enter the price of pair"+i+" : $");
         sumOfPrices+=keyboard.nextDouble();
      }
      if(sumOfPrices<100)//subtotal is less than $100
         p = 0.25;//cost-based shipping fee is 25% of the subtotal.
      else if(sumOfPrices>=100 && sumOfPrices<=200)
      //Subtotal is between $100 and $200
         p = 0.15;//cost-based shipping fee is 15% of the subtotal.
      else//Subtotal is greater than $200
         p = 0.10;//cost-based shipping fee is 10% of the subtotal.
      costShippingFee = p*sumOfPrices;
      System.out.print("\nWhere would you like to ship your sho");
      System.out.print("es:\nNova Scotia, Canada, or Other: ");
      keyboard.nextLine();
      shippingLocation = keyboard.nextLine();
      while((shippingLocation.equals("Nova Scotia")==false) &&
            (shippingLocation.equals("Canada")==false) &&
            (shippingLocation.equals("Other")==false)){
      System.out.print("That is an incorrect location. " + 
                       "Please try again! \n");
      System.out.print("\nWhere would you like to ship your sho");
      System.out.print("es:\nNova Scotia, Canada, or Other: ");                                   
      shippingLocation = keyboard.nextLine();
      /*This while loop ensures the user inputs only "Nova Scotia,"
      "Canada," or "Other," which are used in future if statements.*/                 
      }                       
      if(shippingLocation.equals("Nova Scotia"))
         locShippingFee = 0;
      /*No additional shipping fee if Nova Scotia is the destination*/
      else if(shippingLocation.equals("Canada"))
         locShippingFee = 25;
      /*$25 additional shipping fee if the shipping destination is 
      anywhere in Canada except Nova Scotia.*/   
      else
         locShippingFee = 50;
      /*$50 additional shipping fee for any destination outside Canada.*/      
      /*The following outputs are controlled to two decimal places.*/
      System.out.printf("\nTotal cost for all shoes: $%.2f",
                        sumOfPrices);//prints subtotal
      System.out.printf("\nShipping fee on order amount: $%.2f",
                        costShippingFee);//prints cost-based shipping. 
      System.out.printf("\nShipping fee on destination: $%.2f",
                        locShippingFee);//prints destination shipping.
      double grandTotal = sumOfPrices + costShippingFee +
                          locShippingFee;
      System.out.printf("\nTOTAL COST OF ORDER: $%.2f",
                        grandTotal);//prints final total.                                                                                                                                                       
   }
}                   
                      
   
         
      
      
      

               
                        
            
                              
                  
              
      
                     
   
   
    