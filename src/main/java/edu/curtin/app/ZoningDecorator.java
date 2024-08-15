package edu.curtin.app;

public abstract class ZoningDecorator implements Terrain{ 

    protected Terrain terrain;

    public ZoningDecorator(Terrain terrain){
        this.terrain = terrain;
    }

    public String desription() {
        return terrain.description();
    }
}
    
