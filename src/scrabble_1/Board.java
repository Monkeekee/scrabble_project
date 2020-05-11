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
	
	private int frameWidth=screenSize.width-30;
	private int frameHeight=screenSize.height-30;
	
	
	private int cellsize = frameHeight/15;
	
	private int width= 15*cellsize;
	
	public cell temp1,temp2 ;
	private ArrayList<cell> mainC; //copie jaune en cell du joueur actif

	
	public static Color[] ColorCase = {Color.BLACK,Color.GREEN,Color.LIGHT_GRAY,Color.RED,Color.CYAN,Color.BLUE,Color.ORANGE};	
	

	
	public Board(Modele modl, Controleur C) {
		super();
		this.setPreferredSize(new Dimension(2*screenSize.width/3,screenSize.height));
		this.modl = modl;
		this.ctrl = C;
		this.setVisible(true);
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
		    	int c = this.cellsize;
		    	g.setColor(Board.ColorCase[Modele.Plateau[i][j]+1]);
		    	
		    	
		    	cell cellule=this.modl.partieEC.plateau.get(i).get(j);
		    	if (cellule.checked) {
		    		g.setColor(Color.YELLOW);
		    	}

		    	g.fillRect(i*c, j*c, c, c);
		    	g.drawString(""+cellule.letter, i*c+c/2, j*c + c/2);
		    	
		    	g.setColor(Color.BLACK);
		    	g.drawRect(i*c, j*c, c, c);
		    } 
		}
	}
	





	
}

