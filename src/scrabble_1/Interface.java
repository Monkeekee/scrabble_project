package scrabble_1;

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
	
	public Modele modl;
	public Controleur ctrl;
	
	
	public static Color[] CouleurJoeur = {Color.MAGENTA, Color.BLUE, Color.GREEN, Color.YELLOW} ;
	
	public static Color[] ColorCase = {Color.BLACK,Color.GREEN,Color.LIGHT_GRAY,Color.RED,Color.CYAN,Color.BLUE,Color.ORANGE};	
	
	
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private int frameWidth=screenSize.width;
	private int frameHeight=screenSize.height;
	
	
	private int spacing=1;
	private int cellsize = frameHeight/16;
	
	private int width= frameWidth -(15*cellsize );
	
	public cell temp1,temp2 ;
	private ArrayList<cell> mainC; //copie jaune en cell du joueur actif
	
	
	public Interface(Modele m, Controleur c) {
		super();
		this.ctrl =c;
		this.modl =m;
		this.setLayout(new GridLayout());
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
		this.repaint();
	}
	
	public void paint(Graphics g) {	
		this.createCellMain();
		this.pPart(g);//
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
	
	
	public void createCellMain(){
		int size=width/7;
		int x=cellsize*15;
		int y=(2 *(frameHeight)/3);
		int i = 0;
		for (char c : this.modl.partieEC.J_actif.main) {
			mainC.add(new cell(x+i*size,(frameHeight/12) +y,c,2,Color.YELLOW,size));
			i++;
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
