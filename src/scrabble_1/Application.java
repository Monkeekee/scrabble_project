package scrabble_1;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modele m = new Modele();
		
		Controleur c = new Controleur(m);
		
		Vue v = new Vue(c,m);  // JFRAME
		
		m.addObserver(v);
		
		
		
		
		//m.newPartie(2);
		
		//System.out.println(m.dico); 
		//System.out.println(m.dico.existe("claqua")); //assez reactif
		
	}

}
