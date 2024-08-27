package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Flat class for terrain types. Implements the Terrain interface.
*/

public class Flat implements Terrain{
    private String yellow = "\033[1;33m";
    private String reset = "\033[0m"; 
    
    private String terrainType;

    public Flat(String terrain){
        this.terrainType = terrain;
    }

    @Override
    public String description() {
        
        String description = ("\nThis is a " +yellow+ terrainType +reset+ " terrain type.");
        return description;
    }

    public String getFlat(){
        return this.terrainType;
    }
    
}
