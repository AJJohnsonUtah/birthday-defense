package towers;

import enemies.Enemy;

public interface AttackingItem {	
	
	public double getAttackSpeed();
	public void setAttackSpeed(double speed);
	public long timeOfLastAttack();
	public void setTimeOfLastAttack(long time);
	public void attack();
	public void attack(Enemy target);
}
