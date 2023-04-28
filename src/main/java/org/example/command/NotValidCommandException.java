package org.example.command;

public class NotValidCommandException extends Exception {
    public NotValidCommandException(String ex){
        super(ex);
    }
}
