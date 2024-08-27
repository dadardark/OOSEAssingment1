package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Flood decorator which extends the ZoningDecorator class
*/

public class Flood extends ZoningDecorator{

    private Double floodRisk;

    public Flood(Terrain terrain, Double floodRisk){
        super(terrain);
        this.floodRisk = floodRisk;
    }

    @Override
    public String description() {
        return super.desription() + " The flood chance percentage is " + floodRisk + "%.";
    }

    public Double getFloodRisk(){
        return this.floodRisk;
    }
    
}
