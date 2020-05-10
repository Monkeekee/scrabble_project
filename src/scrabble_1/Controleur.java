package scrabble_1;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Controleur implements  ActionListener, MouseListener, KeyListener{ 

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
			modl.partieEC.plateau.get(x).get(y).selec = true;
		}
		if (e.getClickCount() == 2) {
			int x = e.getX();
			int y = e.getY();
			modl.partieEC.plateau.get(x).get(y).selec = false;
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
		Button btn = (Button)e.getSource();
		if(btn.getName()=="VALIDER MOT") {
			
			modl.changeTour();
		}
		if(btn.getName()=="FIN DU TOUR") {
			modl.changeTour();
		}
		if(btn.getName()=="PIOCHE") {
			modl.partieEC.mainRdm();
			
		}
		if(btn.getName()=="SUPPRIMER") {
			modl.partieEC.SupprimerMot();
		}
	}
	
	

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		char Caract = evt.getKeyChar();
		modl.PlacerLettre(Caract, this.modl.partieEC.CaseSelec()[0],this.modl.partieEC.CaseSelec()[1] );

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
