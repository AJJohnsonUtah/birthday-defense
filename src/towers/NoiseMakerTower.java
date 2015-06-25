package towers;

import enemies.Enemy;
import java.util.ArrayList;
import java.util.List;
import towers.attacks.NoiseMakerAttack;
import towers.attacks.TowerAttack;

public class NoiseMakerTower extends AttackingTower {

    private long timeBetweenAttacks;
    
    public NoiseMakerTower(Position centerOfTower) {
        super(centerOfTower);     
        timeBetweenAttacks = 500000L;
    }
    
    @Override
    public long getTimeBetweenAttacks() {
        return timeBetweenAttacks;
    }

    @Override
    public void setTimeBetweenAttacks(long time) {
        timeBetweenAttacks = time;
    }

    @Override
    public long timeOfLastAttack() {
        return timeOfLastAttack;
    }

    @Override
    public void setTimeOfLastAttack(long time) {
        timeOfLastAttack = time;
    }

    @Override
    public void attack() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean areAttacksProjectiles() {
        return true;
    }

    @Override
    public List<TowerAttack> attack(Enemy target) {
        List<TowerAttack> towerAttacks = new ArrayList<>();
        towerAttacks.add(new NoiseMakerAttack(this, target));
        return towerAttacks;
    }

    @Override
    protected double getDefaultRange() {
        return 200;
    }

    @Override
    protected double getDefaultSize() {
        return 75;
    }

}
