/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2ddrawingapplication;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

/**
 *
 * @author mzwonton
 */

public class MyOval extends MyBoundedShapes{
    
    //contructor
    public MyOval(Point pointA, Point pointB, Paint paint, Stroke stroke, boolean filled) {
        
        super(pointA, pointB, paint, stroke, filled);
        
    }
    
    //draw method
    @Override   
    public void draw(Graphics2D g2d) {
        
        g2d.setPaint(getPaint());
        g2d.setStroke(getStroke());
        
        //filled option
        if(isFilled()) {
            
            g2d.fillOval(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
            
        } else {
            
            g2d.drawOval(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
            
        }
    }
}
