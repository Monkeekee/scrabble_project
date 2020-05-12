package scrabble_1;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	
	public int indiceLettre(char c) {
		int i=0;
		for (char cc : this.main) {
			if (cc == c) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	
}
