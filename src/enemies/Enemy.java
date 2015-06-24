package enemies;

import towers.Position;

public abstract class Enemy {
	private Position position;
	private double moveSpeed;
	private double health;
	
	public void setMoveSpeed(double speed) {
		moveSpeed = speed;	
	}
	
	public double getMoveSpeed() {
		return moveSpeed;
	}
	
	public void setPosition(Position pos) {
		position = pos;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setHealth(double h) {
		health = h;
	}
	
	public double getHealth() {
		return health;
	}
}
