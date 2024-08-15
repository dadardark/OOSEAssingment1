package edu.curtin.app;
import java.io.*;

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
