public class LoanCalc {
  public static void main (String [] args) {
      double loanAmount;
      double yearlyInterestP;
      int loanTermY;
    System.out.printf("Enter Loan Amount:\n");                       // Aparently, this is the only way I was able to
    loanAmount = TextIO.getDouble();                                 // pass all the testes. (System.out.println causes
    System.out.printf("Enter Yearly Interest Rate (percent):\n");    // some kind of error while I run tests)
    yearlyInterestP = TextIO.getDouble();
    System.out.printf("Enter Years for Loan:\n");
    loanTermY = TextIO.getInt();
    double monthlyRate = (yearlyInterestP/12)/100;
    int totalNumber = loanTermY*12; 
    double numerator = (monthlyRate*loanAmount);
    double partOfDenom = Math.pow((1+monthlyRate), -totalNumber); // Separated denominator, for clarity
    double denominator = 1-partOfDenom;
    double monthlyPayment = numerator/denominator; 
    /*
    The lines above are representation of this equation: P = (iA)/(1-(1+i)^-n). 
    Each symbol was substituted by specific camelCas name,
    so it is now easier to understand each value and its meaning.
     */
    System.out.printf("Monthly Payment is $" + "%.2f\n",monthlyPayment);
    double totalCost = loanTermY*12*monthlyPayment;
    System.out.printf("Total Cost for loan is $" + "%.2f\n",totalCost);
    double totalInterest = totalCost - loanAmount;
    System.out.printf("Total Interest for loan is $" + "%.2f\n",totalInterest);
  }
  }