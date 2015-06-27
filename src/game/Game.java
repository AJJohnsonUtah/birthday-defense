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
    private long lives;
    private GameOutcome gameStatus;

    public Game(MapType mapType) {
        map = new Map(mapType);
        gameTimer = new GameTimer();
        currency = 1000;
        lives = 25;
        gameStatus = GameOutcome.IN_PROGRESS;
    }

    public void startGame() {
        gameTimer.startTimer();
        timeOfLastUpdate = 0L;
    }

    public void updateGameModel() {
        long timeOfThisUpdate = gameTimer.getTime();
        currency += map.handleAttackEnemyInteractions();
        map.haveTowersAttackIfAble(timeOfThisUpdate);
        map.spawnEnemiesForGivenTime(timeOfThisUpdate);
        map.updateAttackPositions(timeOfThisUpdate - timeOfLastUpdate);
        handleLostLives(map.updateEnemyPositions(timeOfThisUpdate - timeOfLastUpdate));
        timeOfLastUpdate = timeOfThisUpdate;
        updateForEndConditions();
    }

    public boolean gameIsInProgress() {
        return gameTimer.getStartTime() > 0 && map.hasEnemiesRemainingInMap();
    }

    public void updateForEndConditions() {
        if (lives == 0) {
            gameStatus = GameOutcome.LOSS;
        } else if (map.hasEnemiesRemainingInMap()) {
            gameStatus = GameOutcome.WIN;
        }
    }

    public void handleLostLives(long livesLost) {
        if (livesLost > lives) {
            lives = 0;
        } else {
            lives -= livesLost;
        }
    }
    
    public String getCurrency() {
        return "" + currency;
    }
    
    public String getNumberOfEnemies() {
        return "" + map.getNumberOfEnemiesOnMap();
    }
    
    public String getLives() {
        return "" + lives;
    }
}
