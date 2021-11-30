/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author mzwonton
 */
interface Compensation {
    
    public double earnings();
    public void raise(double percent);
    
}

public abstract class CompensationModel implements Compensation{
    
}