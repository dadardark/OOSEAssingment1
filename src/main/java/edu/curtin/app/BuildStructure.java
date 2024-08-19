package edu.curtin.app;
import java.util.*;

public class BuildStructure{

    public static Terrain findStructure(ArrayList<Terrain> grid,String[] coords, int xCoord, int yCoord){

        int gridSizeX = Integer.parseInt(coords[0]);
        int x = 1;
        int y = 1;
        Terrain buildTerrain = null;

        for(Terrain terrain: grid){
            if(x == xCoord && y == yCoord){
                buildTerrain = terrain;
                return buildTerrain;
           }
            if (x == gridSizeX){
                y++;
                x = 0;
            }
            x++;
        }

        System.out.println("Grid location not found");
        return null;
    }

    public static String buildStructure(Terrain terrain, int floors, int foundation, int material){
        String matString = null;

        if(material == 1){matString = "wood";}
        else if(material == 2){matString = "stone";}
        else if(material == 3){matString = "brick";}
        else if(material == 4){matString = "concrete";}

        System.out.println(terrain.description());

        if(TerrainGetters.getSwampy(terrain)!= null && foundation == 1){
            return ("Cannot build a slab foundation in a " + TerrainGetters.getSwampy(terrain).getSwampy());
        }
        else if (TerrainGetters.getSwampy(terrain) != null && material == 1){
            return ("Cannot build with wood foundation in a " + TerrainGetters.getSwampy(terrain).getSwampy());
        }
        else if (TerrainGetters.getHeritage(terrain)!= null && !(TerrainGetters.getHeritage(terrain).getHeritage()).equals(matString)){
            return ("Cannot build with different heritage materials: Heritage: " + TerrainGetters.getHeritage(terrain).getHeritage() + " != Inputted: " + matString);
        }
        else if(TerrainGetters.getHeight(terrain) != null && floors > TerrainGetters.getHeight(terrain).getHeight()){
            return ("Cannot build above the height limit. Input floors: " + floors + " > Max floors: " + TerrainGetters.getHeight(terrain).getHeight());
        }
        else if (TerrainGetters.getFlood(terrain)!= null && floors < 3){
            return("Cannot have less than two floors in a flood-risk zone. Input floors: " + floors + " Flood factor: " + TerrainGetters.getFlood(terrain).getFloodRisk());
        }
        else {
            return("Structure can be built for a cost of: " + String.format("%.2f",costStructure(terrain, floors, foundation, matString)));
            
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
