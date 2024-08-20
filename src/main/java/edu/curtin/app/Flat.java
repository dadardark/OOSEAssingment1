package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Flat class for terrain types. Implements the Terrain interface.
*/

public class Flat implements Terrain{
    private String terrainType;

    public Flat(String terrain){
        this.terrainType = terrain;
    }

    @Override
    public String description() {
        
        String description = ("\nThis is a " + terrainType + " terrain type.");
        return description;
    }

    public String getFlat(){
        return this.terrainType;
    }
    
}
