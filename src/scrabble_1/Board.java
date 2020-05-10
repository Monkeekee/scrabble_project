package scrabble_1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

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
		this.ctrl = ctrl;
		this.repaint();
	}
	
	
	
	public void paintComponent(Graphics g) {		
		this.pPart(g);//
		this.pBoard(g);
		this.drawMain(g);//


		}
	
	
	public void pPart(Graphics g) { //pas ici

		g.setColor(Color.cyan);
		g.fillRect(cellsize*15, 0, width, (frameHeight)/3);//partie score
		g.setColor(Color.gray);
		g.fillRect(cellsize*15, frameHeight/3, width, (frameHeight)/3);//partie button
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(cellsize*15, (2*frameHeight)/3, width, (frameHeight)/3); //partie lettre

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
	
	public void createCellMain(){
		int size=width/7;
		int i=0;
		int x=cellsize*15;
		int y=(2 *(frameHeight)/3);
		for (char c : this.modl.partieEC.J_actif.main) {
			mainC.add(new cell(x+i*size,(frameHeight/12) +y,c,2,Color.YELLOW,size));
			i=i+1;
		}
	
		
	}
	public void drawMain(Graphics g) {
		this.createCellMain();
		for(cell cellule: mainC) {
			cellule.paintCell1(g );
			cellule.paintLetter(g, Color.BLACK);
		}
	}




	
}

