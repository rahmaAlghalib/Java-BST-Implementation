
package UberSystemProgram;

import java.util.*;
import java.io.*;

public class MainProgram {
    
    public static void main (String [] args) throws FileNotFoundException{
        
     File inputFile = new File("input.txt");   
     File outputFile = new File("output.txt");
     
     if(!inputFile.exists()){
         System.out.println("The File " + inputFile + " dosen't exists");
         System.exit(0);
         
     }
     
     
     Scanner input = new Scanner(inputFile);
     
     PrintWriter output = new PrintWriter(outputFile);
     
     String command;
     UberTree uber = new UberTree();
     
     output.println("--------------- Welcome to Uber Booking System ---------------");
     
     do{
         
         command = input.next();
         
         if(command.equalsIgnoreCase("Add_Captain")){
             
           output.println("Command Add_Captain: Add a new captain record in the System");
           output.println();
           uber.add_captain(input.nextInt(), input.next(), output);
           output.println();
           output.println("----------------------------------------------------------------");
             
         }
         
         else if(command.equalsIgnoreCase("BOOK_RIDE")){
             
           uber.bookRide(input.nextInt(), output);
           output.println();
           output.println("----------------------------------------------------------------");
             
         }
         
         else if(command.equalsIgnoreCase("DISPLAY_CAPTAIN_INFO")){
     
           uber.displayInfo(input.nextInt(), output);
           output.println();
           output.println("----------------------------------------------------------------");
             
         }
         
         else if(command.equalsIgnoreCase("FINISH_RIDE")){
             
           uber.finishRide(input.nextInt(), input.nextInt(), output);
           output.println("----------------------------------------------------------------");
             
         }
         
         else if(command.equalsIgnoreCase("DELETE_CAPTAIN")){
             
           uber.deleteCaptain(input.nextInt(), output);
           output.println("----------------------------------------------------------------");
             
         }
         
         else if(command.equalsIgnoreCase("DISPLAY_ALL_CAPTAINS")){
             
           output.println("Command DISPLAY_ALL_CAPTAINS:");
           uber.displayAllCaptains(output);
           
             
         }

     }while(!command.equalsIgnoreCase("Quit"));
     
     output.println("Thank you for using Uber System, Good Bye!");
     
     input.close();
     output.flush();
     output.close();
        
        
        
    }
    
}
