/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2ddrawingapplication;

import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

/**
 *
 * @author mzwonton
 */

public abstract class MyBoundedShapes extends MyShapes{
    
    
    //instance variable
    private boolean filled;
    
    //constructor
    public MyBoundedShapes(Point pointA, Point pointB, Paint paint, Stroke stroke, boolean filled) {
        
        super(pointA, pointB, paint, stroke);
        this.filled = filled;
        
    }
    
    //setters and getters
    public void setIsFilled(boolean isFilled) {
        
        filled = isFilled;
        
    }
    
    public boolean isFilled() {
        
        return filled;
        
    }
    
    public int getWidth() {
        
        return Math.abs((int)getStartPoint().getX() - (int)getEndPoint().getX());
        
    }
    
    public int getHeight() {
        
        return Math.abs((int)getStartPoint().getY() - (int)getEndPoint().getY());
        
    }
    
    public int getTopLeftX() {
        
        return Math.min((int)(getStartPoint().getX()), (int)(getEndPoint().getX()));
        
    }
    
    public int getTopLeftY() {
        
        return Math.min((int)(getStartPoint().getY()), (int)(getEndPoint().getY()));
        
    }
}
