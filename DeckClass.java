class card{
    private String suit = "A";
    private int rank = 0;
    private String rankName = "A";
    private String cardName = "A";
    public void setSuit(String s){
        suit = s;
    }
     public void setRank(int x){
        rank = x;
    }
    public void makeName(){
        if(rank == 1) rankName = "Ace";
        else if(rank == 2) rankName = "2";
        else if(rank == 3) rankName = "3";
        else if(rank == 4) rankName = "4";
        else if(rank == 5) rankName = "5";
        else if(rank == 6) rankName = "6";
        else if(rank == 7) rankName = "7";
        else if(rank == 8) rankName = "8";
        else if(rank == 9) rankName = "9";
        else if(rank == 10) rankName = "10";
        else if(rank == 11) rankName = "Jack";
        else if(rank == 12) rankName = "Queen";
        else if(rank == 13) rankName = "King";
        cardName = rankName + " of " + suit;
    }
    public void Print(){
    System.out.println(rankName);
    }
}

public class Deck {
    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
        int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int size = 52;
        int spot = 0;

        //initialize
        card[] deck =  new card[size];
        for(int i = 0; i < suits.length; i++){
            for(int j = 0;j < ranks.length; j++){
                card temp;
                temp.setSuit(suits[i]);
                temp.setRank(ranks[j]);
                temp.makeName();
                deck[spot] = temp;
                spot++;
            }
        }

        //print
        for (int i = 0; i < size; i++){
            deck[i].Print();
        }

        //shuffle (?)
        for(int i = 0; i < size; i++){
            int r = i + (int) (Math.random() * (size-i));
            card temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
    }
}
