package edu.curtin.app;

import java.util.ArrayList;
import  java.lang.Math;

public class BuildCentral implements BuildCity{

    @Override
    public String buildStructure(ArrayList<Terrain> grid, String[] coords, int floors, int foundation, int material) {
        
        double totalCost = 0;
        int builtStructures = 0;
        int row = 1;
        int col = 1;
        String[][] structures = new String[Integer.parseInt(coords[0])][Integer.parseInt(coords[1])];
         for(Terrain terrain : grid){
            int distance = (int)Math.sqrt((row-((Integer.parseInt(coords[1])-1)/2)^2)+(col-((Integer.parseInt(coords[0])-1)/2)^2));
            //System.out.println(row + "," + col);

            String matString = null;

            floors = Math.round(1+(20/(distance+1)));
            foundation = 1;
            
            if(distance <= 2){matString = "concrete";}
            else if(distance> 2 && distance <= 4){matString = "brick";}
            else if(distance> 4 && distance <= 6){matString = "stone";}
            else {matString = "wood";}
            //System.out.println(distance + " " + matString);

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

                structures[row-1][col-1] = "x";
            }
            if(row == Integer.parseInt(coords[0])){
                col++;
                row=0;
            }
            row++;
       }
       System.out.println("\nTotal cost: " + totalCost + "\nStructures built: " + builtStructures);
       displayStructure(coords, structures);
       return null;
    }
}
    
