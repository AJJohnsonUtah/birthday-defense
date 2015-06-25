/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towers.attacks;

import map.Tangible;
import map.TangibleArea;
import towers.Position;
import towers.Tower;

/**
 *
 * @author AJ
 */
public abstract class TowerAttack implements Tangible {
    protected Position positionOfAttack;
    protected double sizeOfAttack;
    protected double attackDamage;
    protected Tower parent;
    protected int numberOfEnemiesAttackCanHit;
    
    protected void setSizeOfAttack(double size) {
        sizeOfAttack = size;
    }
    
    protected void setPositionOfAttack(Position position) {
        positionOfAttack = position;
    }
    
    public Position getPositionOfAttack() {
        return positionOfAttack;
    }
    
    public double getAttackDamage() {
        return attackDamage;
    }
    
    public double getSizeOfAttack() {
        return sizeOfAttack;
    }
    
    protected void setParentTower(Tower parentTower) {
        parent = parentTower;
    }
    
    public Tower getTower() {
        return parent;
    }
    
    public void countEnemyHitByAttack() {
        numberOfEnemiesAttackCanHit--;
    }
    
    public boolean canHitMoreEnemies() {
        return numberOfEnemiesAttackCanHit > 0;
    }
    
    @Override
    public TangibleArea getTangibleArea() {
        return new TangibleArea(sizeOfAttack, positionOfAttack);
    }
}