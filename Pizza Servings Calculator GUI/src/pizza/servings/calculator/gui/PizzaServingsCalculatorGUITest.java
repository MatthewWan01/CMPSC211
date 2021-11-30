/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza.servings.calculator.gui;

import javax.swing.JFrame;
/**
 *
 * @author mzwonton
 */
public class PizzaServingsCalculatorGUITest {
    
    public static void main(String[] args) {
        // TODO code application logic here
        PizzaServingsCalculatorGUI pizzaServings = new PizzaServingsCalculatorGUI();
        pizzaServings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pizzaServings.setSize(350, 300);
        pizzaServings.setVisible(true);
        
    }
     
}
