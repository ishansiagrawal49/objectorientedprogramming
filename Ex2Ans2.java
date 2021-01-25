
import java.io.*;
import java.util.Scanner;

class SavingsAccount{
    
    private float savingsBalance;
    static private float annualInterestRate;

    public SavingsAccount(float savingsBalance) {
        this.savingsBalance = savingsBalance;
    }
    
    
    
//    calculateMonthlyInterest to calculate the monthly interest by multiplying the savingsBalance by
//annualInterestRate divided by 12—this interest should be added to savingsBalance.
    
public float calculateMonthlyInterest(){
    
    return savingsBalance+=((this.savingsBalance*annualInterestRate)/1200);
}     
  
   static public void modifyInterestRate(float rate){
       annualInterestRate = rate;
   }
   
   public float getSavingBalance(){
       return this.savingsBalance;
   }

    
}



public class Ex2Ans2 {


    public static void main(String[] args) {
        // TODO code application logic here
        
        SavingsAccount.modifyInterestRate(4);
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        System.out.println("Before modification saver 1 and saver 2 :");
        System.out.println(saver1.calculateMonthlyInterest());
        System.out.println(saver2.calculateMonthlyInterest());
        SavingsAccount.modifyInterestRate(5);
        System.out.println("After modification saver 1 and saver 2 :");
        System.out.println(saver1.calculateMonthlyInterest());
        System.out.println(saver2.calculateMonthlyInterest());
        
    }
    
}
