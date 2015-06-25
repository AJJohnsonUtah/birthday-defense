/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import towers.Position;

/**
 *
 * @author AJ
 */
public class TangibleArea {
    
    double radius;
    Position centerOfArea;
    
    public TangibleArea(double rad, Position center) {
        radius = rad;
        centerOfArea = center;
    }
    
    public boolean isOverlapping(TangibleArea otherArea) {
        double combinedRadii = getRadius() + otherArea.getRadius();
        double deltaX = getPosition().getXPosition() - otherArea.getPosition().getXPosition();
        double deltaY = getPosition().getYPosition() - otherArea.getPosition().getYPosition();
        
        double distanceFromCenters = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
        return distanceFromCenters < combinedRadii;
    }
    
    private double getRadius() {
        return radius;
    }
    
    private Position getPosition() {
        return centerOfArea;
    }
    
}
