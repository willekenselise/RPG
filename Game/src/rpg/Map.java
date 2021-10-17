package rpg;

import java.util.Random;

public class Map {
	
	public final int MONSTERS = 25;
	public final int OBSTACLES = 18;
	
	private Tile [][] map = new Tile[10][10];
	private Tile player;

	public Map(Character player) {
		for (int y=0; y < this.map[0].length; y++) { 
			for (int x=0; x < this.map.length; x++) {
				this.map[x][y] = new Tile(x, y, ".");
			}
		}
		this.monstersGeneration();
		this.obstaclesGeneration();
		this.player = new Tile(0, this.map[0].length-1, player);
		this.map[0][this.map[0].length-1] = this.player;
	}
	
	private void monstersGeneration() {
		int occupiedSpots = 0;
		Random random = new Random();

		while(occupiedSpots < this.MONSTERS){
		    int x = random.nextInt(this.map.length);
		    int y = random.nextInt(this.map[0].length);
		    if(this.map[x][y].getType() == "."){
		        this.map[x][y] = new Tile(x, y, new Enemy(30));
		        occupiedSpots++;
		    }
		}
	}
	
	private void obstaclesGeneration() {
		int occupiedSpots = 0;
		Random random = new Random();

		while(occupiedSpots < this.OBSTACLES){
		    int x = random.nextInt(this.map.length);
		    int y = random.nextInt(this.map[0].length);
		    if(this.map[x][y].getType() == "."){
		        this.map[x][y] = new Tile(x, y, new Obstacle());
		        occupiedSpots++;
		    }
		}
	}
	
	public void displayMap() {
		for (int y=0; y < this.map[0].length; y++) {
			for (int x=0; x < this.map.length; x++) {
				System.out.print(this.map[x][y].getType());			
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean movePlayer(String direction) {
		
		if (this.player.canMove(direction)) {
						
			int x = this.player.getX();
			int y = this.player.getY();
			
			int newX = x;
			int newY = y;	
			String sym = new String();
			
			switch (direction) {
			case "h":
				sym = this.map[x][y-1].getType();	
				if(this.action(sym)) {
					this.map[x][y-1] = this.player;
					newY--;
					this.map[x][y] = new Tile(x, y, ".");
					this.player.move(newX, newY);
				}
				break;
			case "b":
				sym = this.map[x][y+1].getType();	
				if(this.action(sym)) {
					this.map[x][y+1] = this.player;
					newY++;
					this.map[x][y] = new Tile(x, y, ".");
					this.player.move(newX, newY);
				}
				break;
			case "g":
				sym = this.map[x-1][y].getType();
				if(this.action(sym)) {
					this.map[x-1][y] = this.player;
					newX--;
					this.map[x][y] = new Tile(x, y, ".");
					this.player.move(newX, newY);
				};
				break;
			case "d":
				sym =this.map[x+1][y].getType();
				if(this.action(sym)) {
					this.map[x+1][y] = this.player;
					newX++;
					this.map[x][y] = new Tile(x, y, ".");
					this.player.move(newX, newY);
				}
				break;
			default:
				break;
			}
			return true;
		} else {
			return false;
		}
	}
	
	public boolean action(String symbole) {
		
		Boolean b = false;
		
		switch(symbole) {
		case ".":
			b = true;
			break;			
		case "o":
			System.out.println("\n<-- Obstacle -->");
			System.out.println("Impossible de passer!");
			b = false;
			break;	
		case "e":
			Character p = (Character) this.player.getEntity();
			if(p.fight()) {
				b = true;
			}else {
				b = false;
			}
			break;	
		}
		return b;
	}
	
	public boolean endofgame() {
		if(map[9][0].getType()=="H" || map[9][0].getType()=="S" || map[9][0].getType()=="E") {
			return true;
		}
		return false;
	}
		
}
