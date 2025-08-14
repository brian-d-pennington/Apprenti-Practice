public class LoanPaymentCalculator {

    public static void main(String[] args) {
        //Declare and initialize variables:
        double loanAmount = 25000.00; // in dollars
        double annualInterestRate = 5.5; // as a percentage
        int loanTermYears = 5;
        double monthlyPayment;
//      Calculate Monthly Payment using the Formula
        monthlyPayment = Math.round(loanAmount * (annualInterestRate/100)/12);
        System.out.println("The monthly payment is $" + monthlyPayment);
//   1. Use Assignment Operators:
//      Increase loanAmount by $5,000 (+=).
        loanAmount += 5000;
        System.out.println("Loan amount increased by $5,000 = $" + loanAmount);
//      Reduce the annualInterestRate by 1% (-=).
        annualInterestRate -= 1;
        System.out.println("Annual interest rate reduced by 1% = " + annualInterestRate + "%");
//      Increase loanTermYears by 1 (++).
        loanTermYears++;
        System.out.println("Loan term years increased by 1 = " + loanTermYears + " years");
//      loanTermYears++;
//   2. Use Comparison Operators:
//      Check if the loanAmount exceeds $30,000.
        boolean largeLoan = loanAmount > 30000.00;
        System.out.println("Does loan amount exceed $30,000? " + largeLoan);
//      Check if the monthlyPayment is more than $500.
        boolean paymentExceeds = monthlyPayment > 500.0;
        System.out.println("Is monthly payment greater than $500? " + paymentExceeds);
//   3. Use Logical Operators:
//      Determine if the loan is affordable (monthly payment is below $500 AND
//      term is over 3 years).
        boolean affordableLoan = monthlyPayment < 500 && loanTermYears > 3;
        System.out.println("Is the loan affordable? " + affordableLoan);
//      Determine if the loan is expensive (monthly payment is above $700 OR
//                    interest rate is over 6%).
        boolean isExpensive = monthlyPayment > 700 || annualInterestRate > 6;
        System.out.println("Is the loan expensive? " + isExpensive);
//
//           4. Print all results.
    }

}
