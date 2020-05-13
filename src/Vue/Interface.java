package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Toolkit;
import java.util.ArrayList;


import javax.swing.JPanel;


import scrabble_1.Controleur;
import scrabble_1.Modele;
import scrabble_1.cell;



public class Interface extends JPanel{
	
	
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	

	public static Color[] CouleurJoueur = {Color.MAGENTA, Color.PINK, Color.GREEN, Color.YELLOW} ;
	
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static int iWidth= Vue.screenWidth-Board.bWidth;
	public static int iHeight=Vue.screenHeight;
	
	public Main main;//pour les jetons du joueur
	public RangeBtn Rb;
	public TabScore Tb;
	
	public Modele modl;
	public Controleur ctrl;
	
	private ArrayList<cell> mainC; //copie jaune en cell du joueur actif
	
	
	public Interface(Modele m, Controleur c) {
		super();
		this.setPreferredSize(new Dimension(Interface.iWidth,Interface.iHeight));
		this.ctrl =c;
		this.modl =m;
		this.setLayout(new BorderLayout());
		
		
		this.main = new Main(m,c);
		this.Tb = new TabScore(m,c);
		this.Rb = new RangeBtn(m,c);

		this.add(Rb,BorderLayout.CENTER);
		this.add(main,BorderLayout.SOUTH);
		this.add(Tb,BorderLayout.NORTH);
		
		
		this.setVisible(true);
		
	}
	
}