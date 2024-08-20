package edu.curtin.app;

/* 
 * 19817082 | Jacob Arvino | OOSE Assignment 1
 * Custom exception which is thrown when a grid.txt file contains data in an invalid format.
*/

public class InvalidTerrainException extends Exception{

    public String getMessage(int lineNo){
        String error = "\n\n**********************************************************\nInvalid format on line: "+lineNo+". Default terrain added in place.\n**********************************************************\n\n";
        return error;
    }
    
}
