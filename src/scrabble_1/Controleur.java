package scrabble_1;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;
import javax.swing.JButton;

import Vue.Board;


public class Controleur implements  ActionListener, MouseListener, KeyListener, WindowListener{ 

	private Modele modl;
	
	
	public Controleur(Modele modl) {
		this.modl = modl;
		
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int cs = Board.cellsize;
		if (e.getClickCount() == 1) {
			//this.keyTyped(null);
			int x = e.getX();
			int y = e.getY();
			this.modl.partieEC.selectionner(Math.floorDiv(x, cs),Math.floorDiv(y, cs));
			this.modl.changeEtat();
			//System.out.print(this.modl.partieEC.plateau.get(Math.floorDiv(x, cs)).get(Math.floorDiv(y, cs)).selec);
			//System.out.print(this.modl.partieEC.plateau.get(Math.floorDiv(x, cs)).get(Math.floorDiv(y, cs)).letter);
		}
		if (e.getClickCount() == 2) {
			this.modl.partieEC.deselec();
			this.modl.changeEtat();
			//System.out.print(this.modl.partieEC.plateau.get(Math.floorDiv(x, cs)).get(Math.floorDiv(y, cs)).selec);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton)e.getSource();
		System.out.print(btn.getName());
		if(btn.getName() == "Valider" ) {
			int x1 = this.modl.partieEC.CooMotJoue()[0];
			int y1 = this.modl.partieEC.CooMotJoue()[1];
			int x2 = this.modl.partieEC.CooMotJoue()[2];
			int y2 = this.modl.partieEC.CooMotJoue()[3];
			if (this.modl.confirmerMot(x1, y1, x2, y2)) {
				this.modl.partieEC.actuScore(x1, y1, x2, y2);
			}
			else {
				this.modl.partieEC.SupprimerMot();
			}
			this.modl.changeTour();
			this.modl.partieEC.deselec();
			System.out.print("Valider");
		}
		if(btn.getName()=="Passer") {
			this.modl.partieEC.deselec();
			this.modl.changeTour();
			//System.out.print("Passer");
		}
		if(btn.getName()=="Changer") {
			for (int i=0; i<=6;i++) {
				this.modl.partieEC.changerLettre(i);
				this.modl.partieEC.deselec();	
			//System.out.print("Changer");
			}
			this.modl.changeTour();
			
		}
		if(btn.getName()=="Annuler") {
			this.modl.partieEC.deselec();
			this.modl.SupprimerMot();
			//System.out.print("annuler");
		}
		
	}
	
	

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub

		

	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent evt) {
		// TODO Auto-generated method stub
		
		char Caract = evt.getKeyChar();
		int[] coor = this.modl.partieEC.TrouverCaseSelec();
		if (!coor.equals(null)) {
			this.modl.PlacerLettre(Caract,coor[0] ,coor[1] );
		}
		System.out.print(true);
	
	}



	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		this.modl.enregistrer();
		System.exit(0);
	}



	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
