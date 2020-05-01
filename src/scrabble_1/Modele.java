package scrabble_1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Observable;


public class Modele extends Observable{
	
	public int NbJ;
	public ArrayList<Partie> parties;
	File fichier = new File("parties.xml");
	
	public Dictionnaire dico;
	public Partie partieEC;  //partie en cours
	
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
	
	public cell[][] PlateauLettre;
	
	
	
	public Modele() {
		String[] dicos = {"./dico_a-g.txt","./dico_h-z.txt"};
		this.dico = new Dictionnaire(dicos);
		this.PlateauLettre = new cell[15][15];
		
		XMLDecoder decoder = null;
		if (this.fichier.exists()) {		
			try {
				FileInputStream fis = new FileInputStream(fichier);
				BufferedInputStream bis = new BufferedInputStream(fis);
				decoder = new XMLDecoder(bis);
				
				this.parties = (ArrayList<Partie>) decoder.readObject();
				
				}catch (Exception e) {
					throw new RuntimeException("Chargement des donn�es impossible");
				}finally {
					if (decoder != null) decoder.close();
			}
		}
	}
	
	
	public void enregistrer() {
		XMLEncoder encoder = null;
		try {
			FileOutputStream fos = new FileOutputStream("parties.xml");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			encoder = new XMLEncoder(bos);
			
			encoder.writeObject(this.parties);
			encoder.flush();
		}catch (final java.io.IOException e) {
			throw new RuntimeException("Ecriture des donn�es impossible");
		}finally {
			if (encoder != null) encoder.close();
		}
	}

	public ArrayList<Partie> getParties() {
		return parties;
	}

	public void setParties(ArrayList<Partie> parties) {
		this.parties = parties;
	}
	
	public void newPartie(int NbJ) {
		this.NbJ = NbJ;
		this.partieEC = new Partie(this.NbJ);
		
	}
	
	public void PlacerLettre(char lettre,int x, int y) {
		this.PlateauLettre[x][y].x=x ;
		this.PlateauLettre[x][y].x=y ;
		this.PlateauLettre[x][y].letter=lettre;
		this.PlateauLettre[x][y].occupied=true;
		
	}
	
	
	public void changeEtat(Integer e) { //pour communiquer avec la vue de tout changement du modele
		this.setChanged();
		this.notifyObservers(e);
	}

	
}
