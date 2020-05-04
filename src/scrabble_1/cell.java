package scrabble_1;
import java.awt.Color;
import java.awt.Graphics;

public class cell {
	
	public char letter;
	public int value;
	public Color color;
	public int x;
	public int y;
	public int cellsize;  //doit dépendre seulement de la vue, a déplacer aillleurs
	public boolean selec;
	public boolean occupied;
	public boolean checked;

	
	public cell (int ord,int abs, char letter, int value,Color color,int size) {
		this.letter=letter;
		this.value=value;
		this.color=color;
		this.x=ord;
		this.y=abs;
		this.cellsize=size;
		this.selec=false;

	}

	public cell (int value) {
		this.value=value;
		this.selec=false;
		this.occupied=false;
		this.checked=false;
	}
	

	public String toString() {
		return Character.toString(this.letter);
	}
	

	
	//les deux methodes du bas dans la vue uniquement aussi
	public void paintCell1(Graphics g) {
		g.setColor(this.color);
		g.draw3DRect(this.x, this.y, this.cellsize-2, this.cellsize-2, !(this.selec));
		g.fillRect(this.x, this.y,this.cellsize-2,  this.cellsize-2);

	}
	
	public void paintLetter(Graphics g,Color color) {
		g.setColor(color);
		g.drawString(toString(), this.x + (this.cellsize)/2, this.y+ ( this.cellsize)/2);
		g.drawString("2", this.x + ( this.cellsize)*3/4, this.y+ (this.cellsize)*1/4);
	}
	
}







