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
	
	public static int iWidth= Vue.screenWidth-Board.bWidth;
	public static int iHeight=Vue.screenHeight;
	
	public Main main;//pour les jetons du joueur
	
	public TabScore Tb;
	
	public Modele modl;
	public Controleur ctrl;
	
	private ArrayList<cell> mainC; //copie jaune en cell du joueur actif
	
	
	public Interface(Modele m, Controleur c) {
		super();
		this.setPreferredSize(new Dimension(screenSize.width/3,screenSize.height));
		this.ctrl =c;
		this.modl =m;
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		this.main = new Main(m,c);
		this.Tb = new TabScore(m,c);
		
		this.main.setVisible(true);
		
		int sizebutonW =Interface.iWidth/5;
		int sizebutonH=Interface.iHeight/5;
		
		//partie boutons
	    JButton BEnd = new JButton("Valider");
	    JButton BNext = new JButton("Passer");
	    JButton BPioche = new JButton("Changer");
	    JButton Bsupp = new JButton("Annuler");
	    
	   
		BEnd.setBounds(0,Interface.iHeight/2 ,sizebutonW,sizebutonH);
		BEnd.setText("VALIDER MOT");
		BNext.setBounds(sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		BNext.setText("FIN DU TOUR");
		BPioche.setBounds(2*sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		BPioche.setText("CHANGER LETTRE.S");
		Bsupp.setBounds(3*sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		Bsupp.setText("ANNULER");
		
		this.add(BEnd);
		this.add(BNext);
		this.add(BPioche);
		this.add(Bsupp);
		
		this.add(main,BorderLayout.SOUTH);
		this.add(Tb,BorderLayout.NORTH);
		
		this.repaint();
	}
	
	public void paint(Graphics g) {	
		this.main.drawMain(g);//
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
			super();
			this.setVisible(true);
			this.setPreferredSize(new Dimension(Interface.iWidth,Interface.iHeight/3)); //pif
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
				
				g.fillRect(i*dw/7, 0, dh, dw/7);
				
				g.setColor(Color.BLACK);
				g.drawRect(i*dw/7, 0, dh, dw/7);
				
				int mid = dw/14;
				
				g.drawString(""+c, mid + i*dw/7, dh/7);
				g.drawString(Integer.toString(this.modl.partieEC.PtsLettre.get(c)), mid + i*dw/7, 20 + dh/7);
				i++;
			}
			
			
			
		}
		
	}
	
	
	
	
	
	

}
