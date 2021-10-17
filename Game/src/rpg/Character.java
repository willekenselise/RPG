package rpg;

import java.util.ArrayList;


public class Character extends Entity {
	
	protected String name;
	protected double money;
	protected ArrayList<Weapon> inventory;

	public Character(String name, double l, double m, double xp, String t) {
		this.name = name;
		this.life = l;
		this.money = m;
		this.xp = xp;
		this.inventory = new ArrayList<Weapon>();
		this.type = t;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getMoney() {
		return this.money;
	}

	public ArrayList<Weapon> getInventory() {
		return this.inventory;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void buy(Weapon w) {
		this.money -= w.getPrice();
		this.inventory.add(w);
		this.winLife(50);
	}

	@Override
	public String toString() {
		return "Personnage : " + this.name + " - " + this.money + "€ - " + this.xp + "xp";
	}

	@Override
	public void loseLife(double d) {
		this.life -= d;	
	}
	
	public void winLife(double nb) {
		this.life += nb;
	}
	
	public boolean fight() {
		System.out.println("\n<-- Fight -->");
		this.xp+=50;
		this.loseLife(50);
		if (this.life <= 0) {
			System.out.println("Vous êtes mort! \n Vous avez " + this.life + " hp et " + this.xp + "xp");
			return false;
		} else {
			System.out.println("Vous avez gagné le combat! \nVous avez " + this.life + " hp et " + this.xp + "xp");
			return true;
		}
	}
	
	
}
