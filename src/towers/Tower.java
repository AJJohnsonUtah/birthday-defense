package towers;

import map.Tangible;
import map.TangibleArea;

public abstract class Tower implements Tangible {

    protected Position position;
    protected double radius;
    protected double rangeRadius;

    public Tower(Position center) {
        position = center;
        radius = getDefaultSize();
        rangeRadius = getDefaultRange();
    }
    
    public Position getCenterPosition() {
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
    
    @Override
    public TangibleArea getTangibleArea() {
        return new TangibleArea(radius, position);
    }
    
    protected abstract double getDefaultRange();
    protected abstract double getDefaultSize();
    
}
