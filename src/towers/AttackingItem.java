package towers;

import enemies.Enemy;
import java.util.List;
import towers.attacks.TowerAttack;

public interface AttackingItem {	
	
	public long getTimeBetweenAttacks();
	public void setTimeBetweenAttacks(long time);
	public long timeOfLastAttack();
	public void setTimeOfLastAttack(long time);
	public void attack();
	public List<TowerAttack> attack(Enemy target);
}
