/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towers.attacks;

/**
 *
 * @author AJ
 */
public abstract class ProjectileAttack extends TowerAttack {

    abstract public double getSpeedOfAttack();
    abstract public void updatePositionOfProjectile(long timeElapsed);
}
