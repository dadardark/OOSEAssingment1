package edu.curtin.app;

public class InvalidTerrainException extends Exception{

    public String getMessage(int lineNo){
        String error = "\n\n**********************************************************\nInvalid format on line: "+lineNo+". Default terrain added in place.\n**********************************************************\n\n";
        return error;
    }
    
}
