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

import javax.swing.JButton;


public class Controleur implements  ActionListener, MouseListener, KeyListener, WindowListener{ 

	private Modele modl;
	
	
	public Controleur(Modele modl) {
		this.modl = modl;
		
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 1) {
			int x = e.getX();
			int y = e.getY();
			this.modl.partieEC.plateau.get(Math.floorDiv(x, 45)).get(Math.floorDiv(y, 45)).selec = true;
			//System.out.print(this.modl.partieEC.plateau.get(Math.floorDiv(x, 45)).get(Math.floorDiv(y, 45)).selec);
		}
		if (e.getClickCount() == 2) {
			int x = e.getX();
			int y = e.getY();
			this.modl.partieEC.plateau.get(Math.floorDiv(x, 45)).get(Math.floorDiv(y, 45)).selec = false;
			//System.out.print(this.modl.partieEC.plateau.get(Math.floorDiv(x, 45)).get(Math.floorDiv(y, 45)).selec);
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
			System.out.print("Valider");
		}
		if(btn.getName()=="Passer") {
			this.modl.changeTour();
			//System.out.print("Passer");
		}
		if(btn.getName()=="Changer") {
			for (int i=0; i<=6;i++) {
				this.modl.partieEC.changerLettre(i);
			}
			//System.out.print("Changer");
			
		}
		if(btn.getName()=="Annuler") {
			this.modl.partieEC.SupprimerMot();
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
		int x = this.modl.partieEC.TrouverCaseSelec()[0];
		int y = this.modl.partieEC.TrouverCaseSelec()[1];
		this.modl.PlacerLettre(Caract,x ,y );
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
