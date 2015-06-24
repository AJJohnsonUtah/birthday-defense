package towers;

import enemies.Enemy;
import java.util.ArrayList;
import java.util.List;
import towers.attacks.NoiseMakerAttack;
import towers.attacks.TowerAttack;

public class NoiseMakerTower extends Tower implements AttackingItem {

    private long timeBetweenAttacks;
    private long timeOfLastAttack;

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
    public List<TowerAttack> attack(Enemy target) {
        List<TowerAttack> towerAttacks = new ArrayList<>();
        towerAttacks.add(new NoiseMakerAttack(this, target));
        return towerAttacks;
    }

}
