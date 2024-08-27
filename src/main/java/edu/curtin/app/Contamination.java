package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Contamination decorator which extends the ZoningDecorator class
*/

public class Contamination extends ZoningDecorator{
    private boolean active;

    public Contamination(Terrain terrain, boolean active){
        super(terrain);
        this.active = active;
    }

    @Override
    public String description() {
        return super.desription() +" This area is contaminated.";
    }

    public boolean getContamination(){
        return this.active;
    }
    
}
