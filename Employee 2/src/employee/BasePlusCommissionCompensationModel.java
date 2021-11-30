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
//subClass 
public class BasePlusCommissionCompensationModel extends CommissionCompensationModel {
    
    //instance variable
    private double baseSalary;
    
    //constructor
    public BasePlusCommissionCompensationModel (double grossSales, double commissionRate, double baseSalary) {
        
        //calls from Class constructors
        super(grossSales, commissionRate);
        
        //baseSalary cant be negative
        if(baseSalary < 0) {
            
            throw new IllegalArgumentException("Base Salary must be >= 0");
            
        }
        
        this.baseSalary = baseSalary;
        
    }
    
    //override main class method
    @Override
    public double earnings() {
        
        return super.earnings() + baseSalary;
        
    }
    
    @Override
    public String toString() {
        
        return String.format("Base Plus Commission Compensation with:\nGross Sales of: %.2f\nCommissionRate of: %.2f\nBase Salary of: %.2f",
                getGrossSales(), getCommissionRate(), baseSalary);
        
    }
    
}