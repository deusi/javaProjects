import java.util.Scanner;                  //Declare Scanner at the beginning, so we can use it later.
import java.io.File;

public class Util{
// Contains static methods useful for parsing files.
  
  public static int countLines(String filename) throws Exception{
    // Count the number of lines in the file given. Makes use of a
    // Scanner to read the file.
    Scanner sc = new Scanner(new File (filename));
    int count = 0;
    while(sc.hasNext()){                     //This loop constantly checks if there is another line ahead
      if (sc.hasNextLine()){
        count++;                         //If there is a line ahead, add +1 to count
        sc.nextLine();                   
      }
      else{
        sc.next();  
      }
    }
    return count;
  }
  
  public static String [] splitIntoStrings(String str){
    // Create an array of strings filled with each String in str
    // separated by spaces. Uses a Scanner to parse the String str.
    //
    // For example:
    //
    // String str = "here are some words";
    // String tokens[] = Util.splitIntoStrings(str);
    // tokens is not the array { here, are, some, words }
    //                           0     1    2     3
    
    try {                                 //Use try/catch in order to avoid undetected errors.
      Scanner sc = new Scanner(str);
      int count = 0;
      while(sc.hasNext()){
        if (sc.hasNextLine()){
          count++;
          sc.next();
        }
        else{
          sc.next();
        }
      }
      sc = new Scanner(str);
      String [] array = new String[count];
      for (int i=0; i<count; i++){
        array [i] = sc.next();                //Uses next() to calculate the number of words.
      }
      return array;
    }
    catch(Exception e){                  //If the method doesn't work properly, catchs the following exception.
      throw new RuntimeException(e); 
    }
  }
  
  public static int [] splitIntoInts(String str){
    // Create an array of ints filled with each integer in str separated
    // by spaces. Uses a Scanner to parse the String str.
    // 
    // String str = "8 6 7 5  30 9";
    // int nums[] = Util.splitIntoInts(str);
    // nums is now the array { 8, 6, 7, 5, 30, 9 }
    //                         0  1  2  3   4  5
    
    try {                            //This try/catch does the same thing as in the previous one.
      Scanner sc = new Scanner(str);
      int count = 0;
      while(sc.hasNext()){
        if (sc.hasNextInt()){           
          count++;
          sc.nextInt();            //Uses nextInt() to calculate the number of ints.
        }
        else{
          sc.next();
        }
      }
      sc = new Scanner(str);
      int [] array = new int[count];
      for (int i=0; i<count; i++){
        array [i] = sc.nextInt();
      }
      return array;
    }
    catch(Exception e){              
      throw new RuntimeException(e); 
    }
  }
  
}