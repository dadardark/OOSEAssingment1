package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Swampy class for terrain types. Implements the Terrain interface.
*/

public class Swampy implements Terrain{

    private String terrainType;
    private String blue = "\033[1;34m";
    private String reset = "\033[0m"; 


    public Swampy(String terrain){
        this.terrainType = terrain;
    }

    @Override
    public String description() {
        
        String description = ("\nThis is a " + blue + terrainType + reset + " terrain type.");
        return description;
    }

    public String getSwampy(){
        return this.terrainType;
    }
    
}
