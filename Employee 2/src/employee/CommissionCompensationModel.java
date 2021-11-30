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
public class CommissionCompensationModel {
    
    //instance variables
    private double grossSales;
    private double commissionRate;
    
    //constructor
    public CommissionCompensationModel (double grossSales, double commissionRate) {
        
        //grossSales and comminsionRate cannot be negative
        if(grossSales < 0){
            
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
            
        }
        
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
            
        }
        
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
        
    }
    
    //Setters
    
    public double getCommissionRate() {
        
        return commissionRate;
        
    }
    
    public double getGrossSales() {
        
        return grossSales;
        
    }
    
    public double earnings() {
        
        return grossSales * commissionRate;
        
    }
    
    @Override
    public String toString() {
        
        return String.format("Commission Compensation with:\nGross Sales of: %.2f\nCommission Rate of: %.2f",
                grossSales, commissionRate);
        
    }
    
}
