public class MakeChange {
  public static void main (String [] args) {
    System.out.printf("Enter required change in pennies (ex: 167): \n");
    int change = TextIO.getInt();
    int dollars = 100;
    int quarter = 25; 
    int dimeA = 5*4;                // I didn't quite understand what does "Use some intermediate variables
    int dimeB = 2;                  //  for values like the number of dimes" mean, so I hope that I got it
    int dimes = dimeA/dimeB;        // right.
    int nickels = 5;
    int pennies = 1;
    int dollarsValue = change / dollars;
    change = change % dollars;
    int quarterValue = change / quarter;  
    change = change % quarter;
    int dimesValue = change / dimes;
    change = change % dimes;
    int nickelsValue = change / nickels;
    change = change % nickels;
    int penniesValue = change / pennies;
    change = change % pennies;
      System.out.println("Dollars: " + dollarsValue);
    System.out.println("Quarter: " + quarterValue);
      System.out.println("Dimes  : " + dimesValue);
      System.out.println("Nickels: " + nickelsValue);
      System.out.println("Pennies: "+ penniesValue);
  }
}