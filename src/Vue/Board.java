package Vue;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import scrabble_1.Controleur;
import scrabble_1.Modele;
import scrabble_1.cell;

public class Board extends JPanel implements Observer{
	
	public Modele modl;
	public Controleur ctrl;
	
	static int bWidth = Integer.min(Vue.screenHeight,Vue.screenWidth*2/3);;
	static int bHeigth = Integer.min(Vue.screenHeight,Board.bWidth);
	
	private int cellsize = Board.bHeigth/15;
	
	public cell temp1,temp2 ;
	private ArrayList<cell> mainC; //copie jaune en cell du joueur actif

	
	public static Color[] ColorCase = {Color.BLACK,Color.GREEN,Color.LIGHT_GRAY,Color.RED,Color.CYAN,Color.BLUE,Color.ORANGE};	
	

	
	public Board(Modele modl, Controleur C) {
		super();
		this.setPreferredSize(new Dimension(Board.bWidth,Board.bHeigth));
		this.modl = modl;
		this.ctrl = C;
		this.setVisible(true);
		this.repaint();
		this.addMouseListener(ctrl);
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



	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	





	
}

