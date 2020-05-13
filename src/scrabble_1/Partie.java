package scrabble_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Partie implements Serializable {
	
	private static final long serialVersionUID = 123L;
	
	
	
	public int NbrJoueur;
	public int[] TableauScore;
	public Player J_actif;
	public Player[] Jrs; //liste de joueurs
	
	static char[] lettres = {'a','b','c','d','e','f','g','h','i','j','k','l','m'
			,'n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
	
	static int[] quantite = {9,2,2,3,15,2,2,2,8,1,1,5,3
			,6,6,2,1,6,6,6,6,2,1,1,1,1,2};
	
	static int[] points = {1,3,3,2,1,4,2,4,1,8,10,1,2
			,1,1,3,8,1,1,1,1,4,10,10,10,10,0};
	
	public Map<Character,Integer> Sac; //useless pour le moment, affichage des regles plus tard ?
	public Map<Character,Integer> PtsLettre;
	
	
	public ArrayList<ArrayList<cell>> plateau = new ArrayList<>();
	public ArrayList<Character> sacDePioche; //necessaire pour avoir une pioche vraiment aleatoire

	
	
	public ArrayList<String> MotJoues = new ArrayList<String>();
	
	
	
	public Partie() {
		this.NbrJoueur = 0;
	}
	
	
	public Partie(int NbrJ) {
		this.NbrJoueur = NbrJ;
		this.Jrs = new Player[NbrJ];
		this.Sac = new HashMap<Character,Integer>();
		this.PtsLettre = new HashMap<Character,Integer>();
		this.sacDePioche = new ArrayList<Character>();
		
		
		for (int i=0; i<= 26; i++) {
			this.Sac.put(lettres[i], quantite[i]);
			this.PtsLettre.put(lettres[i], points[i]);
			for (int x = 0; x < quantite[i]; x++) { //le sac de pioche doit rester uniforme en quantité
				this.sacDePioche.add(lettres[i]);
				
			}
		}
		
		for (int i=0 ; i < NbrJ ; i++) {//pour chaque joueur remplir d'une main random au debut
			this.J_actif = new Player(i);
			this.mainRdm();
			this.nextPlayer();
		}
		
		for (int i = 0; i <15 ; i++) { //initialisation des cases du plateau
			ArrayList<cell> e = new ArrayList<>();
			this.plateau.add(e);
			//System.out.println(i);
			
			
			for (int j = 0 ; j<15 ; j++) {
				//System.out.println(j);
				e.add(new cell(Modele.Plateau[i][j])); //la value est déterminee par le Plateau de Modèle
			}
			
		}
		
		//System.out.println(this);
	}
	
	public String toString() {
		String res = Integer.toString(this.NbrJoueur) + " joueurs, ";
		if (!this.MotJoues.isEmpty()) {
			res = res + this.MotJoues.get(0);
		}else {
			res = res + "aucun mot";
		}
		
		return res;
	}

	public void mainRdm() {
		// donne une nouvelle main a un joueur qui n'en a pas
		if (this.J_actif.main.size() < 7) {
			
			Random r = new Random();
			
			for (int i = this.J_actif.main.size(); i< 7; i++) {
				if (!this.sacDePioche.isEmpty()) {
					int num_L = r.nextInt(this.sacDePioche.size());
					this.J_actif.main.add(this.sacDePioche.get(num_L));
					this.sacDePioche.remove(num_L);
				}
			}
		}
	}
	
	public void changerLettre(int pos_l) {//prend en parametre la lettre numéro pos_l dans la main du joueur, 
													//l'enlève, la remet dans le sac et en pioche une autre
		char x = this.J_actif.main.get(pos_l);
		this.J_actif.main.remove(pos_l);
		this.sacDePioche.add(x);
		
		Random r = new Random();
		int num_L = r.nextInt(this.sacDePioche.size());
		this.J_actif.main.add(this.sacDePioche.get(num_L));
		
		
	}
	
	public void nextPlayer() {
		
		int ja_num = this.J_actif.num_j;
		this.Jrs[ja_num]=this.J_actif;
		this.J_actif = this.Jrs[(ja_num+1)%this.NbrJoueur];
		
	}
	
	public void PlacerLettre(char lettre,int x, int y) {
		if (this.J_actif.main.contains((lettre))){
			cell cl = this.plateau.get(x).get(y);
			if (!cl.checked) {
				if (cl.occupied) {
					this.J_actif.main.add(cl.letter);
				}
				
				this.plateau.get(x).get(y).letter=lettre;
				this.plateau.get(x).get(y).occupied=true;
				this.J_actif.main.remove(this.J_actif.indiceLettre(lettre));
			}
			
			
			
		}
	}
	
	public String motEntre(int x1, int y1, int x2, int y2) {
		String mot = "";
		
		if (x1 == x2) { //sur la meme ligne
			//System.out.println("ligne");
			for (int j=0; j<=y2 - y1; j++) {
				mot = mot + this.plateau.get(x1).get(y1+j);
				System.out.println(this.plateau.get(x1).get(y1+j));
				
				
				
			}
		}
		if (y1 == y2) { // sur la meme colone
			//System.out.println("colonne");
			for (int i=0; i<=x2 - x1; i++) {
				mot = mot + this.plateau.get(x1+i).get(y1);
				System.out.println(this.plateau.get(x1+i).get(y1));
			}
		}
	
		
		//if (x1 == x2) {
		//	for (int i = y1 ; y1 <= y2 ; i++ ) {
		//		mot = mot + this.plateau.get(x1).get(i).letter;
		//	}
		//}
		//if (y2 == y1) {
		//	for (int i = x1 ; x1 <= x2 ; i++ ) {
		//		mot = mot + this.plateau.get(i).get(y1).letter;
		//	}
		//}
		return mot;
		
	}
	
	public boolean confirmerMot(int x1, int y1, int x2, int y2, Dictionnaire d) {
		boolean res = false;
		String mot = this.motEntre(x1, y1, x2, y2);
		if (d.existe(mot)) {
				res=true;
			}
		return res;
	}
	
	public void checkmot(int x1,int y1,int x2,int y2) {
		if (x1 == x2) {
			for (int j=0; j<=y2 - y1; j++) {
				this.plateau.get(x1).get(j+y1).checked=true;
			}
		}
		if (y2 == y1) {
			for (int i = 0 ; i <=x2 - x1 ; i++ ) {
				this.plateau.get(i+x1).get(y1).checked=true;
			}
		}
	}
	
	public void actuScore(int x1, int y1, int x2, int y2) {
		this.J_actif.score+=this.ptsMot(x1, y1, x2, y2);
		char dir;
		if (x1==x2) {
			dir='V';
			if(y2-y1==7) {
				this.J_actif.score += 50;
			}
			for (int j=0; j<=y2 - y1; j++) {
				this.J_actif.score += this.ptsMot(this.Touchemot(x1, j+y1, dir)[0], this.Touchemot(x1, j+y1, dir)[2], this.Touchemot(x1, j+y1, dir)[1], this.Touchemot(x1, j+y1, dir)[3]);
			}
		}
		if (y1==y2) {
			dir='H';
			if(x2-x1==7) {
				this.J_actif.score += 50;
			}
			for (int i = 0 ; i <= x2-x1 ; i++ ) {
				this.J_actif.score += this.ptsMot(this.Touchemot(i+x1, y1, dir)[0], this.Touchemot(i+x1, y1, dir)[2], this.Touchemot(i+x1, y1, dir)[1], this.Touchemot(i+x1, y1, dir)[3]);
			}
		}

	}
	
	public int ptsMot(int x1,int y1, int x2,int y2) {
		if(x1==-1) {
			return 0;
		}
		int points = 0;
		int multiplicateur = 1;
		if (x1 == x2) {
			for (int j=0; j<=y2 - y1; j++) {
				if(this.plateau.get(x1).get(j+y1).checked==false) {
					if(Modele.Plateau[x1][j+y1]==1) {
						points += this.PtsLettre.get(this.plateau.get(x1).get(j+y1).letter)*2;
					}
					if(Modele.Plateau[x1][j+y1]==3) {
						points += this.PtsLettre.get(this.plateau.get(x1).get(j+y1).letter)*3;
					}
					if(Modele.Plateau[x1][j+y1]==2) {
						multiplicateur = 2;
					}
					if(Modele.Plateau[x1][j+y1]==4) {
						multiplicateur = 3;
					}
				}else {
					if(Modele.Plateau[x1][j+y1]==0) {
						points += this.PtsLettre.get(this.plateau.get(x1).get(j+y1).letter);
					}
					
				}
			
			}
		}
		if (y1 == y2) {
			for (int i=0; i<=x2 - x1; i++) {
				if(this.plateau.get(i+x1).get(y1).checked==false) {
					if(Modele.Plateau[i+x1][y1]==1) {
						points += this.PtsLettre.get(this.plateau.get(i).get(y1).letter)*2;
					}
					if(Modele.Plateau[i+x1][y1]==3) {
						points += this.PtsLettre.get(this.plateau.get(i).get(y1).letter)*3;
					}
					if(Modele.Plateau[i+x1][y1]==2) {
						multiplicateur = 2;
					}
					if(Modele.Plateau[i+x1][y1]==4) {
						multiplicateur = 3;
					}
				}else {
					if(Modele.Plateau[i+x1][y1]==0) {
						points += this.PtsLettre.get(this.plateau.get(i).get(y1).letter);
					}
					
				}
			
			}
		}
		points = points*multiplicateur;
		return points;
	}
	
	public void Listemotjoue(String mot){
		this.MotJoues.add(mot);
	}
	
	public int[] Touchemot(int x,int y,char direction) {
		int x1=x;
		int x2=x;
		int y1=y;
		int y2=y;
		if (direction == 'H') {
			if (this.plateau.get(x).get(y+1).occupied) {
				y2+=1;
				return this.Touchemot(x, y2, 'H');
			}
			if(this.plateau.get(x).get(y-1).occupied) {
				y1+=-1;
				return this.Touchemot(x, y1, 'H');
			}
		}
		if (direction == 'V') {
			if (this.plateau.get(x+1).get(y).occupied) {
				x2+=1;
				return this.Touchemot(x2, y, 'V');
			}
			if(this.plateau.get(x-1).get(y).occupied) {
				x1+=-1;
				return this.Touchemot(x1, y, 'V');
			}
		}
		if ( x1==x2 && y1==y2) {
			int[] coo = {-1,-1,-1,-1};
			return coo;
		}
		int [] coo= {x1,x2,y1,y2};
		return coo;
	}
	
	public void SupprimerMot() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0;j < 15; j++) {
				if (this.plateau.get(i).get(j).occupied==true && this.plateau.get(i).get(j).checked==false) {
					this.plateau.get(i).get(j).occupied = false;
					this.J_actif.main.add(this.plateau.get(i).get(j).letter);
					this.plateau.get(i).get(j).letter = ' ';
					}
			}
		}
		this.deselec();
	}
	
	public int[] TrouverCaseSelec() {
		int x=-1;
		int y=-1;
		for (int i = 0; i < 15; i++) {
			
			for (int j = 0;j < 15; j++) {
				if (this.plateau.get(i).get(j).selec) {
					x=i;
					y=j;
				}
			}
		}
		int [] coo = {x,y};
		if(x==-1 && y==-1) {
			return null;
		}
		return coo;
	}
	
	public void deselec() {
		for (int i = 0; i < 15; i++) {
			
			for (int j = 0;j < 15; j++) {
				this.plateau.get(i).get(j).selec=false;
			}
		}
	}
	
	
	public void selectionner(int x, int y) {
		this.deselec();
		this.plateau.get(x).get(y).selec=true;
		
	}
	
	
	public int[] CooMotJoue() {
		int x1 = 14;
		int y1 = 14;
		int x2 = 0;
		int y2 = 0;
		for (int i = 0; i < 15; i++) {
			
			for (int j = 0;j < 15; j++) {
				if (this.plateau.get(i).get(j).occupied && this.plateau.get(i).get(j).checked==false) {
					if (i<=x1) {
						x1=i;
					}
					if (i>=x2) {
						x2=i;
					}
					if(j<=y1) {
						y1=j;
					}
					if(j>=j) {
						y2=j;
					}
				}
			}
		}
		int[] coo = {x1,y1,x2,y2};
		return coo;
	}
	
	public int[] detectionMot() {
		int x1 = this.CooMotJoue()[0];
		int y1 = this.CooMotJoue()[1];
		int x2 = this.CooMotJoue()[2];
		int y2 = this.CooMotJoue()[3];
		if(x1==x2) {
			while (this.plateau.get(x1).get(y1-1).occupied && y1 >= 0) {
				y1 = y1 - 1;
			}
			while (this.plateau.get(x1).get(y2+1).occupied && y2 <= 14) {
				y2 = y2 + 1;
			}
		}
		if(y1==y2) {
			while (this.plateau.get(x1-1).get(y1).occupied && x1 >= 0) {
				x1 = x1 - 1;
			}
			while(this.plateau.get(x2+1).get(y1).occupied && x2 <= 14) {
				x2 = x2 + 1;
			}
		}
		int [] coo = {x1,y1,x2,y2};
		return coo;
	}
	
	public int[] MotToucherV(int x,int y) {
		int y1=y;
		int y2=y;
		while (this.plateau.get(x).get(y1-1).occupied && y1 >= 0) {
			y1 = y1 - 1;
		}
		while (this.plateau.get(x).get(y2+1).occupied && y2 <= 14) {
			y2 = y2 + 1;
		}
		int [] coo = {x,y1,x,y2};
		return coo;
	}
	
	public int[] MotToucherH(int x,int y) {
		int x1=x;
		int x2=x;
		while (this.plateau.get(x1-1).get(y).occupied && x1 >= 0) {
			x1 = x1 - 1;
		}
		while (this.plateau.get(x2+1).get(y).occupied && x2 <= 14) {
			x2 = x2 + 1;
		}
		int [] coo = {x1,y,x2,y};
		return coo;
	}
	
	public  boolean isMotToucherV(int x,int y) {
		int y1=y;
		int y2=y;
		while (this.plateau.get(x).get(y1-1).occupied && y1 >= 0) {
			y1 = y1 - 1;
		}
		while (this.plateau.get(x).get(y2+1).occupied && y2 <= 14) {
			y2 = y2 + 1;
		}
		if (y1==y2) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isMotToucherH(int x,int y) {
		int x1=x;
		int x2=x;
		while (this.plateau.get(x1-1).get(y).occupied && x1 >= 0) {
			x1 = x1 - 1;
		}
		while (this.plateau.get(x2+1).get(y).occupied && x2 <= 14) {
			x2 = x2 + 1;
		}
		if (x1==x2) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean Confirmation(Dictionnaire d) {
		int[] coo = this.detectionMot();
		int x1 = coo[0];
		int y1 = coo[1];
		int x2 = coo[2];
		int y2 = coo[3];
		boolean res = false;
		if (this.confirmerMot(x1, y1, x2, y2, d)) {
			if(x1==x2) {
				for (int i=y1; i <= y2; i++) {
					if (this.isMotToucherV(x1, i)) {
						int[] coord = this.MotToucherV(x1, i);
						int X1 = coord[0];
						int Y1 = coord[1];
						int X2 = coord[2];
						int Y2 = coord[3];
						if (this.confirmerMot(X1, Y1, X2, Y2, d)) {
							res = true;
						}else {
							return false;
						}
					}
				}
			}
			if(y1==y2) {
				for (int j=x1; j <= x2; j++) {
					if (this.isMotToucherH(j, y1)) {
						int[] coord = this.MotToucherH(j, y1);
						int X1 = coord[0];
						int Y1 = coord[1];
						int X2 = coord[2];
						int Y2 = coord[3];
						if (this.confirmerMot(X1, Y1, X2, Y2, d)) {
							res = true;
						}else {
							return false;
						}
					}
				}
			}
		}else {
			return false;
		}
		return res;
	}
}





	