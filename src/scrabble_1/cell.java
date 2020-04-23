import java.awt.Color;
import java.awt.Graphics;

public class cell {

	char letter;
	int value;
	Color color ;

	
	public cell ( char letter, int value,Color color) {
		this.letter=letter;
		this.value=value;
		this.color=color;
	}
	

	public char getLetter() {
		return this.letter;
	}
	public int getValue() {
		return this.value;
	}
	public String toString() {
		return Character.toString(this.letter);
	}
	
	public void paint(Graphics g,int abs,int ord,int size, cell c) {
		g.setColor(c.color);
		g.drawString(c.toString(), (abs + size)/2, (ord+ size)/2);
	}
	
}







