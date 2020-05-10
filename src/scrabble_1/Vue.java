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

import scrabble_1.GUI.Board;
import scrabble_1.GUI.Click;
import scrabble_1.GUI.Move;


public class Vue extends JFrame implements Observer{//completer avec GUI
	
	private Dimension d;

	public Modele modl;
		
	
	public Vue(Controleur c, Modele m) {
		super();
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.modl = m;
		
		//insertion de GUI ici
		//
		//
		
		this.setTitle("SCRABLE");
		this.setSize(screenSize.width, screenSize.height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		this.setLocationRelativeTo(null);
		

		Board board= new Board();
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
    
   

	

class Board extends JPanel{
	
	int frameWidth=screenSize.width;
	int frameHeight=screenSize.height;
	

	public cell temp1,temp2 ;
	public ArrayList<cell> mainC = new ArrayList<cell>();
	public ArrayList<ArrayList<cell>> grid1;

	int width=frameWidth -(15*cellsize);

	
	public Board() {

		ArrayList<ArrayList<cell>> grid1 = new ArrayList<ArrayList<cell>>();
		this.grid1=grid1;
		
		for (int i=0;i<15;i++) {
			ArrayList<cell> line = new ArrayList<cell>();
			for (int j=0 ;j<15;j++) {
				line.add(new cell(spacing + i*cellsize,spacing + j*cellsize,' ',grid[i][j],colors[grid[i][j]],cellsize));
				}
			this.grid1.add(line);
		
			
		}
		System.out.println("CONSTRU matrice:"  + this.grid1);
		this.repaint();
	}
	public void paintComponent(Graphics g) {		
		this.pPart(g);
		this.pBoard(g);
		this.drawMain(g);	


		}
	
	
	public void pPart(Graphics g) {

		g.setColor(Color.cyan);
		g.fillRect(cellsize*15, 0, width, (frameHeight)/3);//partie score
		g.setColor(Color.gray);
		g.fillRect(cellsize*15, frameHeight/3, width, (frameHeight)/3);//partie button
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(cellsize*15, (2*frameHeight)/3, width, (frameHeight)/3); //partie lettre

	}
	
	public void pBoard(Graphics g){
		for (int i = 0; i < this.grid1.size(); i++)
		{
		    for (int j = 0; j < this.grid1.get(i).size(); j++)
		    {
		    	cell cellule=this.grid1.get(i).get(j);
		    	cellule.paintCell1(g );
		    } 
		}
	}
	
	public void createCellMain(){
		int size=width/7;
		int i=0;
		int x=cellsize*15;
		int y=(2 *(frameHeight)/3);
		for (char c : main1) {
			mainC.add(new cell(x+i*size,(frameHeight/12) +y,c,2,Color.YELLOW,size));
			i=i+1;
		}
	
		
	}
	public void drawMain(Graphics g) {
		this.createCellMain();
		for(cell cellule: mainC) {
			cellule.paintCell1(g );
			cellule.paintLetter(g, CouleurJoeur);
		}
	}




	
}
	


	//
	
	
	
	
	
	
	
	public void paint(Graphics g) {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

}
