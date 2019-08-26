public class D2B{
  
  public static String decimal2Binary(int decimal){
    String answer = "";
    if(decimal<0){
      answer = null; 
    }
    else{
      while(decimal!=0){
        if(decimal%2==1){
          answer = "1" + answer;
        }
        else if(decimal%2==0){
          answer = "0" + answer;
        }
        decimal = decimal/2;
      }
    }
    if(answer == ""){
      answer = "0";
    }
    return answer;
  }
  
  public static void main (String [] args){
    System.out.println("Enter a decimal number: (ex: 546723)");
    int decimal = TextIO.getInt();
    String finale = decimal2Binary(decimal);
    if(finale == null){
      System.out.println("Can't convert decimals less than 0");
    }
    else{
      System.out.printf("Binary value: %s\n",finale);
    }
  }
  
}