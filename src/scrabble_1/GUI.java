package scrabble_1;
import javax.swing.*;

import java.awt.Color;
import java.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;

public class GUI extends JFrame  {

	int spacing=1;
	int cellsize=60;
		
	int mcx=-1;
	int mcy=-1;
	
	char tmp = ' ';
	
	Color CouleurJoeur = Color.MAGENTA;
	
	char[] main1 = {'l' , 'a' , 'b' , 'c' , 'd' , 'e','g','j'};
	
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

    
    JButton BEnd = new JButton();
    JButton BNext = new JButton();
    JButton BPioche = new JButton();
    JButton Bsupp = new JButton();
    
    
	public GUI() {
		
		
		this.setTitle("SCRABLE");
		this.setSize(1500,930);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		

		Board board= new Board();
		this.setContentPane(board);
		
		Move move= new Move();
		this.addMouseMotionListener(move);
		
		Click click =new Click();
		this.addMouseListener(click);
		
		this.setLayout(null);
		
		BEnd.setBounds(915,400,125,75);
		BEnd.setText("FIN DU TOUR");
		BNext.setBounds(1060,400,125,75);
		BNext.setText("FIN DU TOUR");
		BPioche.setBounds(1205,400,125,75);
		BPioche.setText("PIOCHE");
		Bsupp.setBounds(1350,400,125,75);
		Bsupp.setText("SUPP");
		
		board.add(BEnd);
		board.add(BNext);
		board.add(BPioche);
		board.add(Bsupp);
		
	}

	

class Board extends JPanel{

	public cell temp1,temp2 ;
	public ArrayList<cell> mainC = new ArrayList<cell>();
	public ArrayList<ArrayList<cell>> grid1;


	
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

	}
	public void paintComponent(Graphics g) {		
		this.pPart(g);
		this.pBoard(g);
		this.drawMain(g);	

		}
	
	
	public void pPart(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(899, 600, 1500-899, 930-600); //partie lettre
		g.setColor(Color.gray);
		g.fillRect(899, 300, 1500-899, 600-300);//partie button
		g.setColor(Color.cyan);
		g.fillRect(899, 0, 1500-899, 300);//partie score
		g.setColor(Color.red);
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
		int size=75;
		int i=0;
		int x=900;
		int y=700;
		for (char c : main1) {
			mainC.add(new cell(x+i*size,y,c,2,Color.YELLOW,size));
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
	public void drawClick(int i,int j) {
		temp1=this.grid1.get(i).get(j);
		//temp1.selec=!(temp1.selec);
		temp1.color=Color.BLACK;
		this.grid1.get(i).set(j,temp1);
	}


	
}
	
public class Move implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub


	}
	
	}
public class Click implements MouseListener{

	
		@Override
	public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		Board plato=new Board();
		cell selec;
		int cx = e.getX();
		int cy = e.getY();
		int mcx=cx/60;
		int mcy=(cy-25)/60;
		if (0<=cx && cx<=900 && 0<=cy && cy<=925) {
			System.out.println("matrice:"  +mcx + ","+ mcy);
			plato.drawClick(mcx, mcy);
			
			


				
				
				
			}

		}

	@Override
	public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
	}
	
}
public class Keyboard implements KeyListener {

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		char Caract = evt.getKeyChar();
		System.out.println(Caract);
		
		if (Arrays.asList(main1).contains(Caract)) {
		    System.out.println("it's in boss");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

}

