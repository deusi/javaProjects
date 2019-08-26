package rybki001_proj2;

// The complete version of the second project.
// I've noticed that every time you lose, the program gives to you pile one, but the professor
// said that it is fine.

//Did not put the comments describing each method because we already have the description in the assignment.

// Output at the end of the code.

import java.util.Random;


final class Card
{

//  RANK NAME. Printable names of card ranks. We don't use index 0.

    private static final String[] rankName =
            {
                    "",        //   0
                    "ace",     //   1
                    "two",     //   2
                    "three",   //   3
                    "four",    //   4
                    "five",    //   5
                    "six",     //   6
                    "seven",   //   7
                    "eight",   //   8
                    "nine",    //   9
                    "ten",     //  10
                    "jack",    //  11
                    "queen",   //  12
                    "king"     //  13
            };

    private int rank;  //  Card rank, between 1 and 13.

//  CARD. Constructor. Make a new CARD with a given RANK.

    public Card(int rank)
    {
        if (1 <= rank && rank <= 13)
        {
            this.rank = rank;
        }
        else
        {
            throw new IllegalArgumentException("Illegal rank.");
        }
    }

//  GET RANK. Return the RANK of this CARD.

    public int getRank()
    {
        return rank;
    }

//  TO STRING. Return a STRING that describes this CARD, for printing only.

    public String toString()
    {
        return rankName[rank];
    }
}

class Deck
{
    private int dealy = 0;
    private Card deck [];

    public Deck()
    {
        deck = new Card[52];
        int count = 0;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 13; j++) {

                deck[count++] = new Card(j + 1);
            }
        }
    }

    public Card deal()
    {
        if (dealy >= 52)
        {
            throw new IllegalStateException("MN!");
        }
        else
        {
            return deck[dealy++];
        }
    }

    public void shuffle()
    {
        Random rand = new Random();
        if (dealy > 0)
        {
            throw new IllegalStateException("MN!");
        }
        else
        {
            for(int i = deck.length-1; i > 0; i--)
            {
                int j = Math.abs(rand.nextInt()) % 52;
                Card temp = deck[i];
                deck[i] = deck[j];
                deck[j] = temp;
            }
        }
    }

}

class Pile
{
    private Layer top;
    private class Layer
    {
        public Card card;
        public Layer next;
        public Layer (Card card, Layer next)
        {
            this.card = card;
            this.next = next;
        }
    }

    public Pile()
    {
        top = new Layer(null, null);
    }

    public void add(Card card)
    {
        top = new Layer(card, top);
    }

    public Card turn()
    {
        if(top.card == null)
        {
            throw new IllegalStateException("MTQ!");
        }
        Card card = top.card;
        top = top.next;
        return card;
    }

    public boolean isEmpty()
    {
        return top.card == null;
    }
}

class Tableau
{
    private Pile piley[];

    public Tableau()
    {
        piley = new Pile[14];
        Deck decky = new Deck();
        decky.shuffle();
        for(int i = 1; i < piley.length; i++)
        {
            piley[i] = new Pile();
            int j = 0;
            while(j < 4)
            {
                piley[i].add(decky.deal());
                j++;
            }
        }
    }

    private boolean hasWon()
    {
        for (int i = 1; i < piley.length; i++)
        {
            if (!piley[i].isEmpty())
            {
                return false;
            }
        }
        return true;
    }

    public void play()
    {
        int p = 1;
        while (true)
        {
            if(piley[p].isEmpty() && !hasWon())
            {
                System.out.println("Pile " + p + " is empty. You lost!");
                break;

            }
            else if(hasWon())
            {
                System.out.println("You won!");
                break;
            }
            Card card = piley[p].turn();
            System.out.println("Got " + card + " from pile " + p);
            p = card.getRank();
        }
    }
}

class Perditio
{
    public static void main (String args[])
    {
        Tableau tabl = new Tableau();
        tabl.play();
    }
}

//                OUTPUT


//        Got ace from pile 1
//        Got eight from pile 1
//        Got four from pile 8
//        Got eight from pile 4
//        Got two from pile 8
//        Got nine from pile 2
//        Got three from pile 9
//        Got six from pile 3
//        Got three from pile 6
//        Got ace from pile 3
//        Got three from pile 1
//        Got ten from pile 3
//        Got two from pile 10
//        Got king from pile 2
//        Got five from pile 13
//        Got seven from pile 5
//        Got king from pile 7
//        Got seven from pile 13
//        Got king from pile 7
//        Got three from pile 13
//        Got jack from pile 3
//        Got nine from pile 11
//        Got queen from pile 9
//        Got two from pile 12
//        Got six from pile 2
//        Got seven from pile 6
//        Got five from pile 7
//        Got king from pile 5
//        Got nine from pile 13
//        Got jack from pile 9
//        Got eight from pile 11
//        Got five from pile 8
//        Got seven from pile 5
//        Got jack from pile 7
//        Got ace from pile 11
//        Got queen from pile 1
//        Got queen from pile 12
//        Got nine from pile 12
//        Got ten from pile 9
//        Got queen from pile 10
//        Got ten from pile 12
//        Got two from pile 10
//        Got four from pile 2
//        Got eight from pile 4
//        Got six from pile 8
//        Got four from pile 6
//        Got six from pile 4
//        Got ten from pile 6
//        Got jack from pile 10
//        Got four from pile 11
//        Got five from pile 4
//        Got ace from pile 5
//        You won!


//        Got seven from pile 1
//        Got queen from pile 7
//        Got ace from pile 12
//        Got nine from pile 1
//        Got six from pile 9
//        Got seven from pile 6
//        Got ten from pile 7
//        Got two from pile 10
//        Got king from pile 2
//        Got queen from pile 13
//        Got ten from pile 12
//        Got two from pile 10
//        Got eight from pile 2
//        Got eight from pile 8
//        Got jack from pile 8
//        Got nine from pile 11
//        Got six from pile 9
//        Got nine from pile 6
//        Got three from pile 9
//        Got queen from pile 3
//        Got three from pile 12
//        Got jack from pile 3
//        Got five from pile 11
//        Got king from pile 5
//        Got five from pile 13
//        Got four from pile 5
//        Got eight from pile 4
//        Got ten from pile 8
//        Got three from pile 10
//        Got ace from pile 3
//        Got three from pile 1
//        Got two from pile 3
//        Got four from pile 2
//        Got king from pile 4
//        Got ace from pile 13
//        Got eight from pile 1
//        Got ace from pile 8
//        Pile 1 is empty. You lost!



//        Got jack from pile 1
//        Got three from pile 11
//        Got two from pile 3
//        Got six from pile 2
//        Got ten from pile 6
//        Got nine from pile 10
//        Got five from pile 9
//        Got three from pile 5
//        Got two from pile 3
//        Got jack from pile 2
//        Got nine from pile 11
//        Got four from pile 9
//        Got seven from pile 4
//        Got six from pile 7
//        Got eight from pile 6
//        Got five from pile 8
//        Got nine from pile 5
//        Got seven from pile 9
//        Got ace from pile 7
//        Got eight from pile 1
//        Got king from pile 8
//        Got king from pile 13
//        Got king from pile 13
//        Got ten from pile 13
//        Got ten from pile 10
//        Got nine from pile 10
//        Got three from pile 9
//        Got jack from pile 3
//        Got queen from pile 11
//        Got five from pile 12
//        Got jack from pile 5
//        Got seven from pile 11
//        Got four from pile 7
//        Got queen from pile 4
//        Got four from pile 12
//        Got two from pile 4
//        Got ace from pile 2
//        Got six from pile 1
//        Got four from pile 6
//        Got two from pile 4
//        Got king from pile 2
//        Got seven from pile 13
//        Got queen from pile 7
//        Got five from pile 12
//        Got ace from pile 5
//        Got ace from pile 1
//        Pile 1 is empty. You lost!



//        Got three from pile 1
//        Got five from pile 3
//        Got ace from pile 5
//        Got eight from pile 1
//        Got four from pile 8
//        Got jack from pile 4
//        Got ace from pile 11
//        Got three from pile 1
//        Got ace from pile 3
//        Got ace from pile 1
//        Pile 1 is empty. You lost!



//        Got ace from pile 1
//        Got five from pile 1
//        Got ace from pile 5
//        Got five from pile 1
//        Got four from pile 5
//        Got ten from pile 4
//        Got seven from pile 10
//        Got three from pile 7
//        Got queen from pile 3
//        Got ten from pile 12
//        Got king from pile 10
//        Got four from pile 13
//        Got queen from pile 4
//        Got king from pile 12
//        Got nine from pile 13
//        Got five from pile 9
//        Got three from pile 5
//        Got five from pile 3
//        Got four from pile 5
//        Got six from pile 4
//        Got king from pile 6
//        Got jack from pile 13
//        Got seven from pile 11
//        Got jack from pile 7
//        Got ace from pile 11
//        Got six from pile 1
//        Got nine from pile 6
//        Got nine from pile 9
//        Got queen from pile 9
//        Got eight from pile 12
//        Got two from pile 8
//        Got two from pile 2
//        Got seven from pile 2
//        Got two from pile 7
//        Got ace from pile 2
//        Pile 1 is empty. You lost!



//        Got seven from pile 1
//        Got four from pile 7
//        Got nine from pile 4
//        Got three from pile 9
//        Got two from pile 3
//        Got two from pile 2
//        Got nine from pile 2
//        Got jack from pile 9
//        Got two from pile 11
//        Got jack from pile 2
//        Got eight from pile 11
//        Got ten from pile 8
//        Got five from pile 10
//        Got three from pile 5
//        Got six from pile 3
//        Got four from pile 6
//        Got queen from pile 4
//        Got three from pile 12
//        Got six from pile 3
//        Got jack from pile 6
//        Got king from pile 11
//        Got seven from pile 13
//        Got ten from pile 7
//        Got king from pile 10
//        Got nine from pile 13
//        Got five from pile 9
//        Got two from pile 5
//        Got eight from pile 2
//        Got queen from pile 8
//        Got five from pile 12
//        Got six from pile 5
//        Got king from pile 6
//        Got ten from pile 13
//        Got ten from pile 10
//        Got ace from pile 10
//        Got queen from pile 1
//        Got seven from pile 12
//        Got three from pile 7
//        Got four from pile 3
//        Got six from pile 4
//        Got four from pile 6
//        Got seven from pile 4
//        Got nine from pile 7
//        Got king from pile 9
//        Got five from pile 13
//        Got queen from pile 5
//        Got ace from pile 12
//        Got jack from pile 1
//        Got eight from pile 11
//        Got eight from pile 8
//        Got ace from pile 8
//        Got ace from pile 1
//        You won!
