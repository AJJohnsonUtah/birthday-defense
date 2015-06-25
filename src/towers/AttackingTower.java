package towers;

import enemies.Enemy;
import java.util.List;
import towers.attacks.TargetingStrategy;
import towers.attacks.TowerAttack;

public abstract class AttackingTower extends Tower {

    protected long timeOfLastAttack;
    protected TargetingStrategy targetingStrategy;

    public AttackingTower(Position centerPosition) {
        super(centerPosition);
    }
    
    public abstract long getTimeBetweenAttacks();

    public abstract void setTimeBetweenAttacks(long time);

    public long timeOfLastAttack() {
        return timeOfLastAttack;
    }

    public abstract boolean areAttacksProjectiles();

    public abstract void setTimeOfLastAttack(long time);

    public abstract void attack();

    public abstract List<TowerAttack> attack(Enemy target);

    public void setTargetingStrategy(TargetingStrategy strategy) {
        targetingStrategy = strategy;
    }

    public TargetingStrategy getTargetingStrategy() {
        return targetingStrategy;
    }

    public boolean canAttackAtGivenTime(long time) {
        return (time - timeOfLastAttack) > getTimeBetweenAttacks();
    }
}
