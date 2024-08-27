package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Rocky class for terrain types. Implements the Terrain interface.
*/

public class Rocky implements Terrain{
    private String red = "\033[1;31m";
    private String reset = "\033[0m"; 
    private String terrainType;

    public Rocky(String terrain){
        this.terrainType = terrain;
    }

    @Override
    public String description() {
        
        String description = ("\nThis is a " +red+ terrainType +reset+ " terrain type.");
        return description;
    }

    public String getRocky(){
        return this.terrainType;
    }
    
}
