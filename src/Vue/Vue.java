package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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


import scrabble_1.Controleur;
import scrabble_1.Modele;




public class Vue extends JFrame implements Observer{
//completer avec GUI
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenWidth = screenSize.width-80;
	public static int screenHeight = screenSize.height-80;
	

	public Modele modl;
	
	public Controleur ctrl;
	
	//graphique
	public Board board;
	
	public Interface interf;
		
	
	public Vue(Controleur c, Modele m) {
		super("Scrabble");
		this.ctrl = c;
		this.modl = m;
		this.addKeyListener(ctrl);
		
		//fenetre
		this.setLocationRelativeTo(null);
		this.setTitle("SCRABBLE");
		this.setMinimumSize(new Dimension(Vue.screenWidth+30, Vue.screenHeight+30));
		this.setPreferredSize(new Dimension(Vue.screenWidth+30, Vue.screenHeight+30));
		this.setResizable(true);
		
		
		BorderLayout L = new BorderLayout();
		this.setLayout(L);

        
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

		//Main mn = new Main(m,c);
		//TabScore Tb = new TabScore(m,c);
		//RangeBtn Rb = new RangeBtn(m,c);
		
		
		
		//this.add(Rb,BorderLayout.EAST);
		//this.add(mn,BorderLayout.SOUTH);
		//this.add(Tb,BorderLayout.CENTER);
		this.board= new Board(m,c);
		this.interf= new Interface(m,c);
		
		this.add(board,BorderLayout.WEST);
		
		this.add(interf,BorderLayout.EAST);
		
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
