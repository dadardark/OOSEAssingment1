package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Height decorator which extends the ZoningDecorator class
*/

public class Height extends ZoningDecorator{
    private int noFloors;

    public Height(Terrain terrain, int noFloors){
        super(terrain);
        this.noFloors = noFloors;
    }

    @Override
    public String description() {
        return super.desription() + " The number of available floors is " + noFloors + ".";
    }

    public int getHeight() {
        return this.noFloors;
    }
    
}
