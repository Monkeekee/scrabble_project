package scrabble_1;

import javax.swing.JOptionPane;

import Vue.Vue;

public class Application {
	
	
	public Application() {
		
	}
	
	
	

	public static void main(String[] args) {

		Modele m = new Modele(); 
		
		//si on a deja une partie sauvegardée on la lance si sélectionné
		if (m.parties.size() != 0) {
			String Pte = (String) JOptionPane.showInputDialog(null, 
		  	      "Choisissez une partie a lancer :",
		  	      "Scrabble",
		  	      JOptionPane.QUESTION_MESSAGE,
		  	      null,
		  	      new String[] {"Nouvelle","Précédente"}, "Précédente");
			
			if (Pte == "Précédente") {
				m.partieEC=m.parties.get(0);
				m.parties.remove(0);
			}
			else {
				Integer NbJ = (Integer) JOptionPane.showInputDialog(null, 
				  	      "Veuillez selectionner le nombre de joueur :",
				  	      "Scrabble",
				  	      JOptionPane.QUESTION_MESSAGE,
				  	      null,
				  	      new Integer[] {1,2,3,4}, 2);
						
						m.newPartie(NbJ);
			}
		}else {
			Integer NbJ = (Integer) JOptionPane.showInputDialog(null, 
		  	      "Veuillez selectionner le nombre de joueur :",
		  	      "Scrabble",
		  	      JOptionPane.QUESTION_MESSAGE,
		  	      null,
		  	      new Integer[] {1,2,3,4}, 2);
		
			m.newPartie(NbJ);
		}
		
		
		
		
		
		
		
		
		
		Controleur c = new Controleur(m);
		
		Vue v = new Vue(c,m);  // JFRAME
		
		m.addObserver(v);
		
		v.setVisible(true);
		
		
		//m.newPartie(2);
		
		//System.out.println(m.dico); 
		//System.out.println(m.dico.existe("claqua")); //assez reactif
		
	}

}
