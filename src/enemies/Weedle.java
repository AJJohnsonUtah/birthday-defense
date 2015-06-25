package enemies;

import towers.Position;

public class Weedle extends Enemy{
	
	public Weedle(Position spawnPoint) {
		setPosition(spawnPoint);
		setHealth(50);
		setMoveSpeed(50);
                setValue(100);
	}
}
