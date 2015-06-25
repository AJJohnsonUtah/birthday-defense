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
    private long timeOfLastUpdate;
    
    public Game(MapType mapType){
        map = new Map(mapType);
        gameTimer = new GameTimer();
    }
    
    public void startGame() {
        gameTimer.startTimer();        
        timeOfLastUpdate = 0L;
    }
    
    public void updateGame() {        
        long timeOfThisUpdate = gameTimer.getTime();
        map.spawnEnemiesForGivenTime(gameTimer.getTime());
        map.updateAttackPositions(timeOfThisUpdate - timeOfLastUpdate);
        currency += map.handleAttackEnemyInteractions();
        map.haveTowersAttackIfAble(gameTimer.getTime());
        timeOfLastUpdate = timeOfThisUpdate;
    }
    
    public boolean gameIsInProgress() {
        return gameTimer.getStartTime() > 0 && map.hasEnemiesRemainingInMap();
    }   
}
