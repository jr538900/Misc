/*CSCI 1100-Assignment 3 -"Question 2"
This program will calculate the amount of gas required to travel fro
from Halifax to Toronto, and the resulting cost.
<Jeremy Peters><B00707976> <Nov 6, 2016>*/

public class A3Q2{
   public static void main(String[] args){
      String[ ] city = {"Halifax", "Moncton", "Fredericton",
      "Quebec City", "Montreal",  "Toronto"};
      //Stores the stopping points along the trip.
      int[] distance = {260, 180, 520, 250, 504, 0};
      //Stores distances from current location to the next stop.
      double [] price = {1.1, 1.0, 1.15, 0.98, 1.01, 0};
      //Stores the price of gas per litre at each location.
      double buyGas, cost, amountOfGas, kmpl, maxGas;
      maxGas = 40;//Stores maximum fuel capacity (litres)
      kmpl = 13;//Stores fuel efficiency (kilometres per litre)
      amountOfGas = 0;//Stores amount of gas currently in tank.        
      double totalGas = 0, totalCost = 0;
      /*TotalGas measures total gas consumed.  totalCost measures
      the total cost of buying the gas.*/ 
      System.out.print("Buy gas as follows:\n");
      for(int i=0; i<city.length-1; i++){
      //Computes gas needed at each stopping point along the trip.
         if(price[i]<price[i+1])
            buyGas = maxGas - amountOfGas;
            /*buyGas stores the recommended amount of gas the user
            should buy at that given stop.*/   
         /*This "if" statement  tells the program to capitalize on
         the cheaper price at this current location.*/
         else         
            buyGas = (distance[i]/kmpl) - amountOfGas;
         /*This "else" statement tells the program to only buy
         necessary amount of gas to get to the next stop.*/
         amountOfGas+=buyGas;//tank is refilled and updated.         
         cost = buyGas*price[i];
         /*stores the cost of the gas the user will buy*/
         totalGas+=buyGas;//updates total gas
         totalCost+=cost;//updates total cost
         System.out.printf(city[i]+": Buy %.0f litres Pay $%.2f\n",
         buyGas, cost);//prints gas purchased and cost at each stop.
         amountOfGas-=(distance[i]/kmpl);
         /*Gas is used up after leaving current location.*/
      }
      System.out.printf("You purchased %.0f Litres and the Total "+ 
                        "Cost would be $%.2f", totalGas, totalCost);
      //prints total amount of gas bought at each stop.                  
   }
}          
        