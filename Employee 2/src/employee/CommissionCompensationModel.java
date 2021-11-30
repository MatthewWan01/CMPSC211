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
public class CommissionCompensationModel extends CompensationModel {
    
    //instance variables
    private double grossSales;
    private double commissionRate;
    
    //constructor
    public CommissionCompensationModel (double grossSales, double commissionRate) {    
        
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
        
    }
    
    //Setters
    public void setCommissionRate(double commissionRate){
        
        this.commissionRate = commissionRate;
        
    }
    
    public double getCommissionRate() {
        
        return commissionRate;
        
    }
    
    public double getGrossSales() {
        
        return grossSales;
        
    }
    
    @Override
    public double earnings() {
        
        return grossSales * commissionRate;
        
    }
    
    @Override
    public void raise(double percent) {
        
        setCommissionRate(getCommissionRate() * (1 + percent));
        
    }
    
    @Override
    public String toString(){
        
        return String.format("%s:%n%s: %.2f%n%s: %.3f%n%s: %.2f%n",
                "Commission Compensation with", "Gross Sales of", getGrossSales() ,
                "Commission Rate of", getCommissionRate(), "Earnings", earnings());
        
    }
    
}
