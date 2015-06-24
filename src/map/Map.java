package map;

import java.util.HashSet;
import java.util.Set;

import enemies.Enemy;
import towers.Tower;
import towers.attacks.TowerAttack;

public class Map {

    private Set<Tower> towers;
    private Set<Enemy> enemies;
    private Set<TowerAttack> towerAttacks;
    private Path path;
    private EnemySpawnSpecification spawnSpecification;
    
    public Map(MapType mapType) {
        towers = new HashSet<>();
        enemies = new HashSet<>();
        towerAttacks = new HashSet<>();
        path = new Path(mapType);
        spawnSpecification = new EnemySpawnSpecification(mapType, path.getStart());        
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

    public boolean hasEnemiesRemainingInMap() {
        return enemies.size() > 0 || spawnSpecification.hasEnemiesRemaining();
    }

    public void spawnEnemiesForGivenTime(long time) {
        for (Enemy enemy : spawnSpecification.getEnemiesToSpawnAtGivenTime(time)) {
            enemies.add(enemy);
        }
    }

    public void haveTowersAttackIfAble(long time) {
        for (Tower tower : towers) {

        }
    }
}
