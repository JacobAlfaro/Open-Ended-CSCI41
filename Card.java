public class Card{
    private String suit;
    private int rank;
    private String rankName
    private String cardName;
    public Card(String S, int R){
        suit = S;
        rank = R;
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
    System.out.println(cardName);
    }
}
