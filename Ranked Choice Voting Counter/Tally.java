import java.util.Scanner;
import java.io.File;

public class Tally{
// Represent the candidates in election along with the counts of the
// votes for each of them.
  private String [] candidates;
  private int [] votes;
  
  public Tally(String candidates[]){                                 //This method creates new tallies.
    // Construct a Tally with the given candidates. The constructor
    // makes a deep copy of the array given so that subsequent changes
    // to the parameter array do not affect the tally.  The initial vot
    // counts for each candidate are all 0.
    this.candidates = new String [candidates.length];
    this.votes = new int [candidates.length];
    for(int i = 0; i<candidates.length; i++){
      this.candidates [i] = candidates [i];
      this.votes [i] = 0;
    }
    
  }
  
  public String toString(){                                   //Prints the Tallies.
    // Produce a string version of the Tally formatted as follows.
    // 
    // 0 candidates
    // Tally{}
    //
    // 3 candidates
    // Tally{Francis:4, Claire:2, Heather:4}
    //
    // Builds the string reprsentation up incrementally using a loop.
    String message = ""; 
    message += String.format("Tally{");
    for(int i = 0; i<candidates.length; i++){
      message += String.format("%s:", candidates[i]);                //Constructor is almost the same as in Vote class
      message += String.format("%d", votes[i]);
      if (i < candidates.length-1){
        message += String.format(", ");
      }
    }
    message += String.format("}\n");
    return message;
  }
  
  public int size(){
    // Return the number of candidates in this Tally.
    return this.candidates.length;
  }
  
  public boolean contains(String candidate){
    // Return true if the specified candidate is present in this Tally
    // and false otherwise.
    for (int i =0; i< this.candidates.length; i++){
      if (this.candidates[i].equals(candidate)){
        return true;
      }
    }
    return false;
  }
  
  public void countVote(String candidate){
    // Increment the vote count of the candidate specified. The the
    // candidate is not present in this Tally, throw a RuntimeException
    // with a message formatted like:
    //
    // 'Edmond' not in Tally{Francis:0, Claire:0, Heather:1, Viktor:0}
    if(!contains(candidate)){ //Check if the candidate is present in the 
      throw new RuntimeException(String.format("'%s' not in %s", candidate, toString()));           
    }
    for (int i = 0; i<this.candidates.length; i++){  //Self-explanatory, isn't it?
      if (this.candidates[i].equals(candidate)){
        this.votes[i]++;
      }
    }
  }
  
  public int totalVotes(){
    // Return the total number of votes which have been counted in this
    // Tally.
    int count = 0;
    for (int i = 0; i<votes.length; i++){
      count += votes[i];
    }
    return count;
  }
  
  public String outputString(){
    // Produce a nicely formatted table of the Tally. The table includes
    // vote count, percent, and name for each candidate which appears
    //
    // CNT     % NAME
    //   4  33.3 Francis
    //   2  16.7 Claire
    //   5  41.7 Heather
    //   1   8.3 Viktor
    //
    // The format string "%3d %5.1f %s\n" is useful where the arguments
    // are the vote counts, percentage of votes won, and candidate
    // names.
    String message = String.format("CNT     %% NAME\n");     
    for (int i = 0; i<this.candidates.length; i++){
      double intermediate = this.votes[i];
      double percent = 100*intermediate/totalVotes();
      message += String.format("%3d %5.1f %s\n", this.votes[i], percent, this.candidates[i]);
    }
    return message;
  }
  
  public String getWinner(){
    // Calculate the percent of the total votes each candidate has
    // earned. If any candidate has greater than 50% of the votes,
    // return that candidate as a String. If no candidate has more than
    // 50% of the vote, return null.
    double percent;
    for(int i = 0; i<this.candidates.length; i++){   //Check the percentage and returns the name of the winner if more than 50%
      double intermediate = this.votes[i];
      percent = 100*intermediate/totalVotes();
      if (percent>50.0){
        return String.format("%s", candidates[i]);
      }
    }
    return null;
  }
  
  public String [] getMinCandidates(){
    // Return an array of Strings containing all candidate names which
    // are tied for the minimum number of votes.  First searche for the
    // minimum vote count in the Tally among candidates, the allocates
    // an array of Strings of that size and fills it with candidates
    // which have vote counts equal to the minimum.
    int minValue = this.votes[0];         //Assign minValue to be votes[0], so we can compare different first vote to others.
    for(int i=1;i<this.votes.length;i++){
      if(this.votes[i] < minValue){
        minValue = this.votes[i];
      }
    }
    int count = 0;
    for(int j = 0; j<this.candidates.length; j++){    //Counts how many values with that number exist within an array.                         
      if(this.votes[j] == minValue){
        count++;
      }
    }
    String minCandidates[] = new String [count]; //Using count to alocate an array of the size of number of min. numbers.
    int j=0;
    for(int l = 0; l<candidates.length; l++){     //Creates an array to locate all candidates with minimum values in it.
      if(this.votes[l] == minValue){
        minCandidates[j++] = this.candidates[l];
      }
    }
    return minCandidates;
  }
  
  public boolean allWayTie(){
    // Return true if an all-way tie has occurred and false
    // otherwise. This happens if all candidates have an equal number of
    // votes. Note that all-way ties correspond with getMinCanidates()
    // producing an array with equal length to the size() of the
    // tally.
    int allTie = votes[0];                        //In a way represents minCandidates() method, but less complex
    boolean check = false;
    for (int j = 0; j<candidates.length; j++){
      if(votes[j] == allTie){
        check = true;
      }
      else{                        //Uses if/else statements with a boolean to check of there is all way tie.
        return false;
      }
    }
    if(check == true);{
      return true;
    }
  }
  
  public Tally eliminate(String candidate){
    // Create a new Tally with the candidate specified eliminated. This
    // Tally should have 1 fewer candidates.  The vote counts for each
    // candidate in the resulting ballot shoudl be 0. If the candidate
    // mentioned is not in the Tally, throw a RuntimeException with the
    // message:
    //
    // 'Freddie' not in Tally{Francis:0, Claire:0, Heather:0, Viktor:0} 
    
    if(!contains(candidate)){   //Check the candidate. If there is no such name, runs exception.
      throw new RuntimeException(String.format("'%s' not in %s", candidate, toString()));           
    }
    else{
      String smallerCandidates[] = new String[candidates.length-1];
      int i = 0;
      while(i<candidates.length-1){
        if(!candidates[i].equals(candidate)){      //Copies all the elements before the candidate being dropped
          smallerCandidates[i] = candidates[i];
          i++;
        }
        else{
          smallerCandidates[i] = candidates[i+1];     //Jumping over the dropping candidate. Copy the rest of them.
          i += 2;
          while(i<candidates.length){
            smallerCandidates[i-1] = candidates[i];
            i++;
          }
        }
      }
      Tally smallerTally = new Tally(smallerCandidates);   //Create a new Tally
      return smallerTally;
    }
  }
  
  public static Tally readTallyFromFile(String filename) throws Exception{
    // Read candidate names from the first line of the given file and
    // create a Tally from them. The initial vote counts for each of
    // candidate are 0. Makes use of Scanner and the
    // Util.splitIntoStrings() method.  This method may throw Exceptions
    // and should not use a try/catch block.
    Scanner sc = new Scanner (new File (filename));
    String newCands[] = Util.splitIntoStrings(sc.nextLine());   //Uses Util to get the candidates.
    Tally newTally = new Tally (newCands);                      //Creates new tally with the given candidates.
    return newTally;
  }
  
  public String countAll(Vote votes[]){
    // Count all of the votes in the given array and add them to the
    // counts of votes in this tally. Each vote has its best remaining
    // candidate added to the tally.  While tabulating, create a
    // transcript String of the process which shows what is done for
    // each vote. This string has the following format
    //
    //  0 : Francis    Vote{Francis, Viktor, Heather, Claire} Tally{Francis:1, Claire:0, Heather:0}
    //  1 : Claire     Vote{Claire, Francis, Heather, Viktor} Tally{Francis:1, Claire:1, Heather:0}
    // ...
    //  9 : Francis    Vote{Viktor, Francis, Heather, Claire} Tally{Francis:4, Claire:2, Heather:4}
    // 10 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:5, Claire:2, Heather:4}
    // 11 : Heather    Vote{Heather, Francis, Claire, Viktor} Tally{Francis:5, Claire:2, Heather:5}
    // 
    // for which the following format string is useful:
    //   "%2d : %-10s %s %s\n"
    // arguments are the vote index, best candidate, vote toString(), and tally toString().
    //
    // If any Vote returns null, the behavior of this method is NOT
    // DEFINED. Any action may be taken such as printing a warning,
    // throwing an exception or ignoring the vote. No tests will be run
    // on this case.
    String message = "";
    for(int i = 0; i<votes.length; i++){
      this.countVote(votes[i].getBest(this));   //Refers tp the specific getBest of the votes[i]. 
      message += String.format("%2d : %-10s %s %s\n",i, votes[i].getBest(this), votes[i], this);
    }
    return message;
  }
  
}