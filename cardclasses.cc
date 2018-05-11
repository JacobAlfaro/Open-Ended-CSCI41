#include <iostream>
#include <algorithm>
#include <array>
#include <random>
#include <chrono>
using namespace std;
class Card {
	string suit;
	int rank;
	string rankName;
	string cardName;
	public:
	Card(string S, int R) {
		suit = S;
		rank = R;
		if (rank == 1) rankName = "Ace";
		else if (rank == 2) rankName = "2";
		else if (rank == 3) rankName = "3";
		else if (rank == 4) rankName = "4";
		else if (rank == 5) rankName = "5";
		else if (rank == 6) rankName = "6";
		else if (rank == 7) rankName = "7";
		else if (rank == 8) rankName = "8";
		else if (rank == 9) rankName = "9";
		else if (rank == 10) rankName = "10";
		else if (rank == 11) rankName = "Jack";
		else if (rank == 12) rankName = "Queen";
		else if (rank == 13) rankName = "King";
		cardName = rankName + " of " + suit;
	}
	void Print() {
		cout << cardName << " \n";
	}
};
class Deck {
	string[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
	int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	int size = 52;
	int spot = 0;
	int top = 0;
	Card[] deck =  new Card[size];
	public:
	//initialize
	Deck() {
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				deck[spot] = new Card(suits[i], ranks[j]);
				spot++;
			}
		}
		//shuffle (?)
		unsigned seed = now().time_since_epoch().count();
		shuffle (deck.begin(), deck.end(), seed)
		}
	}
	Card Draw() {
		top++;
		return deck[top - 1];
	}
};

class Hand {
	Card[] hand = new Card[26];
	last = 0;
	public:
	//starting hand
	Hand(Deck deck) {
		for (int i = 0; i < 26; i++) {
			if (i < 7) hand[i] = deck.draw();
			else hand[i] = new Card("", 0);
			last++;
		}
	}
	//print
	void print() {
		cout << "You have:\n";
		int i = 0;
		while (hand[i].getRank() != 0 && i < last + 1) {
			hand[i].print();
			i++;
		}
	}
	//add a card
	void push(Deck deck) {
		while (hand[i].getRank() != 0) {
			i++;
		}
		hand[i] = deck.draw();
		last++;
	}
	//search for a card
	bool search(int x) {
		int i = 0;
		while (hand[i].getRank() != 0 && i < last + 1) {
			if (hand[i].getRank() == x) return true;
			else i++;
		}
		return false;
	}
	//remove a card
	void pop(int x) {
		int i = 0;
		while (hand[i].getRank() != 0 && i < last + 1) {
			if (hand[i].getRank() == x) {
				hand[i] = hand[last];
				hand[last] = new Card("", 0)
				break;
			} else i++;
		}
	}
};


