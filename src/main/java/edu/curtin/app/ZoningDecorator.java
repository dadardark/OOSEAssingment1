package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Abstract class which implements the Terrain class and allows for zoning rules to be aggregated onto terrain objects.
*/

public abstract class ZoningDecorator implements Terrain{ 

    protected Terrain terrain;

    public ZoningDecorator(Terrain terrain){
        this.terrain = terrain;
    }

    public String desription() {
        return terrain.description();
    }
}
    
