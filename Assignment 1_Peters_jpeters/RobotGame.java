/*CSCI 1101 – Assignment 1 – RobotGame.java
This program uses a robot object and moves it across a board.   
<Jeremy Peters> <B00707976>  <Feb 6, 2017> */

import java.util.Scanner;
public class RobotGame
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Welcome to the Robot Game Simulator!");
      
      //Two robot objects are created with user specified names and directions.
      String name1, dir1, name2, dir2;      
      System.out.print("\nEnter the name of the first robot: ");
      name1 = keyboard.nextLine();
      System.out.print("Enter the direction of the first robot: ");
      dir1 = keyboard.nextLine();
      System.out.print("\nEnter the name of the second robot: ");
      name2 = keyboard.nextLine();
      System.out.print("Enter the direction of the second robot: ");
      dir2 = keyboard.nextLine();
      Robot r1 = new Robot(name1, dir1);   
      Robot r2 = new Robot(name2, dir2);
      
      //The simulation starts if the robots start at (1,1).
      //The intial position and direction of the robot is printed.
      if(r1.isReady() && r2.isReady())
      {
         System.out.println("\nSimulation started!");
         System.out.println(r1);
         System.out.println(r2);
      }
      
      //This statement is designed to avoid an infinite loop if something went wrong.
      else
         System.out.println("\nSimulation cannot start.");
      
      //Stores the specified number of steps the robot moves, which will be determined by a randomly generated number(1, 2, or 3).
      //i is a counter to prevent an infinite loop.
      int steps, i = 0;
      
      //Since neither robot has reached the endpoint, they each make a move.
      //The last two tests in the "while" loop statement are a failsafe that stop the loop eventually
      while(r1.isReady() && r2.isReady() && i<100)
      {
         System.out.println("\nMove!");                
                  
         //The number of steps is determined for robot r1.
         //Then Robot r1 moves if its move is legal. 
         steps = (int)(Math.random()*(3-1+1))+1;                            
         if(r1.staysOnBoardAfterMoving(steps) && !r1.bumpsInto(r2, steps))
         {  
            r1.move(steps);            
         }
         
         //The number of steps is determined for robot r2.                
         //Robot r2 moves if its move is legal.
         steps = (int)(Math.random()*(3-1+1))+1;                       
         if(r2.staysOnBoardAfterMoving(steps) && !r2.bumpsInto(r1, steps))
         {   
            r2.move(steps);                        
         }
            
         //The new directions for the first and second robots are now reset.
         //These directions are determined by randomly generated numbers (1, 2, or 3).   
         r1.setDir((int)(Math.random()*(3-1+1))+1);
         r2.setDir((int)(Math.random()*(3-1+1))+1);
                           
         //Both robots' names, positions, and points are collected and printed out.
         System.out.println(r1);
         System.out.println(r2);    
         
         //The robots's positions are now compared and the result is printed, unless one robot is finished.         
         if(!r1.hasFinished() && !r2.hasFinished())
         {
            if(r1.amIAhead(r2))
               System.out.println(r1.getName() + " ahead!");
            else if(r2.amIAhead(r1))
               System.out.println(r2.getName() + " ahead!");
            else 
               System.out.println("Both are at the same distance from the goal!");
         }
         i++;                                         
      }
      
      //Since the program has reached this point, one of the robots has reached the end goal.
      //We now find out which robot has reached this goal, print out the winner, and continue moving the other robot.
      
      //Robot r1 has finished
      if(r1.hasFinished())
      {
         //Robot r1 is now printed to have reached the goal.
         System.out.println("\n" + r1.getName() + " has reached the goal (" + r1.getPts() + " points)");
         
         //Robot r2 is still playing.
         finishGame(r2);              
      }
      
      //Robot r2 has finished
      else if(r2.hasFinished())
      {
         //Robot r2 is now printed to have reached the goal.
         System.out.println("\n" + r2.getName() + " has reached the goal (" + r2.getPts() + " points)");
         
         //Robot r2 is still playing.
         finishGame(r1);
      }
      
      //Neither robot has finished due to an error.
      else
      {
         System.out.println("\nThere was an error in the simulation.");
      }                                                             
   }
   
   //This method will move one robot object to the end and finish the game.
   public static void finishGame(Robot r)
   {
      //Steps increments the robot's move, and j is a counter that prevents an infinite loop.
      int steps, j = 0;
      while(!r.hasFinished() && j<100)
      {
         System.out.println("\nMove!");
            
         //The number of steps are randomly determined and r moves (if legal)
         steps = (int)(Math.random()*(3-1+1)+1);
         if(r.staysOnBoardAfterMoving(steps))
            r.move(steps);
               
         //The direction is now reset 
         r.setDir((int)(Math.random()*(3-1+1)+1));   
         
         //The moving robot's name, position, and points are printed out.
         System.out.println(r);
         
         j++;
      }
      
      //The loop quit, but r has not finished yet, so an error message is printed.
      if(!r.hasFinished())
         System.out.println("\nThere was an error in the simulation.");
      //Robot r is now printed to have reached the goal, and the game ends smoothly.
      else   
      {         
         System.out.println("\n" + r.getName() + " has reached the goal (" + r.getPts() + " points)");
         System.out.println("\nGame over!");
      }   
   }   
}      