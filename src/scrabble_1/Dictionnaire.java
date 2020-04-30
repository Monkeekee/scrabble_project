package scrabble_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

public class Dictionnaire {

	//faudrait-il que la clé soit de type K : (Set<Character>,Integer) avec entier nombre de lettre?
	public HashMap<Set<Character>, ArrayList<String>> dico;	

		
		
		
	public Dictionnaire(String[] fichiers) {
		this.dico = new HashMap<Set<Character>, ArrayList<String>>();
		for (String fic : fichiers) {
			this.remplirDico(fic);
		}
		
	}
	
	
		
	
	
		//donne la clé associée au mot désiré pour le mettre dans le dictionnaire
		@SuppressWarnings("null")
		public Set<Character> clePour(String mot) {
			
			char[] motl = mot.toCharArray();
			Set<Character> cle = new TreeSet<Character>();
			for (char c : motl) {
				cle.add(c);
			}
			return cle;
		}
		
		//donne une idée de la longueur du dictionnaire
		public String toString() {
			String str = "Ce dictionnaire contient ";
			return str + Integer.toString(this.dico.keySet().size()) + "clés";
		}
		
		
		
		// à chaque fois que l'on démarre le jeu grace au texte ressource
		public void remplirDico(String fichier) {
			
			File fic = new File(fichier);
			
			try {
				FileInputStream fis = new FileInputStream(fic);
				Scanner sc = new Scanner(fis);
				
				while (sc.hasNextLine()) {
					
					String mot = sc.nextLine();
					//System.out.println(mot);
					
					
					Set<Character> cle = this.clePour(mot);
					//System.out.println(cle);
					
					
					//System.out.println(this.dico.keySet());
					if (this.dico.containsKey(cle)) {
						this.dico.get(cle).add(mot);
					}else {
						ArrayList<String> motl = new ArrayList<String>();
						motl.add(mot);
						this.dico.put(cle,motl);
					}
				}
			
			
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		
		//pour chercher si un mot existe dans le dictionnaire dico rempli
		public boolean existe(String mot) {
			Set<Character> cle = this.clePour(mot);
			if (this.dico.containsKey(cle)) {
				if (this.dico.get(cle).contains(mot)) {
					return true;
				}
			}
			
			return false;
		}
	
}
