/**
 *  Copyright 2010 Coderloop.com.
 *  Author: Diego, the architect
 **/
package com.coderloop.puzzles;

/**
 *  This class gets a reference to a string and
 *  allows to generate strings appending the base string n times. 
 **/
class LoopPrinter {
    
    //! Keep a reference to the base string of the printer
    private final String baseString;
    
    //! Create the printer setting the base string
    public LoopPrinter(String baseString) {
        this.baseString = baseString;
    }
    
    //! Generate a new string multiplying the baseString 
    public String printMultiple(int times) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < times; i++) {
            sb.append(this.baseString);
        }
        return sb.toString();
    }
}