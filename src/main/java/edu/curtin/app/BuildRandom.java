package edu.curtin.app;

import java.util.ArrayList;
import java.util.Random;

public class BuildRandom implements BuildCity{

    @Override
    public void buildStructure(ArrayList<Terrain> grid, String[] coords, int floors, int foundation, int material){
        double totalCost = 0;
        int builtStructures =0;
        int row = 1;
        int col = 1;
        String[][] structures = new String[Integer.parseInt(coords[0])][Integer.parseInt(coords[1])];
        Random rand = new Random();
         for(Terrain terrain : grid){
            floors = rand.nextInt(100)+1;
            foundation = rand.nextInt(2)+1;
            material = rand.nextInt(4)+1;

            String matString = null;

            if(material == 1){matString = "wood";}
            else if(material == 2){matString = "stone";}
            else if(material == 3){matString = "brick";}
            else if(material == 4){matString = "concrete";}

            if(TerrainGetters.getSwampy(terrain)!= null && foundation == 1){
                structures[row-1][col-1] = " ";           
            }
            else if (TerrainGetters.getSwampy(terrain) != null && material == 1){
                structures[row-1][col-1] = " ";           
            }
            else if (TerrainGetters.getHeritage(terrain)!= null && !(TerrainGetters.getHeritage(terrain).getHeritage()).equals(matString)){
                structures[row-1][col-1] = " ";           
            }
            else if(TerrainGetters.getHeight(terrain) != null && floors > TerrainGetters.getHeight(terrain).getHeight()){
                structures[row-1][col-1] = " ";           
            }
            else if (TerrainGetters.getFlood(terrain)!= null && floors < 3){
                structures[row-1][col-1] = " ";           
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
       System.out.println("\nTotal cost: $" + String.format("%.2f",totalCost) + "\nStructures built: " + builtStructures);
       displayStructure(coords, structures);
    }
}
