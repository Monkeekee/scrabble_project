package scrabble_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TabScore extends JPanel{
	
	private Modele modl;
	private Controleur ctrl;
	
	public void paint(Graphics g) {
		drawTabScore(g);
	}
	
	public TabScore(Modele m , Controleur C) {
		super();
		this.setVisible(true);
		this.setSize(300,300); //pif
		this.modl=m;
		this.ctrl=C;
		this.repaint();
	}
	
	public void drawTabScore(Graphics g) {
		Dimension d = this.getSize();
		int dw = d.width;
		int dh = d.height;
		
		
		for (int i = 0 ; i<this.modl.NbJ ; i++ ) {
			 g.setColor(Interface.CouleurJoueur[i]);
			 g.drawRect(i*dw/4, 0, dh, dw/4);
			 g.drawString(Integer.toString(this.modl.partieEC.Jrs[i].score), i*dw/4, dh*2/3);
			 
			 
		}
	}

}