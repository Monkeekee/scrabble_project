package Vue;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import scrabble_1.Controleur;
import scrabble_1.Modele;

public class RangeBtn extends JPanel{
	//**
	private static final long serialVersionUID = 1L;
	public Modele modl;
	public Controleur ctrl;
	
	
	
	public RangeBtn(Modele m, Controleur C) {
		super();
		this.setVisible(true);
		this.setPreferredSize(new Dimension(Interface.iWidth,Interface.iHeight/3));
		this.modl=m;
		this.ctrl=C;
		
		this.setLayout(new FlowLayout());
		
		//int sizebutonW =Interface.iWidth/5;
		//int sizebutonH=Interface.iHeight/5;
		
		//partie boutons
	    JButton BEnd = new JButton("Valider");
	    JButton BNext = new JButton("Passer");
	    JButton BPioche = new JButton("Changer");
	    JButton Bsupp = new JButton("Annuler");
	    
	   
		//BEnd.setBounds(0,Interface.iHeight/2 ,sizebutonW,sizebutonH);
		BEnd.setText("VALIDER MOT");
		//BNext.setBounds(sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		BNext.setText("FIN DU TOUR");
		//BPioche.setBounds(2*sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		BPioche.setText("CHANGER LETTRE.S");
		//Bsupp.setBounds(3*sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		Bsupp.setText("ANNULER");
		
		this.add(BEnd);
		this.add(BNext);
		this.add(BPioche);
		this.add(Bsupp);
	}
}