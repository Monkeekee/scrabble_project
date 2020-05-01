package scrabble_1;

import java.util.ArrayList;

public class Player {
	
	public String name;
	public int score;
	public int num_j;
	public ArrayList<Character> main;
	
	public void setName(String n) {
		this.name=n;
	}
	
	
	public Player(int numj) {
		this.num_j=numj;
		this.score= 0;
		this.main = new ArrayList<Character>();
	}
	
	
	
	
}
