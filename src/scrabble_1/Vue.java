package scrabble_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Vue extends JFrame implements Observer{
//completer avec GUI
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenWidth = screenSize.width-100;
	public static int screenHeight = screenSize.height-100;
	

	public Modele modl;
	
	public Controleur ctrl;
	
	//graphique
	public Board board;
	
	public Interface interf;
		
	
	public Vue(Controleur c, Modele m) {
		super("Scrabble");
		this.ctrl = c;
		this.modl = m;
		
		//fenetre
		this.setTitle("SCRABBLE");
		this.setMinimumSize(new Dimension(Vue.screenWidth, Vue.screenHeight));
		this.setPreferredSize(new Dimension(Vue.screenWidth, Vue.screenHeight));
		this.setVisible(true);
		this.setResizable(true);
		
		BorderLayout BL = new BorderLayout();
		this.setLayout(BL);

        
        //GridBagConstraints gbcG = new GridBagConstraints();
        //gbcG.weightx=3;
        //gbcG.weighty=3;
        //gbcG.gridx=0;
        //gbcG.gridy=0;
        //gbcG.anchor=GridBagConstraints.NORTHWEST;
        
        //GridBagConstraints gbcI = new GridBagConstraints();//pos dans la grille et place occupée
        //gbcI.weightx=1;
        //gbcI.weighty=3;
        //gbcI.gridx=1;
        //gbcI.gridy=0;
        //gbcI.anchor=GridBagConstraints.NORTHEAST;
        
        //GridBagLayout gridbag = new GridBagLayout();

        //this.setLayout(gridbag);


		this.board= new Board(m,c);
		this.interf= new Interface(m,c);
		
		this.add(board,BorderLayout.CENTER);
					
		this.add(interf,BorderLayout.WEST);
		
		this.repaint();

		
	}
	
	
	
	//public void paint(Graphics g) {
	//	this.board.repaint();
	//	this.interf.repaint();
	//}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

}
