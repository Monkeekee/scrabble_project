package scrabble_1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;


public class Vue extends JFrame implements Observer{//completer avec GUI

	private Dimension d;

	public Modele modl;
		
	
	public Vue(Controleur c, Modele m) {
		super();
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.modl = m;
	}
	
	public void paint(Graphics g) {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

}
