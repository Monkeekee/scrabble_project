package scrabble_1;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;


public class Vue extends JFrame implements Observer{

	public Vue(Controleur c) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Integer etat = (Integer)arg;
	}

}
