package towers;

import enemies.Enemy;

public class NoiseMakerTower extends Tower implements AttackingItem {
	
	private double attackSpeed;
	private long timeOfLastAttack;
	
	@Override
	public double getAttackSpeed() {
		return attackSpeed;
	}

	@Override
	public void setAttackSpeed(double speed) {
		attackSpeed = speed;	
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
	public void attack(Enemy target) {
		// TODO Auto-generated method stub
		
	}
	
}
