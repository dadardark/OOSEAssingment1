package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Heritage decorator which extends the ZoningDecorator class
*/

public class Heritage extends ZoningDecorator{
    private String material;

    public Heritage(Terrain terrain, String material){
        super(terrain);
        this.material = material;
    }

    @Override
    public String description() {
        return super.desription() + " The heritage material is " + material + ".";
    }

    public String getHeritage(){
        return this.material;
    }
    
}
