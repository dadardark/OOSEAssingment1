package edu.curtin.app;

public class Swampy implements Terrain{

    private String terrainType;

    public Swampy(String terrain){
        this.terrainType = terrain;
    }

    @Override
    public String description() {
        
        String description = ("\nThis is a " + terrainType + " terrain type.");
        return description;
    }

    public String getSwampy(){
        return this.terrainType;
    }
    
}
