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

public class MyLine extends MyShapes{
    
    //contructor
    public MyLine(Point pointA, Point pointB, Paint paint, Stroke stroke) {
        
        super(pointA, pointB, paint, stroke);
        
    }
    
    //draw method
    @Override
    public void draw(Graphics2D g2d) {
        
        g2d.setPaint(getPaint());
        g2d.setStroke(getStroke());
        g2d.drawLine((int)(getStartPoint().getX()), (int)(getStartPoint().getY()), (int)(getEndPoint().getX()), (int)(getEndPoint().getY()));
    
    }
}
