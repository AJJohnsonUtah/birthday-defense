package towers;

public abstract class Tower {
	private Position position;
	private double radius;
	private double rangeRadius;
	
	public Position getCenterPosition() {;
		return position;
	}
	
	public Position getTopLeftPosition() {
		return new Position(radius + position.xPos, radius + position.yPos);
	}
	
	public void setPosition(Position pos) {
		position = pos;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double rad) {
		radius = rad;
	}
	
	public double getRange() {
		return rangeRadius;
	}
	
	public void setRange(double range) {
		rangeRadius = range;
	}
}
