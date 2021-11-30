/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2ddrawingapplication;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Paint;
import java.awt.Point;

/**
 *
 * @author mzwonton
 */

public class DrawingApplicationFrame extends JFrame
{
    //instance variables
    private JPanel firstLinePanel, secondLinePanel, topPanel;
    private DrawPanel drawPanel;
    private JButton undo, clear;
    private JComboBox shapeCombo;
    private JCheckBox filled;
    private JCheckBox gradient, dashed;
    private JButton firstColor, secondColor;
    private JTextField lineWidth, dashLength;
    private Color color1 = (Color.BLACK);
    private Color color2 = (Color.BLACK);
    private ArrayList<MyShapes> listShapes;
    private Point start, end;
    private JLabel statusLabel;
    
    public DrawingApplicationFrame() {
        
        //all the necessary lables and panels
        super("Java 2D Drawings");
        statusLabel = new JLabel("(0,0)");
        drawPanel = new DrawPanel();
        firstLinePanel = new JPanel(); 
        secondLinePanel = new JPanel();
        topPanel = new JPanel();
        
        //top row
        undo = new JButton("Undo");
        clear = new JButton("Clear");
        shapeCombo = new JComboBox();
        shapeCombo.addItem("Line");
        shapeCombo.addItem("Oval");
        shapeCombo.addItem("Rectangle");
        filled = new JCheckBox("Filled");
        
        //add top row
        firstLinePanel.add(undo);
        firstLinePanel.add(clear);
        firstLinePanel.add(new JLabel("Shape: "));
        firstLinePanel.add(shapeCombo);
        firstLinePanel.add(filled);
        
        //second row
        gradient = new JCheckBox("Use Gradient");
        firstColor = new JButton("1st Color...");
        secondColor = new JButton("2nd Color...");
        lineWidth = new JTextField();
        lineWidth.setColumns(2);
        dashLength = new JTextField();
        dashLength.setColumns(2);
        dashed = new JCheckBox("Dashed");
        
        //add second row
        secondLinePanel.add(gradient);
        secondLinePanel.add(firstColor);
        secondLinePanel.add(secondColor);
        secondLinePanel.add(new JLabel("Line Width: "));
        secondLinePanel.add(lineWidth);
        secondLinePanel.add(new JLabel("Dash Length:"));
        secondLinePanel.add(dashLength);
        secondLinePanel.add(dashed);
        
        //top panel is top and second row
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(firstLinePanel);
        topPanel.add(secondLinePanel);
        
        //create layout
        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
        
        //undo button (remove 1)
        undo.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae)
                    
            {
                if (listShapes.size() > 0) {
                    
                    listShapes.remove(listShapes.size()-1);
                    repaint();
                    
                }
            }
        });
        
        //clear button (remove all)
        clear.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if (listShapes.size() > 0) {
                    listShapes.clear();
                    repaint();
                    
                }
            }
        });
        
        //picking first color
        firstColor.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                color1 = JColorChooser.showDialog(null, "Pick your color", Color.BLACK);
                
            }           
        });
        
        //picking second color
        secondColor.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                color2 = JColorChooser.showDialog(null, "Pick your color", Color.BLACK);
                
            }
        });
    }
    
    //draw panel
    private class DrawPanel extends JPanel {
        
        //default panel
        public DrawPanel() {
            
            this.setBackground(Color.white);
            this.addMouseListener(new MouseHandler());
            this.addMouseMotionListener(new MouseHandler());
            listShapes = new ArrayList<>(); 
            
        }
        
        //draw
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            for (int i = 0; i < listShapes.size(); i++) {
                
                listShapes.get(i).draw(g2d);
                
            }
            
            g2d.dispose();
            
        }
        
        //mouse actions
        private class MouseHandler extends MouseAdapter implements MouseMotionListener {
            
            //press location
            @Override
            public void mousePressed(MouseEvent event) {
                
                start = event.getPoint();
                
            }
            
            //release location
            @Override
            public void mouseReleased(MouseEvent event) {
                
                end = event.getPoint();
                String shape = (String) shapeCombo.getSelectedItem();
                BasicStroke stroke;
                Paint paint;
                
                //dash checkbox
                if (dashed.isSelected()) {
                    
                    float[] dash = {Float.parseFloat(dashLength.getText())};
                    stroke = new BasicStroke(Float.parseFloat(lineWidth.getText()), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dash, 0);
                
                } else {
                    
                    stroke = new BasicStroke(Float.parseFloat(lineWidth.getText()), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                
                }
                
                //gradient checkbox
                if (gradient.isSelected())
                    
                    paint = new GradientPaint(0, 0, color1, 50, 50, color2, true);
                
                else
                    
                    paint = new GradientPaint(0, 0, color1, 50, 50, color1, true);
                
                //different shapes
                switch (shape) {
                    
                    case "Line":
                        
                        MyLine line = new MyLine(start, end, paint, stroke);
                        listShapes.add(line);
                        break;
                        
                    case "Oval":
                        
                        MyOval oval = new MyOval(start, end, paint, stroke, filled.isSelected());
                        listShapes.add(oval);
                        break;
                        
                    default:
                        
                        MyRectangle rectangle = new MyRectangle(start, end, paint, stroke, filled.isSelected());
                        listShapes.add(rectangle);
                        break;
                        
                }
                
                repaint();
                
            }
            
            @Override
            public void mouseDragged(MouseEvent event) {
                
            }
            
            //changes mouse location
            @Override
            public void mouseMoved(MouseEvent event) {
                
                Point p = event.getPoint();
                statusLabel.setText("(" + String.valueOf(p.x) + "," + String.valueOf(p.y) + ")");
                
            }
        }
    }
}
