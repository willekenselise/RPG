package rpg;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Scanner sc;
	private Map map;
	private WeaponShop shop;
	private Character player;

	public Game(Scanner sc, ArrayList<Weapon> w) {
		this.sc = sc;
		System.out.println("<--- Game ---> \n");
		System.out.println("Pour gagner, tu dois arriver en haut à droité de la map! Ton parcours sera jonché d'obstacle (o) et d'ennemie (e).");
		System.out.println("Tu perdras des hp à chacun de tes combats mais n'hésites pas à acheter des armes pour en récupérer et gagner des xp! \n");
		
		this.player = this.characterCreation();
		System.out.println(this.player);
		
		this.map = new Map(this.player);
		this.map.displayMap();
		this.shop = new WeaponShop(w);
	}

	public Character characterCreation() {
		int character = 0;
		Character player = null;
		do {
			System.out.println("Quelle personnage veux-tu ? (tapez le numéro associé)");
			System.out.println("Humain (1)");
			System.out.println("Sorcier (2)");
			System.out.println("Elfe (3)");
			character = this.sc.nextInt();
		} while (character != 1 && character != 2 && character != 3);
		
		System.out.println("Entrez un nom : ");
		this.sc.nextLine();
		String name = this.sc.nextLine();
		switch (character) {
			case 1:
				player = new Humain(name);
				break;
			case 2:
				player = new Sorcier(name);
				break;
			case 3:
				player = new Elfe(name);
				break;
			default:
				System.out.println("Quelle personnage veux-tu ? (tapez le numéro associé)");
				break;
		}
		return player;
	}
	
	public void play() {
		Boolean b = true;
		
		while (this.player.getLife() > 0 && b) {	
			
			if(this.map.endofgame()) {
				System.out.println("Vous avez gagné!");
				b = false;
			}
			
			else {
					
				int action;
				do {
					System.out.println("Que voulez-vous faire ? (tapez le nombre associé)");
					System.out.println("Acheter des armes (1) - Te déplacer (2)");
					action = this.sc.nextInt();
				} while (action != 1 && action != 2);
				this.sc.nextLine();
				//Achat armes
				if (action == 1) { this.shop(); }
				//Déplacement
				if (action == 2) { this.move(); }
			}
		}
		System.out.println("Fin de la partie");
	}
	
	private void shop() {
		int action;
		do {
			this.shop.displayShop();
			System.out.println("Quelle arme voulez-vous acheter : (tapez le nombre associé)");
			action = this.sc.nextInt();
		} while (action < 0 || action > this.shop.getNumberOfItems());
		this.sc.nextLine();
		double mo = this.player.getMoney() - this.shop.getWeapon(action).getPrice();
		if(mo <= 0) {
			System.out.println("Vous n'avez plus assez d'argent !");
		}else {
			this.player.buy(this.shop.getWeapon(action));
			System.out.println("Vous venez d'acheter une arme pour " + this.shop.getWeapon(action).getPrice() + "€. Vous avez gagné 50hp");
			System.out.println("Vous avez " + this.player.getLife() + "hp. Il vous reste " + this.player.getMoney() + "€");
		}
	}
	
	private void move() {
		String direction = "start";
		while (!this.map.movePlayer(direction)) {
			do {
				this.map.displayMap();
				System.out.println("Où voulez-vous aller ? (tapez la lettre associée)");
				System.out.println("En haut (h) - A gauche (g) - A droite (d) - En bas (b)");
				direction = this.sc.nextLine();
			} while (direction == "h" || direction == "g" || direction == "d" || direction == "b");
		}
	}
}
