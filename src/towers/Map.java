package towers;

import java.util.HashSet;
import java.util.Set;

import enemies.Enemy;

public class Map {
	private Set<Tower> towers;
	private Path path;
	private Set<Enemy> enemies;
	private EnemySpawnSpecification spawnSpecification;
	
	public Map() {
		towers = new HashSet<Tower>();
		enemies = new HashSet<Enemy>();
	}
	
	public boolean addTower(Tower tower) {
		return towers.add(tower);
	}
	
	public boolean removeTower(Tower tower) {
		return towers.remove(tower);
	}
	
	public Path getPath() {
		return path;
	}
	
	public void setPath(Path p) {
		path = p;
	}
	
}
