package towers;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import enemies.Enemy;

public class EnemySpawnSpecification {
	
	private LinkedList<EnemySpawnTimePair> enemiesToSpawn;
	
	public Set<Enemy> getEnemiesToSpawnAtGivenTime(long time) {
		Set<Enemy> enemies = new HashSet<Enemy>();
		
		while(enemiesToSpawn.peekFirst().getSpawnTime() > time) {
			enemies.add(enemiesToSpawn.pop().getEnemy());
		}
		return Collections.emptySet();
	}
	
	public boolean hasEnemiesRemaining() {
		return enemiesToSpawn.size() > 0;
	}
}