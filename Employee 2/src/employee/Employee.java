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
public class Employee {

    /**
     * @param args the command line arguments
     */
    //Create Instance Variables
    private String firstName;
    private String lastName;
    private String SSN;
    private CommissionCompensationModel Model;
    
    //create constructor
    public Employee(String firstName, String lastName, String SSN, CommissionCompensationModel compensationModel) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.Model = compensationModel;
        
    }
    
    //Setters
    
    public void setCompensation(CommissionCompensationModel compensationModel) {
        
        this.Model = compensationModel;
        
    } 
    
    public double earnings() {
        
        return Model.earnings();
        
    }
    
    public String getFirstName() {
        
        return firstName;
        
    }
    
    public String getLastName() {
        
        return lastName;
        
    }
    
    public String getSSN() {
        
        return SSN;
        
    }
    
    @Override
    public String toString() {
        
        return String.format("%s %s\nSocial Security Number: %s\n%s\nEarnings: %.2f\n",
                
                firstName, lastName, SSN, Model.toString(), earnings());
        
    }    
    
}
