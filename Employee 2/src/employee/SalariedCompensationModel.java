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
public class SalariedCompensationModel extends CompensationModel {
    
    private double wSalary;
    
    public SalariedCompensationModel(double wSalary ){
        
        this.wSalary = wSalary;
        
    }
    
    public void setWSalary(double newSalary){
        
        this.wSalary = newSalary;
        
    }

    public double getWSalary(){
        
        return this.wSalary;
        
    }
    
    @Override
    public double earnings() {
        
        return getWSalary();
        
    }
    
    @Override
    public void raise(double percent) {
        
        setWSalary(getWSalary() * (1 + percent));
        
    }
    
    @Override
    public String toString() {
        
        return String.format("%s:%n%s: %.2f%n%s: %.2f%n",
                "Salaried Compensation with", "Weekly Salary of", getWSalary() ,
                "Earnings", earnings());
        
    }
    
}
