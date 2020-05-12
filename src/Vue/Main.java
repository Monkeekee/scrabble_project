package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import scrabble_1.Controleur;
import scrabble_1.Modele;

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