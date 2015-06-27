/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import game.Game;
import map.MapType;

/**
 *
 * @author AJ
 */
public class BirthdayDefenseController {
    private Game activeGame;
    
    public BirthdayDefenseController() {
        activeGame = null;
    }
    
    public Game getActiveGame() {
        return activeGame;
    }
    
    public void startNewGame() {
        activeGame = new Game(MapType.CAKE);
    }
}
