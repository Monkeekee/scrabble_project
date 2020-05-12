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
		String res = Integer.toString(this.NbrJoueur) + " joueurs \n";
		
		for (ArrayList<cell> l : this.plateau) { //initialisation des cases du plateau
			res = res +"\n";
			
			for (cell c : l) {
				//res = res + Integer.toString(c.value);
				res = res + c.toString();
				//la value est déterminee par le Plateau de Modèle
			}
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
		this.plateau.get(x).get(y).x=x ;
		this.plateau.get(x).get(y).y=y ;
		this.plateau.get(x).get(y).letter=lettre;
		this.plateau.get(x).get(y).occupied=true;
		this.J_actif.main.remove(lettre);
	}
	
	public String motEntre(int x1, int y1, int x2, int y2) {
		String mot = "";
		if (x1 == x2) {
			for (int i = y1 ; y1 <= y2 ; i++ ) {
				mot = mot + this.plateau.get(x1).get(i).letter;
			}
		}
		if (y2 == y1) {
			for (int i = x1 ; x1 <= x2 ; i++ ) {
				mot = mot + this.plateau.get(i).get(y1).letter;
			}
		}
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
	
	public void actuScore(int x1, int y1, int x2, int y2) {
		this.J_actif.score+=this.ptsMot(x1, y1, x2, y2);
		char dir;
		if (x1==x2) {
			dir='V';
			if(y2-y1==7) {
				this.J_actif.score += 50;
			}
			for (int i = y1 ; y1 <= y2 ; i++ ) {
				this.J_actif.score += this.ptsMot(this.Touchemot(x1, i, dir)[0], this.Touchemot(x1, i, dir)[2], this.Touchemot(x1, i, dir)[1], this.Touchemot(x1, i, dir)[3]);
			}
		}
		if (y1==y2) {
			dir='H';
			if(x2-x1==7) {
				this.J_actif.score += 50;
			}
			for (int i = x1 ; x1 <= x2 ; i++ ) {
				this.J_actif.score += this.ptsMot(this.Touchemot(i, y1, dir)[0], this.Touchemot(i, y1, dir)[2], this.Touchemot(i, y1, dir)[1], this.Touchemot(i, y1, dir)[3]);
			}
		}

	}
	
	public int ptsMot(int x1,int y1, int x2,int y2) {
		int points = 0;
		int multiplicateur = 1;
		if (x1 == x2) {
			for (int i = y1 ; y1 <= y2 ; i++ ) {
				if(this.plateau.get(x1).get(i).checked==false) {
					if(Modele.Plateau[x1][i]==1) {
						points += this.PtsLettre.get(this.plateau.get(x1).get(i).letter)*2;
					}
					if(Modele.Plateau[x1][i]==3) {
						points += this.PtsLettre.get(this.plateau.get(x1).get(i).letter)*3;
					}
					if(Modele.Plateau[x1][i]==2) {
						multiplicateur = 2;
					}
					if(Modele.Plateau[x1][i]==4) {
						multiplicateur = 3;
					}
				}else {
					if(Modele.Plateau[x1][i]==0) {
						points += this.PtsLettre.get(this.plateau.get(x1).get(i).letter);
					}
					
				}
			
			}
		}
		if (y1 == y2) {
			for (int i = x1 ; x1 <= x2 ; i++ ) {
				if(this.plateau.get(i).get(y1).checked==false) {
					if(Modele.Plateau[i][y1]==1) {
						points += this.PtsLettre.get(this.plateau.get(i).get(y1).letter)*2;
					}
					if(Modele.Plateau[i][y1]==3) {
						points += this.PtsLettre.get(this.plateau.get(i).get(y1).letter)*3;
					}
					if(Modele.Plateau[i][y1]==2) {
						multiplicateur = 2;
					}
					if(Modele.Plateau[i][y1]==4) {
						multiplicateur = 3;
					}
				}else {
					if(Modele.Plateau[i][y1]==0) {
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
				this.Touchemot(x, y2, 'H');
			}
			if(this.plateau.get(x).get(y-1).occupied) {
				y1+=-1;
				this.Touchemot(x, y1, 'H');
			}
		}
		if (direction == 'V') {
			if (this.plateau.get(x+1).get(y).occupied) {
				x2+=1;
				this.Touchemot(x2, y, 'V');
			}
			if(this.plateau.get(x-1).get(y).occupied) {
				x1+=-1;
				this.Touchemot(x1, y, 'V');
			}
		}
		if ( x1==x2 && y1==y2) {
			return null;
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
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < 15; i++) {
			
			for (int j = 0;j < 15; j++) {
				if (this.plateau.get(i).get(j).selec) {
					x=i;
					y=j;
				}
			}
		}
		int [] coo = {x,y};
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
		int x1 = 0;
		int y1 = 0;
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
}





	