package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Set of functions which checks if a terrain object has any zoning rules aggregated to it.
 * Then checks if the specified zoning rule is aggregated onto the terrain object.
 * Returns the zoning rule if it exists.
*/

public class TerrainGetters {
    
    public static Height getHeight(Terrain terrain) {
        while (terrain instanceof ZoningDecorator) {
            if (terrain instanceof Height) {
                return (Height) terrain;
            }
            terrain = ((ZoningDecorator) terrain).terrain; 
        }
        return (terrain instanceof Height) ? (Height) terrain : null;
    }

    public static Heritage getHeritage(Terrain terrain) {
        while (terrain instanceof ZoningDecorator) {
            if (terrain instanceof Heritage) {
                return (Heritage) terrain;
            }
            terrain = ((ZoningDecorator) terrain).terrain; 
        }
        return (terrain instanceof Heritage) ? (Heritage) terrain : null;
    }

    public static Flood getFlood(Terrain terrain) {
        while (terrain instanceof ZoningDecorator) {
            if (terrain instanceof Flood) {
                return (Flood) terrain;
            }
            terrain = ((ZoningDecorator) terrain).terrain; 
        }
        return (terrain instanceof Flood) ? (Flood) terrain : null;
    }

    public static Contamination getContamination(Terrain terrain) {
        while (terrain instanceof ZoningDecorator) {
            if (terrain instanceof Contamination) {
                return (Contamination) terrain;
            }
            terrain = ((ZoningDecorator) terrain).terrain; 
        }
        return (terrain instanceof Heritage) ? (Contamination) terrain : null;
    }

    public static Flat getFlat(Terrain terrain) {
        while (terrain instanceof ZoningDecorator) {
            if (terrain instanceof Flat) {
                return (Flat) terrain;
            }
            terrain = ((ZoningDecorator) terrain).terrain; 
        }
        return (terrain instanceof Flat) ? (Flat) terrain : null;
    }

    public static Swampy getSwampy(Terrain terrain) {
        while (terrain instanceof ZoningDecorator) {
            if (terrain instanceof Swampy) {
                return (Swampy) terrain;
            }
            terrain = ((ZoningDecorator) terrain).terrain; 
        }
        return (terrain instanceof Swampy) ? (Swampy) terrain : null;
    }
    
    public static Rocky getRocky(Terrain terrain) {
        while (terrain instanceof ZoningDecorator) {
            if (terrain instanceof Rocky) {
                return (Rocky) terrain;
            }
            terrain = ((ZoningDecorator) terrain).terrain; 
        }
        return (terrain instanceof Rocky) ? (Rocky) terrain : null;
    }
}
