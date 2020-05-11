package scrabble_1;

import javax.swing.JOptionPane;

public class Application {
	
	
	public Application() {
		
	}
	
	
	
	

	public static void main(String[] args) {

		Modele m = new Modele();
		Integer NbJ = (Integer) JOptionPane.showInputDialog(null, 
  	      "Veuillez selectionner le nombre de joueur :",
  	      "Scrabble",
  	      JOptionPane.QUESTION_MESSAGE,
  	      null,
  	      new Integer[] {1,2,3,4}, 2);
		
		m.newPartie(NbJ);
		
		
		
		
		Controleur c = new Controleur(m);
		
		Vue v = new Vue(c,m);  // JFRAME
		
		m.addObserver(v);
		
		
		
		
		//m.newPartie(2);
		
		//System.out.println(m.dico); 
		//System.out.println(m.dico.existe("claqua")); //assez reactif
		
	}

}
