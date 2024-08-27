package edu.curtin.app;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Reads in a grid.txt file. Parses the data and creates terrain objects with one of the 3 terrain types: 
 * Flat, Swampy or Rocky, if applicable.
 * Then tries to recursivley aggreate zoning rules, as read in from the file, onto the terrain objects.
*/

public class ReadFile
{
    private static final Logger logger = Logger.getLogger(ReadFile.class.getName());
    public static List<Terrain> readMap(String fileName)
    {
        var terrains = new ArrayList<Terrain>();
        
        try(var reader = new BufferedReader(new FileReader(fileName))){

            String line = reader.readLine();
            int lineNo = 0;
            while(line != null) {
                try{
                Terrain terrain = null;
                

                String[] parts = line.split(",");

                switch(parts[0]){
                    case "swampy":
                        terrain = new Swampy(parts[0]);
                        lineNo++;
                        break;

                    case "rocky":
                        terrain = new Rocky(parts[0]);
                        lineNo++;
                        break;

                    case "flat":
                        terrain = new Flat(parts[0]);
                        lineNo++;
                        break;

                    default:
                    lineNo++;
                    if(lineNo > 1){
                        logger.warning("Invalid input format for terrain");
                        throw new InvalidTerrainException();
                    }
                }
                    for(int i = 1; i < parts.length; i++){
                        String[] zoneSplit = parts[i].split("=");
                        switch (zoneSplit[0]) {
                            case "heritage":
                            if(zoneSplit.length == 2) {
                                if(zoneSplit[1].equals("wood") || zoneSplit[1].equals("stone") || zoneSplit[1].equals("brick") ){
                                    terrain = new Heritage(terrain, zoneSplit[1]);
                                }
                            }
                                break;

                            case "height-limit":
                            if(zoneSplit.length == 2) {
                                if(Integer.parseInt(zoneSplit[1]) > 0) {
                                    terrain = new Height(terrain, Integer.parseInt(zoneSplit[1]));
                                }
                            }
                                break;
                            
                            case "flood-risk":
                            if(zoneSplit.length == 2) {
                                if(Double.parseDouble(zoneSplit[1]) > 0) {
                                    terrain = new Flood(terrain, Double.parseDouble(zoneSplit[1]));
                                }
                            }
                                break;

                            case "contamination":
                                terrain = new Contamination(terrain, true);
                                break;
                        
                            default:
                            if(lineNo > 1){
                                logger.warning("Invalid input paramaters for zoning paramaters");
                                }
                                break;
                            } 
                    }  
            
                    if(terrain != null) {
                        terrains.add(terrain);
                    }
                }catch(InvalidTerrainException e){
                    System.out.println(e.getMessage(lineNo));
                    terrains.add(new Flat("flat"));
                }
                    line = reader.readLine();
            }
        }
        catch(IOException e){
            logger.severe("Invalid filename. Failed to read.");
            return null;
        }
        return terrains;
    }
}
