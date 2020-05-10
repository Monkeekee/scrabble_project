package scrabble_1;

import java.awt.Color;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class Modele extends Observable{
	
	
	public enum etats{
		ENCOURS, FINI
	}
	
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
	
	public Color[] colors = {Color.GREEN,Color.LIGHT_GRAY,Color.RED,Color.CYAN,Color.BLUE,Color.ORANGE};
	
	
	
	public Modele() {
		//String[] dicos = {"./dico_a-g.txt","./dico_h-z.txt"};
		//this.dico = new Dictionnaire(dicos);
		//this.PlateauLettre = new cell[15][15];
		
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
	
	public void chargeDico() {
		String[] dicos = {"./dico_a-g.txt","./dico_h-z.txt"};
		this.dico = new Dictionnaire(dicos);
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
		this.chargeDico();	
		this.NbJ = NbJ;
		this.partieEC = new Partie(this.NbJ);
	}
	
	
	public void changeTour() {
		this.partieEC.nextPlayer();
		this.setChanged();
		this.notifyObservers();
	}
	
	public boolean confirmerMot(int x1, int y1, int x2, int y2) {
		return this.partieEC.confirmerMot(x1, y1, x2, y2, this.dico);
	}
	
	public void PlacerLettre(char c,int x,int y) {
		this.partieEC.PlacerLettre(c, x, y);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void changeEtat(Integer e) { //pour communiquer avec la vue de tout changement du modele
		this.setChanged();
		this.notifyObservers(e);
	}
	
}
