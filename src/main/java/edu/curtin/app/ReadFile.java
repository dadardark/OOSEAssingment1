package edu.curtin.app;
import java.io.*;
import java.util.ArrayList;
//import java.util.logging.Logger;

public class ReadFile
{
    public static ArrayList<Terrain> readMap(String fileName) 
    {
        var terrains = new ArrayList<Terrain>();
        
        try(var reader = new BufferedReader(new FileReader(fileName))){

            String line = reader.readLine();
            while(line != null) {
                Terrain terrain = null;

                String[] parts = line.split(",");

                switch(parts[0]){
                    case "swampy":
                        terrain = new Swampy(parts[0]);
                        break;

                    case "rocky":
                        terrain = new Rocky(parts[0]);
                        break;

                    case "flat":
                        terrain = new Flat(parts[0]);
                        break;
                    default:
                }

                for(int i = 1; i < parts.length; i++){
                    String[] zoneSplit = parts[i].split("=");
                    switch (zoneSplit[0]) {
                        case "heritage":
                        if(zoneSplit[1].equals("wood") || zoneSplit[1].equals("stone") || zoneSplit[1].equals("brick") ){
                            terrain = new Heritage(terrain, zoneSplit[1]);
                        }
                            break;

                        case "height-limit":
                        if(Integer.parseInt(zoneSplit[1]) > 0) {
                            terrain = new Height(terrain, Integer.parseInt(zoneSplit[1]));
                        }
                            break;
                        

                        case "flood-risk":
                        if(Double.parseDouble(zoneSplit[1]) > 0) {
                            terrain = new Flood(terrain, Double.parseDouble(zoneSplit[1]));
                        }
                            break;

                        case "contamination":
                            terrain = new Contamination(terrain, true);
                            break;
                    
                        default:
                            break;
                        } 
                    }  
                


                    if(terrain != null) {
                        terrains.add(terrain);
                    }
                    line = reader.readLine(); 
                }
            }
        catch(IOException e){
            System.out.println("Error");
        }
        return terrains;
    }
}
