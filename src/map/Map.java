package map;

import java.util.HashSet;
import java.util.Set;

import enemies.Enemy;
import enemies.EnemyHealthComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import towers.AttackingTower;
import towers.Tower;
import towers.attacks.ProjectileAttack;
import towers.attacks.TowerAttack;

public class Map {

    private Set<AttackingTower> attackingTowers;
    private Set<Enemy> enemies;
    private Set<ProjectileAttack> projectileAttacks;
    private Set<TowerAttack> nonProjectileAttacks;
    private Path path;
    private EnemySpawnSpecification spawnSpecification;

    public Map(MapType mapType) {
        attackingTowers = new HashSet<>();
        enemies = new HashSet<>();
        projectileAttacks = new HashSet<>();
        nonProjectileAttacks = new HashSet<>();
        path = new Path(mapType);
        spawnSpecification = new EnemySpawnSpecification(mapType, path.getStart());
    }

    public boolean addAttackingTower(AttackingTower tower) {
        return attackingTowers.add(tower);
    }

    public boolean removeAttackingTower(AttackingTower tower) {
        return attackingTowers.remove(tower);
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
        for (AttackingTower attackingTower : attackingTowers) {
            if (attackingTower.canAttackAtGivenTime(time)) {
                if (attackingTower.areAttacksProjectiles()) {
                    for (TowerAttack attack : attackingTower.attack(selectTargetForTower(attackingTower))) {
                        projectileAttacks.add((ProjectileAttack) attack);
                    }
                } else {
                    nonProjectileAttacks.addAll(attackingTower.attack(selectTargetForTower(attackingTower)));
                }
            }
        }
    }

    public void updateAttackPositions(long timeElapsed) {
        for (ProjectileAttack projectileAttack : projectileAttacks) {
            projectileAttack.updatePositionOfProjectile(timeElapsed);
        }
    }

    public double handleAttackEnemyInteractions() {
        double currencyGainedFromThisUpdate = 0;
        for (Iterator<TowerAttack> attackIterator = nonProjectileAttacks.iterator(); attackIterator.hasNext();) {
            TowerAttack currentAttack = attackIterator.next();
            List<Enemy> enemiesOverlappingAttack = getEnemiesThatAttackIsTouching(currentAttack);
            if (!enemiesOverlappingAttack.isEmpty()) {
                currencyGainedFromThisUpdate += carryOutCollision(currentAttack, enemiesOverlappingAttack);
            }
            if (!currentAttack.canHitMoreEnemies()) {
                attackIterator.remove();
            }
        }

        for (Iterator<ProjectileAttack> attackIterator = projectileAttacks.iterator(); attackIterator.hasNext();) {
            TowerAttack currentAttack = attackIterator.next();
            List<Enemy> enemiesOverlappingAttack = getEnemiesThatAttackIsTouching(currentAttack);
            if (!enemiesOverlappingAttack.isEmpty()) {
                currencyGainedFromThisUpdate += carryOutCollision(currentAttack, enemiesOverlappingAttack);
            }
            if (!currentAttack.canHitMoreEnemies()) {
                attackIterator.remove();
            }
        }
        return currencyGainedFromThisUpdate;
    }

    public double carryOutCollision(TowerAttack attack, List<Enemy> enemiesHitByAttack) {
        double currencyGainedFromCollision = 0;
        for (Enemy enemy : enemiesHitByAttack) {
            if (attack.canHitMoreEnemies()) {
                enemy.performAttackInteraction(attack);
                if (enemy.getHealth() <= 0) {
                    currencyGainedFromCollision += enemy.getValue();
                    destroyEnemy(enemy);
                }
            }
        }
        return currencyGainedFromCollision;
    }

    public void destroyEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    private List<Enemy> getEnemiesInRangeOfTower(Tower tower) {
        List<Enemy> enemiesInRange = new ArrayList<>();
        for (Enemy enemy : enemies) {
            if (tower.getRange() >= tower.getCenterPosition().getDistanceToPosition(null)) {
                enemiesInRange.add(enemy);
            }
        }
        return enemiesInRange;

    }

    private Enemy selectTargetForTower(AttackingTower tower) {
        List<Enemy> targetableEnemies = getEnemiesInRangeOfTower(tower);
        switch (tower.getTargetingStrategy()) {
            // TODO: Fill in.            
            case FIRST:
                return targetableEnemies.get(0);
            case HIGHEST_HEALTH:
                Collections.sort(targetableEnemies, new EnemyHealthComparator());
                return targetableEnemies.get(0);
            case LAST:
                return targetableEnemies.get(targetableEnemies.size() - 1);
            case LOWEST_HEALTH:
                Collections.sort(targetableEnemies, new EnemyHealthComparator());
                return targetableEnemies.get(targetableEnemies.size() - 1);
            case TARGET_CLOSEST: ;
            default:
                throw new IllegalArgumentException(tower.getTargetingStrategy().name() + " is not a valid targeting strategy.");
        }
    }

    private List<Enemy> getEnemiesThatAttackIsTouching(TowerAttack attack) {
        List<Enemy> enemiesTouchingAttack = new ArrayList<>();
        for (Enemy enemy : enemies) {
            if (enemy.getTangibleArea().isOverlapping(attack.getTangibleArea())) {
                enemiesTouchingAttack.add(enemy);
            }
        }
        return enemiesTouchingAttack;
    }

    public long updateEnemyPositions(long timeOfThisUpdate) {
        long numberOfEnemiesThatReachedEnd = 0;
        for (Iterator<Enemy> enemyIterator = enemies.iterator(); enemyIterator.hasNext();) {
            Enemy enemy = enemyIterator.next();
            enemy.updatePosition(path, timeOfThisUpdate);
            if (isEnemyAtEndOfPath(enemy)) {
                numberOfEnemiesThatReachedEnd++;
                enemyIterator.remove();
            }
        }
        return numberOfEnemiesThatReachedEnd;
    }

    public boolean isEnemyAtEndOfPath(Enemy enemy) {
        if (path.hasNextPathPosition(enemy.getPathPosition())) {
            return false;
        }
        return true;
    }
}
