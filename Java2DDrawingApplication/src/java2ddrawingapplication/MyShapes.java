/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2ddrawingapplication;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

/**
 *
 * @author mzwonton
 */

public abstract class MyShapes {
    
    //instance variables
    private Point startPoint = new Point();
    private Point endPoint = new Point();
    private Paint paint;
    private Stroke stroke;
    
    //default constructor
    public MyShapes() {
        
        stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        paint = Color.BLACK;
        
    }
    
    //constructor
    public MyShapes(Point pntA, Point pntB, Paint paint, Stroke stroke) {
        
        startPoint = pntA;
        endPoint = pntB;
        this.paint = paint;
        this.stroke = stroke;

    }
    
    public abstract void draw(Graphics2D g2d);
    
    //setters and getters
    public void setStartPoint(Point startPoint) {
        
        this.startPoint = startPoint;
        
    }
    
    public Point getStartPoint() {
        
        return startPoint;
        
    }

    public void setEndPoint(Point endPoint) {
        
        this.endPoint = endPoint;
        
    }


    public Point getEndPoint() {
        
        return endPoint;
        
    }
    
    public void setPaint(Paint paint) {
        
        this.paint = paint;
        
    }

    public Paint getPaint() {
        
        return paint;
    }

    public void setStroke(Stroke stroke) {
        
        this.stroke = stroke;
    }
    
    public Stroke getStroke() {
        
        return stroke;
        
    } 
}
