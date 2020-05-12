package scrabble_1;

import java.io.Serializable;

public class cell implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public char letter;
	public int value;
	public int cellsize;  //doit dépendre seulement de la vue, a déplacer aillleurs
	public boolean selec;
	public boolean occupied;
	public boolean checked;




	public cell (int value) {
		this.letter=' ';
		this.value=value;
		this.selec=false;
		this.occupied=false;
		this.checked=false;
	}
	

	public String toString() {
		return Character.toString(this.letter);
	}
	

	
}







