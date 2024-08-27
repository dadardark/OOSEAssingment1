package edu.curtin.app;

public class InvalidCoordException extends Exception {
    @Override
    public String getMessage(){
        String error = "\n\n**********************************************************\nInvalid grid size inputted.\n**********************************************************\n\n";
        return error;
    }
    
}
