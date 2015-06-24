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
public abstract class TowerAttack {
    private Position positionOfAttack;
    private double sizeOfAttack;
    
    protected void setSizeOfAttack(double size) {
        sizeOfAttack = size;
    }
    
    protected void setPositionOfAttack(Position position) {
        positionOfAttack = position;
    }
    
    public Position getPositionOfAttack() {
        return positionOfAttack;
    }
    
    public double getSizeOfAttack() {
        return sizeOfAttack;
    }
}