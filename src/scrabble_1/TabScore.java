package scrabble_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TabScore extends JPanel{
	
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
		this.setVisible(true);
		this.setSize(300,300); //pif
		this.modl=m;
		this.ctrl=C;
		this.repaint();
		
		int sizebutonW =Interface.iWidth/4;
		int sizebutonH=Interface.iHeight/5;
		
		//partie boutons
	    JButton BEnd = new JButton("Valider");
	    JButton BNext = new JButton("Passer");
	    JButton BPioche = new JButton("Changer");
	    JButton Bsupp = new JButton("Annuler");
		
		BEnd.setBounds(0,Interface.iHeight/2 ,sizebutonW,sizebutonH);
		BEnd.setText("VALIDER MOT");
		BNext.setBounds(Interface.iWidth*1/4 +sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		BNext.setText("FIN DU TOUR");
		BPioche.setBounds(Interface.iWidth*2/4 + 2*sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		BPioche.setText("CHANGER LETTRE.S");
		Bsupp.setBounds(Interface.iWidth*3/4 + 3*sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		Bsupp.setText("ANNULER");
		
		this.add(BEnd,BorderLayout.SOUTH);
		this.add(BNext,BorderLayout.SOUTH);
		this.add(BPioche,BorderLayout.SOUTH);
		this.add(Bsupp,BorderLayout.SOUTH);
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
