package scrabble_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Partie implements Serializable {
	
	private static final long serialVersionUID = 123L;
	
	public int NbrJoueur;
	public int[] TableauScore;
	
	static char[] lettres = {'a','b','c','d','e','f','g','h','i','j','k','l','m'
			,'n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
	
	static int[] quantite = {9,2,2,3,15,2,2,2,8,1,1,5,3
			,6,6,2,1,6,6,6,6,2,1,1,1,1,2};
	
	static int[] points = {1,3,3,2,1,4,2,4,1,8,10,1,2
			,1,1,3,8,1,1,1,1,4,10,10,10,10,0};
	
	public Map<Character,Integer> Sac;
	public Map<Character,Integer> PtsLettre;
	
	
	public ArrayList<ArrayList<cell>> plateau = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	public Partie(int NbrJ) {
		this.NbrJoueur = NbrJ;
		this.Sac = new HashMap<Character,Integer>();
		this.PtsLettre = new HashMap<Character,Integer>();
	
		for (int i=0; i<= 26; i++) {
			Sac.put(lettres[i], quantite[i]);
			PtsLettre.put(lettres[i], points[i]);
		}
		
		for (int i=0 ; i < NbrJ ; i++) {//pour chaque joueur faire...
			
		}
		
		for (int i = 0; i <15 ; i++) { //initialisation des cases du plateau
			ArrayList<cell> e = new ArrayList<>();
			this.plateau.add(e);
			//System.out.println(i);
			
			
			for (int j = 0 ; j<15 ; j++) {
				//System.out.println(j);
				e.add(new cell(Modele.Plateau[i][j])); //la value est déterminee par le Plateau de Modèle
			}
			
		}
		
		//System.out.println(this);
	}
	
	public String toString() {
		String res = Integer.toString(this.NbrJoueur) + " ";
		
		for (ArrayList<cell> l : this.plateau) { //initialisation des cases du plateau
			res = res +"\n";
			
			for (cell c : l) {
				//res = res + Integer.toString(c.value);
				res = res + c.toString();
				//la value est déterminee par le Plateau de Modèle
			}
		}
		
		return res;
	}
	
	
	
}





	