package Vue;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import scrabble_1.Controleur;
import scrabble_1.Modele;

public class RangeBtn extends JPanel implements Observer{
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
		BEnd.addActionListener(ctrl);
		BEnd.setName("Valider");
		//BNext.setBounds(sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		BNext.setText("FIN DU TOUR");
		BNext.addActionListener(ctrl);
		BNext.setName("Passer");
		//BPioche.setBounds(2*sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		BPioche.setText("CHANGER LETTRE.S");
		BPioche.addActionListener(ctrl);
		BPioche.setName("Changer");
		//Bsupp.setBounds(3*sizebutonW,Interface.iHeight/2,sizebutonW,sizebutonH);
		Bsupp.setText("ANNULER");
		Bsupp.addActionListener(ctrl);
		Bsupp.setName("Annuler");
		
		this.add(BEnd);
		this.add(BNext);
		this.add(BPioche);
		this.add(Bsupp);
	}



	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}