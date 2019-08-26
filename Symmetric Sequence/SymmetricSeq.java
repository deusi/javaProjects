  public class SymmetricSeq{
  public static void main (String [] args){
  System.out.println("Enter length of sequence (ex: 7): ");
  int length = TextIO.getInt();
  int[] array = new int[length];
  int i;
  int x;
  boolean symmetry = true;
  System.out.printf("Enter %d integers:\n", length);
  for(i=0; i<array.length; i++){                         //In this part of code, we basically put user values
    array[i] = TextIO.getInt();                          //into array (which also has user length).
  }
  for(x=0;x<array.length;x++){
    if(array[x]!=array[array.length-(x+1)]){             //Here you can see the way to determine if sequence is 
      symmetry = false;                                  //symmetrical or not.
      if(x<array.length-(x+1)){
    System.out.printf("seq[%d] != seq[%d]\n",x, array.length-(x+1));      //Printing mistakes in the sequence
      }                                                                   //(if have any).
    }
  }
    if(symmetry == false){
      System.out.println("NOT Symmetric");  
    }
    else if(symmetry == true){
      System.out.println("Symmetric");  
    }
  
  }
}