package towers;

public class Position {

    double xPos, yPos;

    public Position(double x, double y) {
        xPos = x;
        yPos = y;
    }

    public double getXPosition() {
        return xPos;
    }

    public double getYPosition() {
        return yPos;
    }

    public double getDistanceToPosition(Position otherPosition) {
        double deltaX = getXPosition() - otherPosition.getXPosition();
        double deltaY = getYPosition() - otherPosition.getYPosition();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public Position getPositionAtRatioBetweenPositions(Position destination, double ratioOfDistance) {
        double deltaX = getXPosition() - destination.getXPosition();
        double deltaY = getYPosition() - destination.getYPosition();
        return new Position((ratioOfDistance * deltaX)+ getXPosition(), (ratioOfDistance * deltaY) + getYPosition());
    }
}
