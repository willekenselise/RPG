package rpg;

import java.util.ArrayList;

public class WeaponShop {
	
	private ArrayList<Weapon> weapons;

	public WeaponShop(ArrayList<Weapon> w) {
		this.weapons = new ArrayList<Weapon>();
		this.weapons = w;
	}
	
	public ArrayList<Weapon> getWeapons() {
		return this.weapons;
	}
	
	public Weapon getWeapon(int i) {
		return this.weapons.get(i);
	}
	
	public int getNumberOfItems() {
		return this.weapons.size();
	}
	
	public void displayShop() {
		int i = 0;
		for (Weapon weapon : this.weapons) {
			System.out.println(weapon.getName() + "(" + i++ + ")");
			System.out.println(weapon.ascii_art());
			
		}
	}
}
