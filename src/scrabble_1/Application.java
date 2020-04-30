package scrabble_1;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modele m = new Modele();
		
		Controleur c = new Controleur();
		
		Vue v = new Vue(c);  //vue
		m.addObserver(v);
		
		//System.out.println(m.dico); 
		//System.out.println(m.dico.existe("claqua")); //assez reactif
		
	}

}
