package edu.curtin.app;

public class Rocky implements Terrain{
    private String terrainType;

    public Rocky(String terrain){
        this.terrainType = terrain;
    }

    @Override
    public String description() {
        
        String description = ("\nThis is a " + terrainType + " terrain type.");
        return description;
    }

    public String getRocky(){
        return this.terrainType;
    }
    
}
