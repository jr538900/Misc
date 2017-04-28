/*CSCI 1101 – Assignment 1 – Hangman.java
This program creates a "Hangman" object, with attributes of all secret words, a selected secret word, 
a disguised word, number of guesses totally, and number of incorrect guesses.
This object is used in "Hangmandemo.java" to simulate the game of hangman.   
<Jeremy Peters> <B00707976>  <Feb 6, 2017> */

public class Hangman
{
   private String[] secretWordDictionary = {"bulbasaur","ivysaur",
   "venusaur","charmander","charmeleon", "charizard", "squirtle",
   "wartortle", "blastoise", "caterpie", "metapod", "butterfree",
   "weedle", "kakuna", "beedrill", "pidgey", "pidgeotto",
   "pidgeot","rattata", "raticate", "spearow", "fearow", "ekans", "arbok",
   "pikachu"};                   //Stores the total collection of secret words.
   private char[] secretWord;    //Stores the secret word
   private char[] disguisedWord; //Stores the word replaced with the characters '?' that the user didn't guess. 
   private int numGuesses;       //Stores the number of guesses.
   private int numIncorrect;     //Stores the number of incorrect guesses entered by the user.
   
   //The rest of the code was not provided.
   
   //No-args constructor creates an empty hangman object.
   public Hangman()
   {
   }
   
   //Get methods for the disguised word, number of guesses made and number of incorrect guesses (all public)
   public char[] getDisguisedWord()
   {
      return disguisedWord;
   }
   public int getNumGuesses()
   {
      return numGuesses;
   }
   public int getNumIncorrect()
   {
      return numIncorrect;
   }
   
   //Set methods for secret word, disguised word, number of guesses made and number of incorrect guesses.
   //The setSecretWord method is private so that only this object has control over its secret word.
   private void setSecretWord(char[] sWord)
   {
      secretWord = new char[sWord.length];
      for(int i = 0; i< sWord.length; i++)
         secretWord[i] = sWord[i];         
   }
   public void setDisguisedWord(char[] dWord)
   {
      disguisedWord = new char[dWord.length];
      for(int i = 0; i<dWord.length; i++)
         disguisedWord[i] = dWord[i]; 
   }
   public void setNumGuesses(int numGuesses)
   {
      this.numGuesses = numGuesses;
   }
   public void setNumIncorrect(int numIncorrect)
   {
      this.numIncorrect = numIncorrect;
   }
   
   //This method generates a random number from 0 to 24 and selects the appropriate word from the secretWordDictionary.
   //This method converts this secret word into a char array and it in char[] word.
   public void generateSecretWord()
   {
      //makes secret word.
      int number = (int)(Math.random()*25);
      String word = secretWordDictionary[number];      
      setSecretWord(word.toCharArray());
      
      //makes corresponding disguised word.
      String hidWord = "";
      for(int i = 0; i<word.length(); i++)
         hidWord += '?';
      setDisguisedWord(hidWord.toCharArray());                                 
   }
   
   //makeGuess(char c) guesses that character c is in the word.
   //This method assumes that the input letter was not already guessed.
   public boolean makeGuess(char c)
   {
      //This variable controls whether the game continues.
      boolean keepPlaying;
      
      //The number of guesses increases.
      numGuesses++;
             
      //The method now searches the secret word for the input character.
      //The counter counts how many times the character appears in the secret word.
      //The variable "word" converts the secret word into a string so it can be easily printed out.
      int counter = 0;
      String word = "";   
      for(int i = 0; i<secretWord.length; i++)
      {
         word+=secretWord[i];
         if(secretWord[i] == c)
         {
            disguisedWord[i] = c;
            counter++;            
         }
      }
         
      //The result of the input is now analyzed.
      
      //Here, the input matches a character in the secret word, and the user is correct.
      if(counter>0)
      {
         //The word is found by the user, so the secret word is printed, the user wins, and the game stops.
         if(isFound())
         {
            System.out.println("\nSecret word: " + word + "\nYou win!");
            keepPlaying = false;   
         }
         //The user is correct, but the word is not completely found, so the user keeps playing.
         else
         {
            System.out.println("Correct.");
            keepPlaying = true;
         }   
      }
      
      //Here, the input does not match a character in the secret word
      else
      {
         //The number of incorrect guesses increases, and the user is told so.
         numIncorrect++;
         System.out.println("Incorrect. You have " + (6-numIncorrect) + " guesses left.");
         
         //If the user ran out of guesses, the game stops
         if(numIncorrect == 6)
         {
            System.out.println("\nThe secret word was " + word + "\nYou lose!");
            keepPlaying = false;
         }
         //The user has not run out of guesses and, thus, continues playing.   
         else
            keepPlaying = true;
      }
      return keepPlaying;                                  
   }
   
   //isFound returns true if the hidden word has been discovered.
   public boolean isFound()
   {
      boolean found = true;
      for(int i = 0; i<secretWord.length; i++)
         if(disguisedWord[i] != secretWord[i])
         {
            found = false;
            i = secretWord.length;
         }
      return found;
   }
   
   
   //This method tests the above class
   
   public static void main(String[] args)
   {
      //creates a new Hangman object and creates a secret word.
      Hangman game = new Hangman();
      game.generateSecretWord();
      
      //Prints the disguised word, and whether it is found.
      System.out.println(new String(game.getDisguisedWord()));
      System.out.println("Found: " + game.isFound());
      
      //Guesses are made, and the program prints the disguised word, and
      //booleans controlling whether the word is found or game should continue
      System.out.println("Play?: " + game.makeGuess('x'));
      System.out.println(new String(game.getDisguisedWord()));
      System.out.println("Play?: " + game.makeGuess('y'));
      System.out.println(new String(game.getDisguisedWord()));
      System.out.println("Play?: " + game.makeGuess('z'));
      System.out.println(new String(game.getDisguisedWord()));
      System.out.println("Play?: " + game.makeGuess('a'));
      System.out.println(new String(game.getDisguisedWord()));
      System.out.println("Play?: " + game.makeGuess('r'));
      System.out.println(new String(game.getDisguisedWord()));
      System.out.println("Play?: " + game.makeGuess('b'));
      System.out.println(new String(game.getDisguisedWord()));
      System.out.println("Play?: " + game.makeGuess('o'));
      System.out.println(new String(game.getDisguisedWord()));
      System.out.println("Play?: " + game.makeGuess('k'));
      System.out.println(new String(game.getDisguisedWord()));
      System.out.println("Found? " + game.isFound());                        
   }   
                                     
}