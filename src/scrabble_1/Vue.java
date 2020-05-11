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
	
	private Dimension d;

	public Modele modl;
	
	public Controleur ctrl;
		
	
	public Vue(Controleur c, Modele m) {
		super("Scrabble");
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.ctrl = c;
		this.modl = m;
		
		//insertion de GUI ici
		//
		//
		
		this.setTitle("SCRABBLE");
		this.setSize(screenSize.width, screenSize.height);
		
		this.setVisible(true);
		this.setResizable(false);

		this.setLayout(new BorderLayout());

		Board board= new Board(m,c);
		this.add(board,BorderLayout.EAST);
		this.add(new Interface(m,c),BorderLayout.WEST);

		this.repaint();

		
	}
	
	
	//
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	int screenWidth = (screenSize.width);
	int screenHeight = (screenSize.height);
	
	int spacing=1;
	int cellsize=(screenHeight)/16;
	
	int mcx=-1;
	int mcy=-1;
	
	char tmp = ' ';
	
	Color CouleurJoeur = Color.MAGENTA;
	
	char[] main1 = {'l' , 'a' , 'b' , 'c' , 'd' , 'e','g'};
	
	Color[] colors = {Color.BLACK,Color.GREEN,Color.LIGHT_GRAY,Color.RED,Color.CYAN,Color.BLUE,Color.ORANGE};	
	
	
	
	
	public void paint(Graphics g) {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

}
