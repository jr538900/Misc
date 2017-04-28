import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Test
{
   public static void main(String[] args) throws IOException
   {
      Scanner lineReader = new Scanner(new File("users.txt"));
      String line = "";
      StringTokenizer token;
      String result = "";
      
      while(lineReader.hasNextLine())
      {
         line = lineReader.nextLine();
         token = new StringTokenizer(line, "%-10s");
         while(token.hasMoreTokens())
            result += token.nextToken() + "\t";
         result += "\n";                
      }
      System.out.println(result);
      lineReader.close();   
   }
   
   
}     