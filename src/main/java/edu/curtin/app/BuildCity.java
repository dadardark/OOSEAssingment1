package edu.curtin.app;

import java.util.*;

public interface BuildCity {
    public void buildStructure(ArrayList<Terrain> grid,String[] coords, int floors, int foundation, int material);

    default Double costStructure(Terrain terrain, int floors, int foundation, String material){
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
        
        default void displayStructure(String[] coords,String[][] structures){
            final String RED_BOLD = "\033[1;31m";
            final String RESET = "\033[0m";  
            for(int x = 0; x <Integer.parseInt((coords[0]));x++){
                for(int y = 0; y <Integer.parseInt((coords[1]));y++){
                    if(structures[x][y].equals("x")){
                        System.out.print("|"+(x+1)+","+(y+1)+RED_BOLD+" x "+RESET);
                    }
                    else{
                        System.out.print("|"+(x+1)+","+(y+1)+"   ");
                    }  
            }
            System.out.print(" |");
            System.out.print("\n");
            
        }
    }
}
