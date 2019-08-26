public class Portfolio{
  private String owner;
  private int stockCount;
  private Stock stocks[];
  private double cash;
  // A class to represent a group of stocks owned by an investor along
// with a cash reserve to purchase more stocks. 
  
  public Portfolio(String owner, int maxStocks){
    this.owner = owner;
    this.stockCount = 0;
    this.cash = 0.0;
    this.stocks = new Stock[maxStocks];
    // Construct a new portfolio that can hold the given maximum number
    // of stocks.
  }
  
  public String getOwner(){
    return this.owner;
    // Retrieve the owner of the portfolio.
  }
  
  public double getCash(){
    return this.cash;
    // Return the amount of cash currently in the portfolio
  }
  
  public int getStockCount(){
    return this.stockCount;
    // Return how many stocks are currently stored in the array of
    // stocks tracked by the portfolio.
  }
  
  public boolean deposit(double amount){
    this.cash = cash;
    if(amount<0){
      return false;
    }
    this.cash += amount;
    return true;
    // Add the given amount to the cash in the portfolio and return
    // true.  If the amount given is negative, ignore the request and
    // return false.
  }
  
  public boolean withdraw(double amount){
    this.cash = cash;
    if((amount<0) || (amount>cash)){
      return false;
    }
    this.cash = cash - amount;
    return true;
    // Deduct the given amount from the cash in portfolio and return
    // true.  If the amount is negative or is larger than the amount of
    // cash in the portfolio, ignore the request and return false.
  }
  
  public double totalValue(){
    this.stocks = stocks;
    this.cash = cash;
    int i;
    double total;
    double stockMoney = 0;
    for(i=0; i<stockCount; i++){
      stockMoney += stocks[i].getPrice()*stocks[i].getShares();
    }
    total = stockMoney + cash;
    return total;
    // Return the total value of all cash and stocks in the entire
    // portfolio. 
  }
  
  public String toString(){
    String stringText = new String();
    int i;
    this.stocks = stocks;
    double total = totalValue();
    stringText = String.format("Portfolio of %s\nCash: $%.2f\n%d stocks\n", owner, cash, stockCount);
    for(i=0; i<stockCount; i++){
      String name = stocks[i].getName();
      String symbol = stocks[i].getSymbol();
      double price = stocks[i].getPrice();
      int numShares = stocks[i].getShares();
      stringText += String.format(" %s (%s): price: $%.2f shares: %d\n", name, symbol, price, numShares);
    }   // Using "stringText" in order to print everything in order.
    stringText += String.format("Total value: $%.2f\n", total);
    return stringText;
    // Create a string representation of the portfolio.
  }
  
  public boolean addStock(String symbol, double price, String name){
    this.stockCount = stockCount;
    this.stocks = stocks;
    if(this.stockCount<this.stocks.length){ 
      this.stocks[stockCount] = new Stock(symbol, price, 0, name); //Creating new stock with the given values.
      this.stockCount++;
      return true;
    }
    return false;
    // Add a stock to the portfolio with the given symbol, price, and
    // name.
  }
  
  public boolean buyShares(String symbol, int numShares){
    int i;
    for(i=0; i<stockCount; i++){
      if (stocks[i].getSymbol().equals(symbol)){      // Using "equals" to compare symbols to each other.
        if(cash > stocks[i].getPrice()*numShares){
          cash = cash + stocks[i].buyMore(numShares); // Access variables within the stock to buy more shares. 
          return true;
        }
        else if(cash < stocks[i].getPrice()*numShares){
          return false;
        }
      }
    }
    return false;
    // Buy more shares a stock in the portfolio.
  }
  
  public boolean sellShares(String symbol, int numShares){
    int i;
    for(i=0; i<stockCount; i++){
      if (stocks[i].getSymbol().equals(symbol)){       // Using "equals" to compare symbols to each other.
        double profit = stocks[i].sellOff(numShares);  
        if(profit == 0.0){                            // Access variables within the stock and then compare it to 0.
          return false;
        }
        cash = cash + profit; 
        return true;
        
      }
    }
    return false;
    // Sell off shares a stock in the portfolio.
  }
  
}