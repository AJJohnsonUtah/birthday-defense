package enemies;

import map.Path;
import map.PathPosition;
import map.Tangible;
import map.TangibleArea;
import towers.Position;
import towers.attacks.TowerAttack;

public abstract class Enemy implements Tangible {

    private PathPosition pathPosition;
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
        pathPosition.setPosition(pos);
    }

    public void setPathPosition(PathPosition pathPos) {
        pathPosition = pathPos;
    }
    
    public PathPosition getPathPosition() {
        return pathPosition;
    }

    public Position getPosition() {
        return pathPosition.getPosition();
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
        return new TangibleArea(getSize(), getPosition());
    }

    public double getValue() {
        return value;
    }

    protected void setValue(double val) {
        value = val;
    }

    public void updatePosition(Path path, long timeElapsed) {
        double unitsToMove = getUnitsToMove(timeElapsed);
        Position nextPosition = path.getPathPositionAtIndex(pathPosition.getPathIndex() + 1);
        while (unitsToMove > 0) {
            double unitsToNextPosition = pathPosition.getPosition().getDistanceToPosition(nextPosition);
            // If moving within pathPositions, setPosition to new proportional position
            if (unitsToMove <= unitsToNextPosition) {
                setPosition(getPosition().getPositionAtRatioBetweenPositions(nextPosition, unitsToMove/unitsToNextPosition));
                break;
            } else {
                unitsToMove -= unitsToNextPosition;
                setPathPosition(path.getNextPathPosition(pathPosition));
            }
        }
    }

    private double getUnitsToMove(long timeElapsed) {
        return timeElapsed * moveSpeed;
    }
}
