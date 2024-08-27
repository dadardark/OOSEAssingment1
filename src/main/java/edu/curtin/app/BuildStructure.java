package edu.curtin.app;
import java.util.*;
import java.util.logging.*;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Attempts to build a user-defined structure on a single grid square.
 * NOTE: This class has static functions and does not follow the Strategy/Template pattern. 
 * It is unable to implement the BuildCity interface as it requires a function to find the grid square and it's buildStructure
 * function paramater is a single Terrain object rather than a list of Terrain objects.
*/

public class BuildStructure{
    private static final Logger logger = Logger.getLogger(BuildStructure.class.getName());
    private static String green = "\033[1;32m";
    private static String red = "\033[1;31m";
    private static String reset = "\033[0m"; 

    public static Terrain findStructure(List<Terrain> grid,String[] coords, int xCoord, int yCoord){

        int gridSizeX = Integer.parseInt(coords[0]);
        int x = 1;
        int y = 1;

        for(Terrain terrain : grid){
        if(terrain != null){
            if(x == xCoord && y == yCoord){
                return terrain;
           }
            if (x == gridSizeX){
                y++;
                x = 0;
            }
            x++;
        }
    }
        
        logger.severe("Grid location parsed in incorrectly");
        System.out.println("Grid location not found");
        return null;
    }

    public static String buildStructure(Terrain terrain, int floors, int foundation, int material){
        String matString = null;

        if(material == 1){matString = "wood";}
        else if(material == 2){matString = "stone";}
        else if(material == 3){matString = "brick";}
        else if(material == 4){matString = "concrete";}

        if(terrain != null){
            System.out.println(terrain.description() +"\n");

            if(TerrainGetters.getSwampy(terrain)!= null && foundation == 1){
                return (red+"Cannot "+reset + "build a slab foundation in a "+ TerrainGetters.getSwampy(terrain).getSwampy()+"\n\n");
            }
            else if (TerrainGetters.getSwampy(terrain) != null && material == 1){
                return (red+"Cannot "+reset + "build with wood foundation in a " + TerrainGetters.getSwampy(terrain).getSwampy()+"\n\n");
            }
            else if (TerrainGetters.getHeritage(terrain)!= null && !(TerrainGetters.getHeritage(terrain).getHeritage()).equals(matString)){
                return (red+"Cannot "+reset + "build with different heritage materials: Heritage: " + TerrainGetters.getHeritage(terrain).getHeritage() + " != Inputted: " + matString+"\n\n");
            }
            else if(TerrainGetters.getHeight(terrain) != null && floors > TerrainGetters.getHeight(terrain).getHeight()){
                return (red+"Cannot "+reset + "build above the height limit. Input floors: " + floors + " > Max floors: " + TerrainGetters.getHeight(terrain).getHeight()+"\n\n");
            }
            else if (TerrainGetters.getFlood(terrain)!= null && floors < 2){
                return(red+"Cannot "+reset + "have less than two floors in a flood-risk zone. Input floors: " + floors + " Flood factor: " + TerrainGetters.getFlood(terrain).getFloodRisk()+"\n\n");
            }
            else {
                return("Structure "+green+ "can"+reset+ " be built for a cost of: " +green+ String.format("$" + "%.2f\n\n",costStructure(terrain, floors, foundation, matString))+reset);
                
            }
        }
        else{
            logger.severe("Grid location parsed in incorrectly");
            return null;

        }
    } 

    public static Double costStructure(Terrain terrain, int floors, int foundation, String material){
        double totalCost = 0;

        if(material.equals("wood")){
            totalCost = 10000*floors;
        }
        else if(material.equals("stone")){
            totalCost = 50000*floors;
        }
        else if(material.equals("brick")){
            totalCost = 30000*floors;
        }
        else if(material.equals("concrete")){
            totalCost = 20000*floors;
        }
        
        if(TerrainGetters.getSwampy(terrain)!= null){
            totalCost = totalCost + (20000*floors);
        }
        if(TerrainGetters.getRocky(terrain)!= null){
            totalCost = totalCost + 50000;
        }
        if(TerrainGetters.getContamination(terrain)!= null){
            totalCost = totalCost *1.5;
        }
        if(TerrainGetters.getFlood(terrain)!= null){
            totalCost = totalCost * (1+(TerrainGetters.getFlood(terrain).getFloodRisk()/50));
        }

        return totalCost;
    }

    
}
