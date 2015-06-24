/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import map.Map;
import map.MapType;

/**
 *
 * @author AJ
 */
public class Game {
    private Map map;
    private GameTimer gameTimer;
    private long currency;
    
    public Game(MapType mapType){
        map = new Map(mapType);
        gameTimer = new GameTimer();
    }
    
    public void startGame() {
        gameTimer.startTimer();        
    }
    
    public void updateGame() {
        map.spawnEnemiesForGivenTime(gameTimer.getTime());
        map.haveTowersAttackIfAble(gameTimer.getTime());
    }
    
    public boolean gameIsInProgress() {
        return gameTimer.getStartTime() > 0 && map.hasEnemiesRemainingInMap();
    }   
}
