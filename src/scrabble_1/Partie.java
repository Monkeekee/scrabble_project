package scrabble_1;

import java.util.HashMap;
import java.util.Map;

public class Partie {
	 
	
	public int NbrJoueur;
	public int[] TableauScore;
	public static int[][] Plateau = {{4,0,0,1,0,0,0,4,0,0,0,1,0,0,4}
									,{0,2,0,0,0,3,0,0,0,3,0,0,0,2,0}
									,{0,0,2,0,0,0,1,0,1,0,0,0,2,0,0}
									,{1,0,0,2,0,0,0,1,0,0,0,2,0,0,1}
									,{0,0,0,0,2,0,0,0,0,0,2,0,0,0,0}
									,{0,3,0,0,0,3,0,0,0,3,0,0,0,3,0}
									,{0,0,1,0,0,0,1,0,1,0,0,0,1,0,0}
									,{4,0,0,1,0,0,0,-1,0,0,0,1,0,0,4}
									,{0,0,1,0,0,0,1,0,1,0,0,0,1,0,0}
									,{0,3,0,0,0,3,0,0,0,3,0,0,0,3,0}
									,{0,0,0,0,2,0,0,0,0,0,2,0,0,0,0}
									,{1,0,0,2,0,0,0,1,0,0,0,2,0,0,1}
									,{0,0,2,0,0,0,1,0,1,0,0,0,2,0,0}
									,{0,2,0,0,0,3,0,0,0,3,0,0,0,2,0}
									,{4,0,0,1,0,0,0,4,0,0,0,1,0,0,4}};
	
	static char[] lettres = {'a','b','c','d','e','f','g','h','i','j','k','l','m'
			,'n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
	
	static int[] quantite = {9,2,2,3,15,2,2,2,8,1,1,5,3
			,6,6,2,1,6,6,6,6,2,1,1,1,1,2};
	
	static int[] points = {1,3,3,2,1,4,2,4,1,8,10,1,2
			,1,1,3,8,1,1,1,1,4,10,10,10,10,0};
	
	public Map<Character,Integer> Sac; //faire marcher
	
	
	Sac = new HashMap<Character,Integer>();
	
	for (int i=0; i<= 26; i++) {
		Sac.put(lettres[i], quantite[i]);
	}
	
	
	
	
	
	
	
	
	
	
	public Partie(int NbrJ) {
		this.NbrJoueur = NbrJ;
	}
	
	
	
}





	