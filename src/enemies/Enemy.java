package enemies;

import map.Tangible;
import map.TangibleArea;
import towers.Position;
import towers.attacks.TowerAttack;

public abstract class Enemy implements Tangible{
	private Position position;
	private double moveSpeed;
	private double health;
	private double size;
        private double value;
        
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
        
        public void setSize(double s) {
            size = s;
        }
        
        public double getSize() {
            return size;
        }               
        
        public void performAttackInteraction(TowerAttack attack) {
            health -= attack.getAttackDamage();
            attack.countEnemyHitByAttack();
        }
        
        @Override
        public TangibleArea getTangibleArea() {
            return new TangibleArea(size, position);
        }
        
        public double getValue() {
            return value;
        }
        
        protected void setValue(double val) {
            value = val;
        }
}
