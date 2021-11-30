/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza.servings.calculator.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author mzwonton
 */
public class PizzaServingsCalculatorGUI extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    //create instance variables
    private JPanel pSize = new JPanel();
    private JTextField size;
    private JLabel outputServings;
    
    public PizzaServingsCalculatorGUI() {
        
        //contructor and layout
        super("Pizza Servings Calculator");
        setLayout(new GridLayout(4, 1));
        
        //create title
        JLabel title = new JLabel("Pizza Servings Calculator", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setForeground(Color.red);
        add(title);
        
        //create label
        JLabel pizzaSize = new JLabel("Enter the size of the pizza in inches: ");
        pSize.add(pizzaSize);
        size = new JTextField(4);
        pSize.add(size);
        add(pSize);
        
        //create button
        JButton servings = new JButton("calculate Servings");
        servings.addActionListener(new CalculateServings());
        add(servings);
        
        //create display
        outputServings = new JLabel("", JLabel.CENTER);
        add(outputServings);
               
    }
    
    private class CalculateServings implements ActionListener {
        
        
        //when button is pressed
        @Override
        public void actionPerformed(ActionEvent e) {
            double pizzaSize = Double.parseDouble(size.getText());
            double totalServings = Math.pow(pizzaSize / 8 , 2);
            outputServings.setText(String.format("A %.0f inch pizza will serve %.2f people",
            + pizzaSize, totalServings));
            
        }
        
    }
    
}
