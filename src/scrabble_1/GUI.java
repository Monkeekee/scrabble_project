import javax.swing.*;
import java.awt.Color;
import java.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GUI extends JFrame  {

	int spacing=1;
	int cellsize=60;
	
	public int mx=-100;
	public int my=-100;
	
	public int cx=-100;
	public int cy=-100;
	
	int mcx=-1;
	int mcy=-1;
	
	char tmp = ' ';
	
	Color CouleurJoeur = Color.MAGENTA;
	
	char[] main1 = {'l' , 'a' , 'b' , 'c' , 'd' , 'e','g','j','t'};
	
	Color[] colors = {Color.GREEN,Color.LIGHT_GRAY,Color.RED,Color.CYAN,Color.BLUE,Color.ORANGE};

    int[][] grid= {
		{2,0,0,4,0,0,0,2,0,0,0,4,0,0,2},
		{0,1,0,0,0,3,0,0,0,3,0,0,0,1,0},
		{0,0,1,0,0,0,4,0,4,0,0,0,1,0,0},
		{0,0,0,1,0,0,0,4,0,0,0,1,0,0,0},
		{4,0,0,0,1,0,0,0,0,0,1,0,0,0,4},
		{0,3,0,0,0,3,0,0,0,3,0,0,3,0,0},
		{0,0,4,0,0,0,4,0,4,0,0,4,0,0,0},
		{2,0,0,4,0,0,0,1,0,0,4,0,0,0,2},
		{0,0,4,0,0,0,4,0,4,0,0,4,0,0,0},
		{0,3,0,0,0,3,0,0,0,3,0,0,3,0,0},
		{0,0,0,0,1,0,0,0,0,0,1,0,0,0,0},
		{4,0,0,1,0,0,0,4,0,0,0,1,0,0,4},
		{0,0,1,0,0,0,4,0,4,0,0,0,1,0,0},
		{0,1,0,0,0,3,0,0,0,3,0,0,0,1,0},
		{2,0,0,4,0,0,0,2,0,0,0,4,0,0,2}
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
	


public class Board extends JPanel{
	

	public void paintComponent(Graphics g ) {
			
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(899, 600, 1500-899, 930-600); //partie lettre
			g.setColor(Color.gray);
			g.fillRect(899, 300, 1500-899, 600-300);//partie button
			g.setColor(Color.cyan);
			g.fillRect(899, 0, 1500-899, 300);//partie score
			g.setColor(Color.red);
			for (int i=0;i<15;i++) {
				for (int j=0 ;j<15;j++) {
					g.setColor(colors[(grid[i][j])]);
					g.fillRect(spacing + i*cellsize, spacing + j*cellsize,cellsize-2*spacing,  cellsize-2*spacing);
			
			int cpt=0;
			int x=900;
			int y=700;
			int cont=0;

			while (cpt != main1.length)
				{
					if (x+cont*85 > 1450){
						x=900;
						y=800;
						cont=0;
					}
					
					
					g.setColor(Color.YELLOW);
					g.fillRect(x+cont*85, y, 75,75);
					g.setFont(new Font("TimesRoman", Font.PLAIN,25)); 
					g.setColor(CouleurJoeur);
					g.drawString(Character.toString(main1[cpt]), (x+cont*85 +37), (y+75 -37));
					//System.out.println("X: " + 915 + 10*cpt + ", CPT=" + cpt);
					cpt=cpt+1;
					cont=cont+1;
					

				}

				
				}
	
			}
		}
			
		
	public void paintleter(Graphics g,int ord , int abs, char let , Color color) {

		g.setColor(color);
		g.drawString(Character.toString(let), (abs+10)/2, (ord+10)/2);
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

		mx = e.getX();
		my = e.getY();
		//System.out.println("X: " + mx + ", Y:" + my);
	}
	
	}
public class Click implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			cx = e.getX();
			cy = e.getY();
			int mcx=cx/60;
			int mcy=(cy-25)/60;
			if (0<=cx && cx<=900 && 0<=cy && cy<=925) {
				
				grid[mcx][mcy]=5;

				System.out.println("matrice:"  +cx/60 + ","+ (cy-25)/60);
				
				
				
			}
			System.out.println("mouse clicked:" + cx +","+ cy);
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

