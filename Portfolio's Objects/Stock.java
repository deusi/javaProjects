public class Stock{
  private String symbol;
  private double price;
  private int numShares;
  private String name;
  // Represent ownership of a single stock. Fields are private.
  
  public Stock(String symbol, double price, int numShares, String name){
    this.symbol = symbol;
    this.price = price;
    this.numShares = numShares;
    this.name = name;
    // Constructor which takes initial values for fields.
  }
  
  public String getSymbol(){
    return this.symbol;
    // Return the symbol for the stock.
  }
  
  public double getPrice(){
    return this.price;
    // Return the price for the stock.
  }
  
  public int getShares(){
    return this.numShares;
    // Return the number of shares owned.
  }
  
  public String getName(){
    return this.name;
    // Return the name of the stock.
  }
  
  public String toString(){
    return String.format("%s (%s): price: $%.2f shares: %d", name, symbol, price, numShares); 
    // Return a String with information on the given stock to the screen.
  }
  
  public double buyMore(int moreShares){    
    this.numShares = this.numShares + moreShares;
    double cost = -(this.price * moreShares); //Value "cost" is negative in order to deduct it from cash.
    return cost;
    // Buy more of the specified stock. The number of additional shares
    // to buy is the parameter moreShares. Return cost.
  }
  
  public double sellOff(int lessShares){
    //this.numShares = numShares;
    //this.price = price;
    if(lessShares > this.numShares){ //Check the number of shares. If there is not enough shares, return 0.0
      double profit;
      profit = 0.0;
      return profit;
    }
    this.numShares = this.numShares - lessShares;
    double profit = this.price * lessShares; // Otherwise, multiply price by the number of needed shares and return it.
    return profit;
    // Sell off shares of the specified stock. The number of shares to
    // sell is the parameter lessShares. Return profit.
  }
  
}