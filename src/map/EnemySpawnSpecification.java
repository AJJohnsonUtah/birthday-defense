package map;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import enemies.Enemy;
import enemies.Weedle;
import towers.Position;

public class EnemySpawnSpecification {

    private LinkedList<EnemySpawnTimePair> enemiesToSpawn;

    public EnemySpawnSpecification(MapType mapType, Position startPosition) {
        enemiesToSpawn = new LinkedList<>();
        switch (mapType) {
            case CAKE:
                enemiesToSpawn.push(new EnemySpawnTimePair(new Weedle(startPosition), 1000000L));
                enemiesToSpawn.push(new EnemySpawnTimePair(new Weedle(startPosition), 2000000L));
                enemiesToSpawn.push(new EnemySpawnTimePair(new Weedle(startPosition), 3000000L));
                enemiesToSpawn.push(new EnemySpawnTimePair(new Weedle(startPosition), 4000000L));
                enemiesToSpawn.push(new EnemySpawnTimePair(new Weedle(startPosition), 5000000L));
                break;
            case TABLE:                
                break;
            default:
                enemiesToSpawn = null;
        }
    }

    public Set<Enemy> getEnemiesToSpawnAtGivenTime(long time) {
        Set<Enemy> enemies = new HashSet<>();

        while (enemiesToSpawn.peekFirst().getSpawnTime() > time) {
            enemies.add(enemiesToSpawn.pop().getEnemy());
        }        
        return enemies;
    }

    public boolean hasEnemiesRemaining() {
        return enemiesToSpawn.size() > 0;
    }
}
