package edu.curtin.app;

import java.util.*;

public interface BuildCity {
    public String buildStructure(ArrayList<Terrain> grid,String[] coords, int floors, int foundation, int material);

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
    }
