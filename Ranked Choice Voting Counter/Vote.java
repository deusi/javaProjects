import java.util.Scanner;
import java.io.File;

public class Vote{       
  // A class to represent a ranked ordering of candidates.
  private String [] votes;                                 //For this class we need only one private field.
  
  public Vote(String candidates[], int ranks[]){           //This methode creates new Votes which will be used later.
    // Create a vote. The candidates given are ranked according to the
    // ranks[] parameter.  For example, the parameters
    // 
    //   candidates = {Francis, Claire, Heather, Viktor}; 
    //   ranks      = {2,       3,      0,       1     };
    // 
    // results in the vote
    // 
    //   Vote{Heather, Viktor, Francis, Claire}
    // 
    // where the ordering of the candidates is reflected in the idexes
    // given in ranks[].
    // 
    votes = new String[ranks.length];
    for(int i = 0; i<ranks.length; i++){
      votes[ranks[i]] = candidates[i];
    }
  }
  
  
  public String toString(){ 
    // Produce a string representatin of this Vote which shows the
    // ranked ordering of the candidates. The format is as follows.
    //
    // 0 candidates example:
    // Vote{}
    //
    // 4 candidates example:
    // Vote{Heather, Viktor, Francis, Claire}
    //
    // Uses a loop to incrementally build up the string representation.
    String [] voteStr = votes; 
    String message = String.format("Vote{");                       //In here we create a new string and then gradually 
    for(int i = 0; i<voteStr.length; i++){                         //add components to it, so at the and we could get
      message += String.format("%s", voteStr[i]);                  //readable toString()
      if (i < voteStr.length-1){
        message += String.format(", ");
      }
    }
    message += String.format("}\n");
    return message;
  }
  
  
  public static Vote[] readVoteFile(String filename) throws Exception{         
    // Read votes from a file like the following.
    // 
    // Francis Claire Heather Viktor
    // 1 4 3 2
    // 2 1 3 4
    // 3 2 1 4
    //
    // The first line shows the candidates, 4 in this case while each
    // subsequent line are the ranks of those candidates. Returns an
    // array of Vote[] objects initialzied from their contents of the
    // file. Makes use of Scanner and methods of Util the split lines
    // into arrays of strings and integers. Note that each line is
    // 1-indexed so should be decremented to form the ranks of the vote.
    
    int count = Util.countLines(filename);                 //In here we get the length of the given file
    Scanner sc = new Scanner(new File (filename));          
    String candidates[] = Util.splitIntoStrings(sc.nextLine());  //Here we use Util method to get the names of the candidates
    
    Vote voteArray[] = new Vote [count-1];                //We allocate new array which is 1 shorter than the one in file
    
    
    for(int i = 0; i<(count-1); i++){                    //We use a loop to get all the ints inside the file
      int [] ranks = Util.splitIntoInts(sc.nextLine());
      for(int j = 0; j<ranks.length; j++){              //We use the second value to decrease the value of ranks
        ranks[j]--;                                     //because we start to count from 0, but in files it starts with 1
      }
      voteArray[i] = new Vote (candidates, ranks);     //We allocate a new Vote class with given paramethers and then we return it.
    }
    sc.close();
    return voteArray;
  }
  
  public String getBest(Tally tally){                               //This method uses Tally class to get the highes candidate.
    // Retrieve the highest ranked candidate for this Vote which is in
    // the Tally given. The parameter tally may contain fewer candidates
    // than were used to create the Vote.  If the Vote has no candidate
    // contained in the given Tally, return null.
    
    for(int i=0;i<votes.length;i++)
    {
      if(tally.contains(votes[i]))
      {
        return votes[i];
      }
    }
    
    return null;                                 
  }
  
}