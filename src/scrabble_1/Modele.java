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
	
	public ArrayList<Partie> parties;
	File fichier = new File("parties.xml");
	
	public Dictionnaire dico;
	//public Partie partie;
	
	
	
	
	
	public Modele() {
		String[] dicos = {"./dico_a-g.txt","./dico_h-z.txt"};
		this.dico = new Dictionnaire(dicos);
		
		XMLDecoder decoder = null;
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

	
	public void changeEtat(Integer e) {
		this.setChanged();
		this.notifyObservers(e);
	}


}
