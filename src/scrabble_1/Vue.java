package scrabble_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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




public class Vue extends JFrame implements Observer{//completer avec GUI
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenWidth = (screenSize.width)-30;
	public static int screenHeight = (screenSize.height)-30;
	

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
		this.setPreferredSize(new Dimension(Vue.screenWidth, Vue.screenHeight));
		this.setVisible(true);
		this.setResizable(true);
		
		this.setLayout(new BorderLayout());

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
