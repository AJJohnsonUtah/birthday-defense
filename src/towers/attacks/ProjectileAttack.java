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
public interface ProjectileAttack {
    
    public double getSpeedOfAttack();
    public void updatePositionOfProjectile(long timeElapsed);
    
}
