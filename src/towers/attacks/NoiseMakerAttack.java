/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towers.attacks;

import enemies.Enemy;
import towers.NoiseMakerTower;
import towers.Position;

/**
 *
 * @author AJ
 */
public class NoiseMakerAttack extends ProjectileAttack {

    private double speedOfAttack;
    private FixedVelocityVector velocityVector;

    public NoiseMakerAttack(NoiseMakerTower parentTower, Enemy target) {
        speedOfAttack = 150;
        setSizeOfAttack(15);
        numberOfEnemiesAttackCanHit = 1;
        attackDamage = 20;
        setPositionOfAttack(parentTower.getCenterPosition());
        velocityVector = new FixedVelocityVector(getPositionOfAttack(), target.getPosition(), speedOfAttack);
    }

    @Override
    public double getSpeedOfAttack() {
        return speedOfAttack;
    }

    @Override
    public void updatePositionOfProjectile(long timeElapsed) {
        setPositionOfAttack(new Position(getPositionOfAttack().getXPosition() + velocityVector.getHorizontalMagnitude() * timeElapsed,
                getPositionOfAttack().getYPosition() + velocityVector.getVerticalMagnitude() * timeElapsed));
    }
}
