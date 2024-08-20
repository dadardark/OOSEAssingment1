package edu.curtin.app;
import java.io.*;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Reads in the first line of the grid.txt file and returns a string array containing the coordinates.
*/

public class ReadCoords {

    public static String[] readCoords(String fileName){
        String[] parts = null;
        try(var reader = new BufferedReader(new FileReader(fileName))){
            
            String line = reader.readLine();
            for(int x = 0; x < 1; x++) {
                 parts = line.split(",");
            }
    
        }
        catch(IOException e){
            System.out.println("Error");
        }
        return parts;
    }
}
