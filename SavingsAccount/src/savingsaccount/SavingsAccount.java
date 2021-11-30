/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savingsaccount;

/**
 *
 * @author mzwonton
 */
public class SavingsAccount {
    //create private variables
   
    private static double annualInterestRate;
    private double savingsBalance;
    
    //default object
    public SavingsAccount() {
        
        savingsBalance = 0;
        annualInterestRate = 0;
        
    }
    
    //create object with parameters
    public SavingsAccount(double nBalance) {
        
        savingsBalance = nBalance;
        annualInterestRate = 0;
        
    }
    
    //new balance after a month
    public double calculateMonthlyInterest() {
        
        savingsBalance += savingsBalance * annualInterestRate / 12;
        return savingsBalance;
        
    }
    
    //change interest
    public static void setInterestRate(double nAnnualInterestRate) {
        
        annualInterestRate = nAnnualInterestRate;
        
    }
    
    //change balance
    public void setSavingsBalance(double nSavingsBalance) {
        
        savingsBalance = nSavingsBalance;
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Create Saver1 and Saver2 - set interest
        SavingsAccount Saver1 = new SavingsAccount(2000);
        Saver1.setInterestRate(0.04);
        
        SavingsAccount Saver2 = new SavingsAccount(3000);
        Saver2.setInterestRate(0.04);
        
        //print header
        System.out.println("Savings Account Balance \nMonth\t Saver1\t Saver2");
        
        //13 months
        for (int i = 1; i <= 13; i++) {
            
            //first 12 months
            if (i <= 12) {
                
                System.out.printf("%s\t%.2f\t  %.2f%n", i, Saver1.calculateMonthlyInterest(), Saver2.calculateMonthlyInterest());
                
            }
            
            //last month change interest
            else {
                
                Saver1.setInterestRate(0.05);
                Saver2.setInterestRate(0.05);
                
                System.out.printf("%s\t%.2f\t  %.2f%n", i, Saver1.calculateMonthlyInterest(), Saver2.calculateMonthlyInterest());
                
            }
            
        }
        
    }
    
}
