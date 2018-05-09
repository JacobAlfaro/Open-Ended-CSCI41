public class Deck {
        private String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
        private int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        private int size = 52;
        private int spot = 0;
        //initialize
	public Deck(){
        Card[] deck =  new Card[size];
        for(int i = 0; i < suits.length; i++){
            for(int j = 0;j < ranks.length; j++){
                Card temp = new Card(suits[i], ranks[j]);
                deck[spot] = temp;
                spot++;
            }
        }
        //shuffle (?)
        for(int i = 0; i < size; i++){
            int r = i + (int) (Math.random() * (size-i));
            Card temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
    }
}
