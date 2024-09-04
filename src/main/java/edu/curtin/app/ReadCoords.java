package edu.curtin.app;
import java.io.*;
import java.util.logging.Logger;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Reads in the first line of the grid.txt file and returns a string array containing the coordinates.
*/

public class ReadCoords {
    private static final Logger logger = Logger.getLogger(ReadCoords.class.getName());

    public static String[] readCoords(String fileName) throws InvalidCoordException{
        String[] parts = null;
        try(var reader = new BufferedReader(new FileReader(fileName))){
            
            String line = reader.readLine();
            for(int x = 0; x < 1; x++) {
                 parts = line.split(",");
            }
            if(Integer.parseInt(parts[0]) < 1 || Integer.parseInt(parts[1]) < 1 || parts.length != 2){
                throw new InvalidCoordException();
            }
    
        }
        catch(IOException e){
            logger.severe("Invalid filename. Failed to read.");
            return null;
        }
        return parts;
    }
}
