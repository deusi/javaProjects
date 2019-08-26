public class Conversions{
  public static void main (String [] args){
    System.out.println("Choose 'binary' or 'decimal' number:");
    String binaryOrDecimal = TextIO.getWord();
    
    if ((binaryOrDecimal).equals("binary")){
      System.out.println("Enter a binary number: (ex: 011010101)");
      String binary = TextIO.getWord();
      int finale = B2D.binary2Decimal(binary);
      int i;
      
      if(finale > 0){
        System.out.printf("Decimal value: %d\n",finale);
        String backBinary = D2B.decimal2Binary(finale);
        System.out.printf("Back to binary: %s\n", backBinary);
      }
      
      else if (finale < 0){
        System.out.println("Failed to convert");
      } 
    }
    
    else if ((binaryOrDecimal).equals("decimal")){
      System.out.println("Enter a decimal number: (ex: 546723)");
      int decimal = TextIO.getInt();
      String finale = D2B.decimal2Binary(decimal);
      
      if(finale == null){
        System.out.println("Failed to convert");
      }
      
      else{
        System.out.printf("Binary value: %s\n",finale);
        int backDecimal = B2D.binary2Decimal(finale);
        System.out.printf("Back to decimal: %d\n", backDecimal);
      } 
    }
    
    else{
      System.out.printf("Unknown choice '%s'\n", binaryOrDecimal); 
    }
    
  }
}