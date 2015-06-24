package towers;

import enemies.Enemy;

public class EnemySpawnTimePair {
	Enemy enemy;
	long spawnTime;
	
	public EnemySpawnTimePair(Enemy en, long time) {
		enemy = en;
		spawnTime = time;
	}
	
	public long getSpawnTime() {
		return spawnTime;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
}
