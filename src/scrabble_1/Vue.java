package scrabble_1;

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
		super();
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.ctrl = c;
		this.modl = m;
		
		//insertion de GUI ici
		//
		//
		
		this.setTitle("SCRABBLE");
		this.setSize(screenSize.width, screenSize.height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		this.setLocationRelativeTo(null);
		

		Board board= new Board(m,c);
		this.setContentPane(board);
		
		
		
		this.setLayout(null);
		
		BEnd.setBounds(cellsize*15,screenHeight/2 ,sizebutonW,sizebutonH);
		BEnd.setText("FIN DU TOUR");
		BNext.setBounds(cellsize*15 +sizebutonW,screenHeight/3,sizebutonW,sizebutonH);
		BNext.setText("FIN DU TOUR");
		BPioche.setBounds(cellsize*15 + 2*sizebutonW,screenHeight/2,sizebutonW,sizebutonH);
		BPioche.setText("PIOCHE");
		Bsupp.setBounds(cellsize*15 + 3*sizebutonW,screenHeight/3,sizebutonW,sizebutonH);
		Bsupp.setText("SUPP");
		
		board.add(BEnd);
		board.add(BNext);
		board.add(BPioche);
		board.add(Bsupp);
		
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

    int[][] grid= {
		{3,1,1,5,1,1,1,3,1,1,1,5,1,1,3},
		{1,2,1,1,1,4,1,1,1,4,1,1,1,2,1},
		{1,1,2,1,1,1,5,1,5,1,1,1,2,1,1},
		{1,1,1,2,1,1,1,5,1,1,1,2,1,1,1},
		{5,1,1,1,2,1,1,1,1,1,2,1,1,1,5},
		{1,4,1,1,1,4,1,1,1,4,1,1,4,1,1},
		{1,1,5,1,1,1,5,1,5,1,1,5,1,1,1},
		{3,1,1,5,1,1,1,2,1,1,5,1,1,1,3},
		{1,1,5,1,1,1,5,1,5,1,1,5,1,1,1},
		{1,4,1,1,1,4,1,1,1,4,1,1,4,1,1},
		{1,1,1,1,2,1,1,1,1,1,2,1,1,1,1},
		{5,1,1,2,1,1,1,5,1,1,1,2,1,1,5},
		{1,1,2,1,1,1,5,1,5,1,1,1,2,1,1},
		{1,2,1,1,1,4,1,1,1,4,1,1,1,2,1},
		{3,1,1,5,1,1,1,3,1,1,1,5,1,1,3}
		};

 
	int sizebutonW =(screenWidth - cellsize*15)/4;
	int sizebutonH=screenHeight/6;
    JButton BEnd = new JButton();
    JButton BNext = new JButton();
    JButton BPioche = new JButton();
    JButton Bsupp = new JButton();
    
   


	
	
	
	
	
	
	public void paint(Graphics g) {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

}
