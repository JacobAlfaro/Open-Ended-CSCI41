#include <iostream>
#include <vector>
#include <algorithm>
#include <fstream>
using namespace std;

class playerScore {
	string name;
	float score = 0;
  public:
	playerScore() {
		name = "";
		score = 0;
	}
	playerScore(string s, float f) {
		name = s;
		score = f;
	}
	void printPlayer(int i) {
		cout << i + 1 << " " << name << " " << score << endl;
	}
	friend bool operator < (const playerScore& lhs, const playerScore& rhs) {
		return (lhs.score < rhs.score);
	}
};

void saveScore(string name, float score) {
	ofstream scoreFile("scores", fstream::app);
	scoreFile << name << " " << score << endl;
	scoreFile.close();
}

void printLeaderboard() {
	vector<playerScore> players;
	string s;
	float f = 0;
	ifstream scoreFile("scores");
	while (true) {
		if (scoreFile.eof())break;
		scoreFile >> s;
		scoreFile >> f;
		players.push_back(playerScore(s, f));
	}
	scoreFile.close();
	players.pop_back();
	make_heap(players.begin(), players.end());
	for (int i = 0; i < 10; i++) {
		if (players.size() > 0) {
			pop_heap(players.begin(), players.end());
			players.back().printPlayer(i);
			players.pop_back();
		}
	}
}

int main() {
	while (true) {
		float score = 0;
		string name;
		cout << "input name\n";
		cin >> name;
		if (name == "quit") break;
		cout << "input score\n";
		cin >> score;
		saveScore(name, score);
	}
	printLeaderboard();
}
