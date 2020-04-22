package scrabble_1;


public class Modele {

	public Dictionnaire dico;
	//public Partie partie;
	
	
	
	
	
	public Modele() {
		String[] dicos = {"./dico_a-g.txt","./dico_h-z.txt"};
		this.dico = new Dictionnaire(dicos);
	}
	

	
	


}
