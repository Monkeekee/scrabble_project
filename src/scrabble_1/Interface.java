package scrabble_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Interface extends JPanel{
	
	
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	

	public static Color[] CouleurJoueur = {Color.MAGENTA, Color.BLUE, Color.GREEN, Color.YELLOW} ;
	
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private int frameWidth=screenSize.width;
	private int frameHeight=screenSize.height;
	
	public Main main;//pour les jetons du joueur
	
	public Modele modl;
	public Controleur ctrl;
	
	private int spacing=1;
	private int cellsize = frameHeight/16;
	
	private int width= frameWidth -(15*cellsize );
	
	public cell temp1,temp2 ;
	private ArrayList<cell> mainC; //copie jaune en cell du joueur actif
	
	
	public Interface(Modele m, Controleur c) {
		super();
		this.ctrl =c;
		this.modl =m;
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		int sizebutonW =(frameWidth/6 - cellsize*15)/4;
		int sizebutonH=frameHeight/6;
		
		//partie boutons
	    JButton BEnd = new JButton("Valider");
	    JButton BNext = new JButton("Passer");
	    JButton BPioche = new JButton("Changer");
	    JButton Bsupp = new JButton("Annuler");
		
		BEnd.setBounds(cellsize*15,frameHeight/2 ,sizebutonW,sizebutonH);
		BEnd.setText("VALIDER MOT");
		BNext.setBounds(cellsize*15 +sizebutonW,frameHeight/3,sizebutonW,sizebutonH);
		BNext.setText("FIN DU TOUR");
		BPioche.setBounds(cellsize*15 + 2*sizebutonW,frameHeight/2,sizebutonW,sizebutonH);
		BPioche.setText("CHANGER LETTRE.S");
		Bsupp.setBounds(cellsize*15 + 3*sizebutonW,frameHeight/3,sizebutonW,sizebutonH);
		Bsupp.setText("ANNULER");
		
		this.add(BEnd);
		this.add(BNext);
		this.add(BPioche);
		this.add(Bsupp);
		
		this.main = new Main(m,c);
		this.main.setLayout(new GridLayout());
		this.main.setVisible(true);
		this.add(main);
		
		this.repaint();
	}
	
	public void paint(Graphics g) {	
		this.pPart(g);//
		this.main.drawMain(g);//
		}
	
	public void pPart(Graphics g) { //pas ici
		g.setColor(Color.cyan);
		g.fillRect(cellsize*15, 0, width, (frameHeight)/3);//partie score
		g.setColor(Color.gray);
		g.fillRect(cellsize*15, frameHeight/3, width, (frameHeight)/3);//partie button
		//g.setColor(Color.LIGHT_GRAY);
		//g.fillRect(cellsize*15, (2*frameHeight)/3, width, (frameHeight)/3); //partie lettre
	}
	


	//
	//pour stocker les 7 jetons
	//
	public class Main extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Modele modl;
		public Controleur ctrl;
		
		
		public void paint(Graphics g) {
			this.drawMain(g);
		}
		
		public Main(Modele m, Controleur C) {
			this.modl=m;
			this.ctrl=C;
			this.repaint();
		}
		
		public void drawMain(Graphics g) {
			Dimension d = this.getSize();
			int dw = d.width;
			int dh = d.height;
			
			
			int i = 0;
			
			for (char c : this.modl.partieEC.J_actif.main) { //on dessine toute la mainM dans la mainV
				g.setColor(Interface.CouleurJoueur[this.modl.partieEC.J_actif.num_j]); 
				g.drawRect(i*dw/7, 0, dh, dw/7);
				g.fillRect(i*dw/7, 0, dh, dw/7);
				
				g.setColor(Color.BLACK); 
				g.drawString(""+c, i*dw/7, dh*2/3);
				g.drawString(Integer.toString(this.modl.partieEC.PtsLettre.get(c)), i*dw/7, dh*4/5);
				i++;
			}
			
			
			
		}
		
	}
	
	
	
	
	
	

}
