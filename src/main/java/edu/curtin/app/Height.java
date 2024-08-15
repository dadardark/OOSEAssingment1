package edu.curtin.app;

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
