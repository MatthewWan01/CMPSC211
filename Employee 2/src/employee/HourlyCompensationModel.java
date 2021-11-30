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
public class HourlyCompensationModel extends CompensationModel {
    
    private double wage;
    private double hours;
    private final int overtimeHour = 40;
    private final double overtimeRate = 1.5;
    
    public HourlyCompensationModel(double wage, double hours){
        
        this.wage = wage;
        this.hours = hours;
        
    }
    
    public void setWage(double wage) {
        
        this.wage = wage;
        
    }
    
    public double getWage() {
        
        return this.wage;
        
    }
    
    
    public void setHours(double hours) {
        
        this.hours = hours;
        
    }
    
    public double getHours(){
        
        return this.hours;
        
    }

    @Override
    public double earnings(){
        
        if (getHours() <= overtimeHour){
            
            return getWage() * getHours();
        
        }
        
        else {
            
            return getWage() * overtimeHour  + (getHours() - overtimeHour) * getWage() * overtimeRate; 
            
        }
        
    }
    
    @Override
    
    public void raise(double percent) {
        
        setWage(getWage() * (1 + percent));
        
    }
    
    @Override
    public String toString(){
        
        return String.format("%s:%n%s: %.2f%n%s: %.2f%n%s: %.2f%n",
                "Hourly Compensation with", "Wage of", getWage(), "Hours Worked of",
                getHours(),"Earnings", earnings());
        
    }
    
}