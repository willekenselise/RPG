package rpg;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Weapon> w = new ArrayList<Weapon>();
		w.add(new Wand(60, 80));
		w.add(new Bow(45, 65));
		w.add(new Swords(20, 25));
		Game g = new Game(sc, w);
		g.play();
	}
}
