package edu.curtin.app;

import java.util.ArrayList;

public class BuildUniform implements BuildCity{

    @Override
    public String buildStructure(ArrayList<Terrain> grid,String[] coords, int floors, int foundation, int material) {
        double totalCost = 0;
        int builtStructures =0;
         for(Terrain terrain : grid){

            String matString = null;

            if(material == 1){matString = "wood";}
            else if(material == 2){matString = "stone";}
            else if(material == 3){matString = "brick";}
            else if(material == 4){matString = "concrete";}

            if(TerrainGetters.getSwampy(terrain)!= null && foundation == 1){
            }
            else if (TerrainGetters.getSwampy(terrain) != null && material == 1){
            }
            else if (TerrainGetters.getHeritage(terrain)!= null && !(TerrainGetters.getHeritage(terrain).getHeritage()).equals(matString)){
            }
            else if(TerrainGetters.getHeight(terrain) != null && floors > TerrainGetters.getHeight(terrain).getHeight()){
            }
            else if (TerrainGetters.getFlood(terrain)!= null && floors < 3){
            }
            else {
                Double buildCost = costStructure(terrain, floors, foundation, matString);
                totalCost = totalCost + buildCost;
                builtStructures++;
            }
       }
       System.out.println("\nTotal cost: " + totalCost + "\nStructures built: " + builtStructures);
       return null;
    }
}
