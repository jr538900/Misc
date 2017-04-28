import java.io.*;
import java.util.Scanner;

public class Test2
{
   public static void main(String[] args) throws IOException
   {
      Scanner reader = new Scanner(new File("users.txt"));
      while(reader.hasNext())
      {
         System.out.println(reader.next());
         
      }
   }
}         
   