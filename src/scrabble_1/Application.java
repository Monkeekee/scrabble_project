package scrabble_1;

import javax.swing.JOptionPane;

import Vue.Vue;

public class Application {
	
	
	public Application() {
		
	}
	
	
	

	public static void main(String[] args) {

		Modele m = new Modele(); 
		String nomPPrec =m.partiePrec.toString();
		
		//si on a deja une partie sauvegardée on la lance si sélectionné
		if (m.partiePrec.NbrJoueur != 0) {
			String Pte = (String) JOptionPane.showInputDialog(null, 
		  	      "Choisissez une partie a lancer :",
		  	      "Scrabble",
		  	      JOptionPane.QUESTION_MESSAGE,
		  	      null,
		  	      new String[] {"Nouvelle",nomPPrec}, nomPPrec);
			
			if (Pte == nomPPrec) {
				m.jouerPPrec();
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
		v.addKeyListener(c);
		v.addWindowListener(c);
		
		//m.newPartie(2);
		
		//System.out.println(m.dico); 
		//System.out.println(m.dico.existe("claqua")); //assez reactif
		
	}

}
