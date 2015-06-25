/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemies;

import java.util.Comparator;

/**
 *
 * @author AJ
 */
public class EnemyHealthComparator implements Comparator<Enemy>{

    @Override
    public int compare(Enemy e1, Enemy e2) {
        return (int)(e2.getHealth() - e1.getHealth());
    }
    
}
