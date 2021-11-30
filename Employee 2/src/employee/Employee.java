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
    private CompensationModel compensationModel;
    
    //create constructor
    public Employee(String firstName, String lastName, String SSN, CompensationModel compensationModel) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.compensationModel = compensationModel;
        
    }
    
    public void raise(double percent) {
        
        compensationModel.raise(percent);
        
    }
    
    //Setters
    
    public void setCompensation(CompensationModel compensationModel) {
        
        this.compensationModel = compensationModel;
        
    } 
    
    public CompensationModel getCompensation(){
        
        return compensationModel;
        
    }
    
    public double earnings() {
        
        return compensationModel.earnings();
        
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
    public String toString(){
        
        return String.format("%s %s%n%s: %s%n%s" , firstName, lastName, "Social Security Number",getSSN(),compensationModel);
        
    }
    

}
