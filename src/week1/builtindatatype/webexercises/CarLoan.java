package week1.builtindatatype.webexercises;
/*
 * Car loan payments. Write a program CarLoan.java that reads in three 
 * command-line arguments P, Y, and R and calculates the monthly payments 
 * you would have to make over Y years to pay off a P dollar loan at R per 
 * cent interest compounded monthly. 
 * 
 * The formula is:
 * 
 *                   P r 
 *  payment =  ---------------,  where n = 12 * Y, r = (R / 100) / 12
 *            1  - (1 + r)^(-n)

 * Caveat: in Chapter 9, we will consider more accurate ways to compute this 
 * quantity, so before you go off to run an online bank, be sure to learn 
 * about roundoff error.
 */

public class CarLoan {

    public static void main(String[] args) {
        
        double paymentLoan = Double.parseDouble(args[0]);
        double years = Double.parseDouble(args[1]);
        double rate = Double.parseDouble(args[2]);

        double r = rate / (100.0 * 12.0);
        double n = 12.0 * years;

        double monthPay = (paymentLoan * r) / (1.0 - Math.pow(1.0 + r, -n)); 

        System.out.println(monthPay);
    }
    
}
