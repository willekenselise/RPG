package rpg;

public class Enemy extends Destructible {
	
	final double RATIO = 1.2;
	private double damage;

	public Enemy(double d) {
		super(100, "e", 50);
		this.damage = d;
	}
	
	public double getDamage() {
		return this.damage;
	}
	
	public void loseLife(double d) {
		this.life -= d * this.RATIO;
	}

}
