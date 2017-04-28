/*CSCI 1101 – Assignment 3 – Flight.java
This program will code for an "Flisht" object. 
<Jeremy Peters> <B00707976>  <Mar 17, 2017> */

public class Flight
{
   //Determines the type of airline for this flight.
   private Airline airline;
   //Stores the identification of the flight.
   private String id;
   //Determines the original airport, and destination airport, respectively.
   private Airport origAirport;
   private Airport destAirport;
   //Keeps track of the seats for the flight.
   private Seat[][] seats;
   
   //constructor will create a new flight object with specified
   //airline name, origin airport, destination airport, and ID number.
   public Flight(String	aname, String orig, String dest, String id)
   {
      //Determines the airline name.
      airline = new Airline(aname);      
      //Sets the origin and destination airports.   
      origAirport = new Airport(orig);
      destAirport = new Airport(dest);
      //Determines the flight id.      
      this.id = id;           
   }
       
   //Get methods provide the necessary attributes.
   public Airline getAirline()
   {
      return airline;
   }
   public String getID()
   {
      return id;
   }
   public Airport getOrigAirport()
   {
      return origAirport;
   }
   public Airport getDestAirport()
   {
      return destAirport;
   }
   public Seat[][] getSeats()
   {
      return seats;
   }
   //Set methods establish the necessary attributes.
   public void setAirline(Airline airline)
   {
      this.airline = airline;
   }
   public void setID(String id)
   {
      this.id = id;
   }
   public void setOrigAirport(Airport origAirport)
   {
      this.origAirport = origAirport;
   }
   public void setDestAirport(Airport destAirport)
   {
      this.destAirport = destAirport;
   }
   public void setSeats(Seat[][] seats)
   {
      this.seats = seats;
   }
   
   //toString displays the airline, flightID, origin airport, destination airport, and seats.
   public String toString()
   {
      String result =  "\nAirline: " + airline + "\n" + "Flight ID: " + id + "\n"; 
      result += "Origin: " + origAirport + "\n" + "Destination: " + destAirport + "\n"; 
      result += "Seats:  ";
      //We now print each seat
      if(seats != null)
         for(int i=0; i<seats.length; i++)
         {
            if(i==0)
            {
               result += "\nRow#\t\t";
               for(int k=0; k<seats[i].length; k++)
                  result += (char)(k+65) + "      \t";            
            }      
            for(int j=0; j<seats[i].length; j++)
            {
               if(j==0)
                  result += "\n" + (i+1) + "   \t\t";
               result += seats[i][j] + "\t";
            }                    
         }
      else
         result += "The flight, " + id + "," + " has no seats.";
      result += "\n";      
           
      return result;
   }
   
    public static void main(String[] args)
   {  
      Flight flight = new Flight("ABC", "HFX", "TOR", "123");
      Seat[][] s = new Seat[30][6];
      for(int i=0; i<s.length; i++)
         for(int j=0; j<=5; j++)
            s[i][j] = new Seat(i+1, (char)(j+65));
      flight.setSeats(s);
      flight.getSeats()[2][3].book();
      flight.getSeats()[3][4].book();
      flight.getSeats()[4][5].book();
      flight.getSeats()[1][2].book();      
      System.out.print(flight);       
   }                             
}     
          
                      
   