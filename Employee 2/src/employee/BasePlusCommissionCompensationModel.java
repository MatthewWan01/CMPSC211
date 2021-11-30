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
        this.baseSalary = baseSalary;
        
    }
    
    public void setBaseSalary(double baseSalary) {
        
        this.baseSalary = baseSalary;
        
    }
    
    public double getBaseSalary() {
        
        return baseSalary;
        
    }
    
    //override main class method
    @Override
    public double earnings() {
        
        return super.earnings() + baseSalary;
        
    }
    
    @Override
    public void raise(double percent){
        
        setBaseSalary(getBaseSalary() * (1 + percent));
        setCommissionRate(getCommissionRate() * (1 + percent));
        
    }
    
    @Override
    public String toString(){
        
        return String.format("%s:%n%s: %.2f%n%s: %.3f%n%s: %.2f%n%s: %.2f%n",
                "Base Plus Commission Compensation with", "Gross Sales of", getGrossSales() ,
                "Commission Rate of", getCommissionRate(),"Base Salary of",getBaseSalary(), "Earnings", earnings());
        
    }
    
}