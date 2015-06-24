/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towers.attacks;

import towers.Position;

/**
 *
 * @author AJ
 */
public class FixedVelocityVector {

    private final double horizontalMagnitude;
    private final double verticalMagnitude;

    public static final FixedVelocityVector ZERO_VECTOR = new FixedVelocityVector(0, 0);

    public FixedVelocityVector(Position startPosition, Position targetPosition, double speed) {
        double xDelta = targetPosition.getXPosition() - startPosition.getXPosition();
        double yDelta = targetPosition.getYPosition() - startPosition.getYPosition();
        double distance = Math.sqrt(xDelta * xDelta + yDelta * yDelta);
        if (distance == 0) {
            horizontalMagnitude = 0;
            verticalMagnitude = 0;
        } else {
            double speedToDistanceRatio = speed / distance;
            horizontalMagnitude = speedToDistanceRatio * xDelta;
            verticalMagnitude = speedToDistanceRatio * yDelta;
        }        
    }

    private FixedVelocityVector(double horizontal, double vertical) {
        horizontalMagnitude = horizontal;
        verticalMagnitude = vertical;
    }
    
    public double getHorizontalMagnitude() {
        return horizontalMagnitude;        
    }
    
    public double getVerticalMagnitude() {
        return verticalMagnitude;
    }
}
