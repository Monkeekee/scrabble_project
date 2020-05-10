package scrabble_1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel{
	
	public Modele modl;
	public Controleur ctrl;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private int frameWidth=screenSize.width;
	private int frameHeight=screenSize.height;
	
	
	private int spacing=1;
	private int cellsize = frameHeight/16;
	
	private int width= frameWidth -(15*cellsize );
	
	public cell temp1,temp2 ;
	private ArrayList<cell> mainC; //copie jaune en cell du joueur actif

	

	

	
	public Board(Modele modl, Controleur C) {
		this.modl = modl;
		this.ctrl = C;
		this.repaint();

	}
	
	
	
	public void paint(Graphics g) {		
		this.pBoard(g);
		}
	
	

	
	public void pBoard(Graphics g){
		for (int i = 0; i < 15; i++)
		{
		    for (int j = 0; j < 15; j++)
		    {
		    	cell cellule=this.modl.partieEC.plateau.get(i).get(j);
		    	cellule.paintCell1(g );
		    } 
		}
	}
	





	
}

