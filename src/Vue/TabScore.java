package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import scrabble_1.Controleur;
import scrabble_1.Modele;

public class TabScore extends JPanel implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Modele modl;
	private Controleur ctrl;
	
	public void paint(Graphics g) {
		drawTabScore(g);
	}
	
	public TabScore(Modele m , Controleur C) {
		super();
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		//this.setVisible(true);
		//this.setSize(Interface.iWidth,Interface.iHeight*2/3);
		this.setPreferredSize(new Dimension(Interface.iWidth,Interface.iHeight/3));
		//this.setBackground(Color.ORANGE);
		this.modl=m;
		this.ctrl=C;
		
		

	}
	
	public void drawTabScore(Graphics g) {
		
		int dw = Interface.iWidth;
		int dh = Interface.iHeight;
		int n = this.modl.partieEC.NbrJoueur;
		
		for (int i = 0 ; i<this.modl.NbJ ; i++ ) {
			 Font font = new Font("Verdana", Font.BOLD, 30); 
			 g.setFont(font);
			 g.setColor(Interface.CouleurJoueur[i]);
			 g.fillRect(i*dw/n, 0, dw/n, dh/5);
			 g.setColor(Color.BLACK);
			 g.drawRect(i*dw/n, 0, dw/n, dh/5);
			 g.drawString(Integer.toString(this.modl.partieEC.Jrs[i].score), i*dw/n+dw/(2*n), dh/10);
			 
			 
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

}
